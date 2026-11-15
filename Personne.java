import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Personne {
    
    private String nom;               // nom de la personne
    private int[] preferences;        // liste de préférences de chambres dans l'ordre [1,2,3] <=> 1 > 2 > 3
    private List<Personne> jaloux;    // liste des personnes qui sont jalousés
    private int chambre;              // numéro de la chambre qui lui est attribué

    public Personne(String nom){
        this.nom = nom;
        this.preferences = null;
        this.jaloux = new ArrayList<Personne>();
        this.chambre = 0;
    }

    public String getNom(){
        return nom;
    }

    public int[] getPreferences(){
        return preferences;
    }

    public int getChambre(){
        return chambre;
    }

    public List<Personne> getJaloux(){
        return jaloux;
    }

    public void ajoutJaloux(Personne p){
        this.jaloux.add(p);
    }

    public void setPreferences(int[] prefs){
        this.preferences = prefs.clone();
    }

    public void ajoutChambre(int chambre){
        this.chambre = chambre;
    }
    
    @Override
    public boolean equals(Object o){
        if ( (o == null) || !(o instanceof Personne) ){
            return false;
        }
        if ( o == this){
            return true;
        }
        Personne p = (Personne) o;
        return (this.nom.equals(p.nom))
        && ( Arrays.equals(this.preferences, p.preferences)
        && ( this.jaloux.equals(p.jaloux)) );
    }


    /**   
     * return un String sous la forme :
     * A a la chambre 1
     * preferences : 1,2,3
     * est jaloux de : B,C
     */

    @Override 
    public String toString() {
    
    StringBuilder sb = new StringBuilder();
    sb.append(nom);
    if ( chambre == 0){
        sb.append(" n'a pas de chambre");
    }
    else{
        sb.append(" à la chambre " + chambre);
    }
    sb.append("\npreferences : ");
    if ( preferences != null ){
        for ( int pref : preferences){
            sb.append(" " + pref);
        }
    }
    if ( jaloux.size() == 0){
        sb.append("\n n'est pas jaloux");
    }
    else{
        sb.append("\n est jaloux de ");
        for (Personne p : jaloux){
            sb.append(" " + p.getNom());
        }
    }
    return new String(sb);
    
    }
} 
