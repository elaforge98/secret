package Vue;

import Controleur.GestionnaireCommande;
import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.pow;

/**
 * Ce panneau va contenir l'image que l'on veut afficher
 */
public class VuePerspective extends JPanel implements Observer {

    // Contient l'image que l'on veut afficher
    private Perspective perspective;

    public VuePerspective(Perspective perspective){

        this.perspective = perspective;
        this.perspective.attach(this);

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        EtatImage state = perspective.getState();
        BufferedImage photo = perspective.getImage().getPhoto();

        /*g.drawImage(photo, state.getX(), state.getY(),
                photo.getWidth() + (int)(photo.getWidth() * state.getScale()),
                photo.getHeight() + (int)(photo.getHeight() * state.getScale()),
                this);*/
        g.drawImage(photo, state.getX(), state.getY(),
                (int)(pow(photo.getWidth(), state.getScale())),
                (int)(pow(photo.getHeight(), state.getScale())),
                this);
    }

    @Override
    public void update() {
        repaint();
    }


}
