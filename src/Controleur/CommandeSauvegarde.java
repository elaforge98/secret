package Controleur;

import Modele.MementoPerspective;
import Modele.Perspective;

public class CommandeSauvegarde implements Commande {

    MementoPerspective mementoSauvegarde;
    Perspective perspective;
    GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    public CommandeSauvegarde(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        mementoSauvegarde = creerMemento();
        gestionnaireCommande.addMemento(mementoSauvegarde);
        gestionnaireCommande.addCommande(this);
    }

    @Override
    public MementoPerspective creerMemento() {
        return new MementoPerspective(perspective.getState());
    }

    public void setEtat(){perspective.setState(mementoSauvegarde.getState());}

    public Perspective getPerspective(){return perspective;}
}
