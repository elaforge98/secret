package Modele;

import java.io.Serializable;

public class EtatImage implements Serializable{

    private int x;
    private int y;
    private float scale;

    public EtatImage(int x, int y, float scale){

        this.x = x;
        this.y = y;
        this.scale = scale;

    }

    // GETTERS
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public float getScale(){return this.scale;}

    //SETTERS
    protected void setX(int x){this.x = x;}
    protected void setY(int y){this.y = y;}
    protected void setScale(float scale){this.scale = scale;}

}
