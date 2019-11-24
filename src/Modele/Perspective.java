package Modele;

import Controleur.GestionnaireCommande;

import java.util.ArrayList;

public class Perspective implements Subject{

    // ETAT INITIAL DE TOUS LES PERSPECTIVES
    private final int X_INITIAL = 0;
    private final int Y_INITIAL = 0;
    private final float SCALE_INITIAL = 1;

    private ArrayList<Observer> listObservers = new ArrayList<>();
    private EtatImage state;
    private Image image;
    private int id;
    private String nom;


    public Perspective(Image image, int id){

        state = new EtatImage(X_INITIAL, Y_INITIAL, SCALE_INITIAL);
        GestionnaireCommande gestionnaire = GestionnaireCommande.getInstance();
        gestionnaire.addMemento(creerMemento());
        this.image = image;
        this.id = id;
        this.nom = image.getNomImage() + "-perspective" + this.id;

    }

    // GETTERS
    public EtatImage getState(){return this.state;}
    public Image getImage(){return this.image;}
    public int getId(){return this.id;}
    public String getNom(){return this.nom;}

    // SETTERS
    public void setState(MementoPerspective m){
        state = m.getState();
        notifyObservers();
    }
    public void setState(EtatImage e){
        state = e;
        notifyObservers();
    }

    // METHODES MEMENTO
    public MementoPerspective creerMemento(){
        MementoPerspective memento = new MementoPerspective(this.state);
        return memento;
    }

    @Override
    public void attach(Observer o) {listObservers.add(o);}

    @Override
    public void dettach(Observer o) {listObservers.remove(o);}

    @Override
    public void notifyObservers() {
        for (Observer obv : listObservers) {
            obv.update();
        }
    }
}
