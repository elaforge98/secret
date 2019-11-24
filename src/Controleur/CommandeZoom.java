package Controleur;

import Modele.*;

public class CommandeZoom implements Commande {

    private GestionnaireCommande gestionnaire = GestionnaireCommande.getInstance();
    private float scale = 0;


    @Override
    public void execute(Perspective perspective) {
        MementoPerspective mementoPerspective = creerMemento();
        perspective.setState(mementoPerspective);

        /* On ajoute le mémento et la commande à leur liste respective dans
           gestionnaire
           de commande */
        gestionnaire.addMemento(mementoPerspective);
        gestionnaire.addCommande(this);
    }

    /**
     * Crée un mémento en fonction du dernier memento enregistrer, en ajoutant le
     * déplacement à la position donné par le memento.
     *
     * @return Le memento instancié
     */
    @Override
    public MementoPerspective creerMemento() {
        EtatImage stateInitial = gestionnaire.getLastMemento().getState();
        EtatImage stateFinal = new EtatImage(stateInitial.getX(),
                stateInitial.getY(), scale);
        return new MementoPerspective(stateFinal);
    }

    public void setZoom(float scale) {

        this.scale = scale;
    }
}
