package Controleur;

import Modele.*;

public class CommandeTranslation implements Commande{

    private int dx, dy;
    private GestionnaireCommande gestionnaire = GestionnaireCommande.getInstance();
    private Model model = Model.getInstance();
    private MementoPerspective mementoInitial;

    public CommandeTranslation(){
    }

    @Override
    public void execute(Perspective perspective) {

        MementoPerspective mementoPerspective = creerMemento();
        perspective.setState(mementoPerspective);
        /* On ajoute le mémento et la commande à leur liste respective dans gestionnaire
         de commande */
        gestionnaire.addMemento(mementoPerspective);

    }

    /**
     * Crée un mémento en fonction du dernier memento enregistrer, en ajoutant le
     * déplacement à la position donné par le memento.
     * @return Le memento instancié
     */
    @Override
    public MementoPerspective creerMemento() {
        EtatImage stateInitial = gestionnaire.getLastMemento().getState();
        EtatImage stateFinal = new EtatImage(stateInitial.getX() + dx,
                                             stateInitial.getY() + dy,
                                                stateInitial.getScale());
        return new MementoPerspective(stateFinal);
    }

    public void setDeplacement(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void debut(){
        mementoInitial = creerMemento();
    }

    public void terminer(){
        gestionnaire.addCommande(this);
    }

}
