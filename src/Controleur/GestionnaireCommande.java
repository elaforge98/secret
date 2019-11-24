package Controleur;

import Modele.MementoPerspective;

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
    public MementoPerspective getLastMemento(){
        return listeMemento.get(listeMemento.size() -1);
    }

    // Notre commande undo pourrait simplemenent être une méthode plutôt qu'une classe
    public void undo(){ }

}
