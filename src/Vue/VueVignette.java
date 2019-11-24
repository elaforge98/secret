package Vue;

import Modele.Image;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Cette classe représente la vue pour les vignettes du menu principal
 */
public class VueVignette extends JButton {

    private final int X = 100;
    private final int Y = 100;
    private ImageIcon vignette;

    public VueVignette(Image image) throws IOException {

        creerVignette(image);
        setText(image.getNomImage());
        setIcon(vignette);
        setBorder(null);

    }

    public void creerVignette(Image image){
        BufferedImage i = image.getPhoto();
        vignette = new ImageIcon(i.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
    }

}
