package Controleur;

import Modele.MementoPerspective;
import Modele.Perspective;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireCommande {

    private static GestionnaireCommande instance = new GestionnaireCommande();
    private List<Commande> listeCommande;
    private List<MementoPerspective> listeMemento;

    private GestionnaireCommande(){

        listeCommande = new ArrayList<>();
        listeMemento = new ArrayList<>();

    }

    //  AJOUT DE MEMENTO OU COMMANDE
    public void addMemento(MementoPerspective m){listeMemento.add(m);}
    public void addCommande(Commande c){listeCommande.add(c);}

    // GETTERS
    public static GestionnaireCommande getInstance(){return instance;}
    public MementoPerspective getLastMemento(){return listeMemento.get(listeMemento.size() -1);}
    public List getListeCommande(){return this.listeCommande;}
    public List getListeMemento(){return this.listeMemento;}

    public CommandeSauvegarde getLastSave(Perspective perspective){

        CommandeSauvegarde save = null;

        for(int i = listeCommande.size() - 1; i >= 0; i--){
            if(listeCommande.get(i) instanceof CommandeSauvegarde && perspective.equals(listeCommande.get(i).getPerspective())){
                save = (CommandeSauvegarde) listeCommande.get(i);
                break;
            }
        }
        return save;
    }


    // Notre commande undo pourrait simplemenent être une méthode plutôt qu'une classe
    public void undo(){ }

}
