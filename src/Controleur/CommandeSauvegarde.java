package Controleur;

import Modele.MementoPerspective;
import Modele.Perspective;

public class CommandeSauvegarde implements Commande {

    @Override
    public void execute(Perspective perspective) {

    }

    @Override
    public MementoPerspective creerMemento() {

        return null;
    }
}
