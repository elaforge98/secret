package Vue;

import Modele.Model;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Cette interface va permettre d'affocher des vignettes pour chacune des images
 * dans le dossier Images
 */
public class Interface extends JFrame implements Runnable{

    private PanneauVignette panneau;
    private JButton refresh;
    private Model model = Model.getInstance();

    public Interface() throws IOException {

        super("Menu vignette");
        panneau = new PanneauVignette();
        initJFrame();

    }

    public void initJFrame() {

        this.setSize(1300, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setContentPane(panneau);
        /*refresh = new JButton("refresh");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panneau.removeAll();
                model.initListeImages();
                panneau.revalidate();
                panneau.repaint();

            }
        });
        this.add(refresh, BorderLayout.SOUTH);*/

    }

    @Override
    public void run() {

    }



}
