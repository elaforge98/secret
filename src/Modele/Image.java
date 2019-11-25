package Modele;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Image implements Subject {


    private final int NOMBRE_PERSPECTIVES = 2;
    private ArrayList<Perspective> listePerspective = new ArrayList<>();
    private List<Observer> listObservers = new LinkedList<Observer>();
    private String path;
    private BufferedImage photo;


    public Image(String path){

        this.path = path;
        // On crée une image à partir du path donné, cette image sera utile pour les vignettes
        try{
            photo = ImageIO.read(new File(path));
        }catch(IOException e){
            e.printStackTrace();
        }

        for(int i = 0; i < NOMBRE_PERSPECTIVES; i++)
            listePerspective.add(new Perspective(this, i + 1));

    }



    // GETTERS
    public String getPath(){return this.path;}
    public BufferedImage getPhoto(){return this.photo;}
    public ArrayList<Perspective> getListePerspective() {return listePerspective;}

    /**
     * Enleve le path pour envoyer seulement le nom de l'image
     * @return Nom de l'image sans le path
     */
    public String getNomImage(){
        String nom = path.replace("src\\Ressources\\", "");
        return nom;
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
