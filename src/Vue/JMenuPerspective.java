package Vue;

import Controleur.CommandeSauvegarde;
import Modele.Perspective;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuPerspective extends JMenuBar {

    Perspective perspective;

    public JMenuPerspective(Perspective perspective){

        this.perspective = perspective;

        JMenu menu = new JMenu("Fichier");
        JMenuItem save = new JMenuItem("Sauvegarder");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem redo = new JMenuItem("Redo");
        menu.add(save);
        menu.add(undo);
        menu.add(redo);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CommandeSauvegarde sauvegarde = new CommandeSauvegarde(perspective);
                sauvegarde.execute();
            }
        });

        add(menu);

    }

}
