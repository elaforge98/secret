package Controleur;

import Modele.MementoPerspective;
import Modele.Perspective;

// Interface de tous les commandes possibles
public interface Commande {

    // Execute la commande
    public void execute(Perspective perspective);
    public MementoPerspective creerMemento();
}
