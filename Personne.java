import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Personne {
    
    private String nom;
    private String[] preferences;
    private List<Personne> jaloux;
    private String chambre;

    public Personne(String nom, int n){
        this.nom = nom;
        this.preferences = new String[n];
        this.jaloux = new ArrayList<Personne>();
    }

    public String getNom(){
        return nom;
    }

    public String[] getPreferences(){
        return preferences;
    }

    public String getChambre(){
        return chambre;
    }
    public List<Personne> getJaloux(){
        return jaloux;
    }

    public void ajoutJaloux(Personne p){
        this.jaloux.add(p);
    }

    public void ajoutPreferences(int[] prefs){
        for( int i = 0; i < prefs.length; i++){
            this.preferences[i] = String.valueOf(prefs[i]);
        }
    }

    public void ajoutChambre(String chambre){
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


    @Override 
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(nom);

    // Formatage propre des préférences sans virgule finale
    if (preferences != null && preferences.length > 0) {
        sb.append(" [Préférences : ");
        boolean premier = true;
        for (String pref : preferences) {
            if (pref != null) {
                if (!premier) sb.append(", ");
                sb.append(pref);
                premier = false;
            }
        }
        sb.append("]");
    }

    // Affichage de la chambre courante
    if (chambre != null) {
        sb.append(" | Chambre : ").append(chambre);
    } else {
        sb.append(" | Pas de chambre");
    }

    return sb.toString();
}



    public void affiche(){
        System.out.println(toString());
    }
} 
