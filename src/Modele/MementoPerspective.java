package Modele;

/**
 * Permet de garder l'état de l'image (Position x et y et scale de l'image)
 */
public class MementoPerspective {

    private EtatImage state;
    public MementoPerspective(EtatImage state){
        this.state = state;
    }
    protected void setState(EtatImage state) {
        this.state = state;
    }

    public EtatImage getState(){return state;}

}
