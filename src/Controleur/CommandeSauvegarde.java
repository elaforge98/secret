package Controleur;

import Modele.EtatImage;
import Modele.MementoPerspective;
import Modele.Perspective;

import java.io.*;

public class CommandeSauvegarde implements Commande {

    Perspective perspective;
    GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    public CommandeSauvegarde(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        gestionnaireCommande.addCommande(this);
        perspective.serializeState();
    }

    public void setEtat(){perspective.setState(deserializeState());}

    public EtatImage deserializeState(){

        EtatImage e = null;
        try {
            FileInputStream fichierInput = new FileInputStream("src\\Ressources\\Etat\\"+perspective.getNom()+".ser");
            ObjectInputStream input = new ObjectInputStream(fichierInput);
            e = (EtatImage) input.readObject();
            input.close();
            fichierInput.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        return e;
    }
    public Perspective getPerspective(){return perspective;}
}
