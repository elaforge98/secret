package Vue;

import Controleur.CommandeSauvegarde;
import Modele.Image;
import Modele.Model;
import Modele.Perspective;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanneauVignette extends JPanel {

    private Model model = Model.getInstance();

    public PanneauVignette() throws IOException {

        setLayout(new FlowLayout());

        for(Image i : model.getListeImage()){

            VueVignette vue = new VueVignette(i);
            vue.addActionListener(e -> {


                // On crée un dialogue pour chaque perspective de l'image
                for(Perspective p : i.getListePerspective()){
                    CommandeSauvegarde commandeSauvegarde = new CommandeSauvegarde(p);
                    commandeSauvegarde.execute();
                    new PerspectiveDialog(p);
                }


            });

            add(vue);

        }

    }

}
