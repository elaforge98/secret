package Modele;

import java.io.File;
import java.util.ArrayList;

/**
 * Représente le cerveau du modèle, permet accès centralisé des images (pour les vues et les commandes)
 * POUR L'INSTANT UN SINGLETON MAIS PAS CERTAIN
 */
public class Model {

    private ArrayList<Image> listeImage;
    private ArrayList<Perspective> listePerspective;
    private static Model instance = new Model();
    private final String path = "src\\Ressources\\Images";
    private File files = new File(path);

    private Model(){
        listeImage = new ArrayList<>();
        listePerspective = new ArrayList<>();
        initListeImages();
    }

    // AJOUT D'IMAGE OU PERSPECTIVE
    public void addImage(Image image){listeImage.add(image);}
    public void addPerspective(Perspective perspective){listePerspective.add(perspective);}

    // GETTERS
    public static Model getInstance(){return instance;}
    public ArrayList<Image> getListeImage(){return listeImage;}
    public ArrayList<Perspective> getListePerspective(){return listePerspective;}

    // Pour l'instant trouve l'image selon le nom
    public Image getImage(String nom){

        Image temp = null;

        for(Image i : listeImage){
            if(i.getNomImage().equals(nom))
                temp = i;
        }

        return temp;

    }

    public void initListeImages(){

        for(File f : files.listFiles()){
            Image image = new Image(f.getPath());
            listeImage.add(image);
        }

    }
}
