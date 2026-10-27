import java.util.ArrayList;
import java.util.List;

public class Personne {
    
    private String nom;
    private String[] preferences;
    private List<Personne> jaloux;

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

    @Override 
    public String toString(){

        StringBuffer sb = new StringBuffer(nom + " : ");
        for ( String pref : preferences){
            sb.append( pref + ", ");
        }

        return new String(sb);
    }

    public void affiche(){
        System.out.println(toString());
    }
} 
