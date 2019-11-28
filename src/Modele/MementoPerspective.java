package Modele;

/**
 * Permet de garder l'état de l'image (Position x et y et scale de l'image)
 */
public class MementoPerspective {

    private Perspective perspective;
    private EtatImage state;
    public MementoPerspective(EtatImage state, Perspective perspective){
        this.state = state;
        this.perspective = perspective;
    }
    protected void setState(EtatImage state) {
        this.state = state;
    }

    // GETTERS
    public Perspective getPerspective() {return perspective; }
    public EtatImage getState(){return state;}

}
