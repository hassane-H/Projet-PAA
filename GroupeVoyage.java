import java.util.HashMap;
import java.util.Map;


public class GroupeVoyage {

    private Personne[] groupePersonnes;
    private int nbPersonnes;
    private Map<String, Personne> AttributionChambres;
    public GroupeVoyage(Personne[] groupePersonnes, int nbPersonnes){
        this.groupePersonnes = groupePersonnes;
        this.nbPersonnes = nbPersonnes;
    }

    public void init(){
        this.AttributionChambres = new HashMap<>();

        for ( int i = 0; i < nbPersonnes; i++){
            AttributionChambres.put((String.valueOf(i+1)), null);
        }

    }

    public Personne getPersonne(String nom){
        for ( Personne p : groupePersonnes){
            if ( p.getNom().equals(nom)){
                return p;
            }
        }
        return null;
    }
    
    public Personne[] getPersonnes(){
        return groupePersonnes;
    }

    public String getChambres(){
        StringBuffer sb = new StringBuffer();
        for ( String chambre : AttributionChambres.keySet()){
            sb.append( chambre + " : " + AttributionChambres.get(chambre) + "\n");
        }
        return new String(sb);
    }

    public void ajouterPersonneChambre(String chambre, Personne p){
        AttributionChambres.replace(chambre, p);
    } 
    private void getSolutionNaive(){
        
        for ( Personne p : groupePersonnes){  // pour chaque personne du groupe 
            
            for ( String chambrePrefere : p.getPreferences()){  // pour chaque chambre préféré de la personne ( dans l'ordre des préférences )
                
                if (  AttributionChambres.containsKey(chambrePrefere) && AttributionChambres.get(chambrePrefere) == null  ){
                    AttributionChambres.replace(chambrePrefere, p);
                    break;
                }
            }
        }
    }
    public void afficheSolutionNaive(){
        getSolutionNaive();
        for ( Map.Entry<String, Personne> entry : AttributionChambres.entrySet()){
            System.out.println("c"+entry.getKey() + ":" +entry.getValue().getNom());
        }
    }
    @Override 
    public String toString(){

        StringBuffer sb = new StringBuffer();
        for (Personne p : groupePersonnes){
            sb.append(p.toString() + "\n");
        }

        return new String(sb);
    }

    public void affiche(){
        System.out.println(toString());
    }

}
