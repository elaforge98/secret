package Vue;

import Controleur.*;
import Modele.Perspective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class PerspectiveDialog extends JDialog {

    private Perspective perspective;
    private VuePerspective vue;

    public PerspectiveDialog(Perspective perspective){

        this.perspective = perspective;
        vue = new VuePerspective(perspective);
        initDialog();
        initMouseListeners();
        initMouseWheelListener();

    }

    public void initDialog(){
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1800,1000));
        this.setTitle(perspective.getNom());
        this.setContentPane(vue);
        this.pack();
        this.setVisible(true);
    }

    private void initMouseListeners(){

        MouseAdapter translation = new MouseAdapter() {
            // Ce point représente la ou l'utilisateur clique la photo
            // La commande utilisée est celle de translation
            Point debut;
            CommandeTranslation commandeTranslation;

            /**
             * Evenement lorsque l'on clique sur la photo
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                debut = e.getPoint();
            }

            /**
             * Evenement lorsque l'on drag la photo
             * @param e
             */
            @Override
            public void mouseDragged(MouseEvent e) {

                commandeTranslation = new CommandeTranslation();
                // On calcule le déplacement de la souris en x et en y
                int dx = e.getPoint().x - debut.x;
                int dy = e.getPoint().y - debut.y;
                commandeTranslation.setDeplacement(dx, dy);
                commandeTranslation.execute(perspective);
                debut = e.getPoint();
                repaint();
                revalidate();
                System.out.println("ALALAL");
            }
        };
        addMouseListener(translation);
        addMouseMotionListener(translation);

    }

    private void initMouseWheelListener(){

        MouseAdapter zoom = new MouseAdapter() {
            /*
                Ce point représente la ou l'utilisateur roule la molette de la
                souris.
                La commande utilisée est celle de translation
             */


            //Point debut;
            CommandeZoom commandeZoom;
            float scale = 1;


            /**
             * Evenement lorsque l'on zoom la photo
             * @param e
             */
            @Override
            public void mouseWheelMoved (MouseWheelEvent e) {

                commandeZoom = new CommandeZoom();
                // On calcule le déplacement de la souris en x et en y
                double move = 0.05f * -(e.getPreciseWheelRotation());
                scale += move;
                System.out.println("ZOOM : " + scale);

                commandeZoom.setZoom(scale);
                commandeZoom.execute(perspective);
                repaint();
                revalidate();
                System.out.println("IOIOIOIOIO");
            }
        };
        addMouseWheelListener(zoom);
    }
}
