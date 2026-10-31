import java.util.HashMap;
import java.util.Map;



public class GroupeVoyage {

    private Personne[] groupePersonnes;    // [A, B, C, D]
    private int nbPersonnes;  // 4
    private Map<String, Personne> AttributionChambres;  // { c1 : A , c2 : B , c3 : C , c4 : D 
    
    public GroupeVoyage(Personne[] groupePersonnes, int nbPersonnes){
        this.groupePersonnes = groupePersonnes;
        this.nbPersonnes = nbPersonnes;
    }

    public void init(){  // Permet d'initisaliser le Map avec comme valeur de defaut { i : null }  ( i : 1 à n )
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

    public String getChambres() {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Personne> entry : AttributionChambres.entrySet()) {
        String numChambre = entry.getKey();
        Personne occupant = entry.getValue();
        sb.append("Chambre ").append(numChambre).append(" : ")
          .append(occupant != null ? occupant.getNom() : "Libre").append("\n");
        }
    return sb.toString();
    }

    
    public void ajouterPersonneChambre(String chambre, Personne p){
        AttributionChambres.replace(chambre, p);
    }

    private void getSolutionNaive(){
        
        for ( Personne p : groupePersonnes){  // pour chaque personne du groupe 
            
            for ( String chambrePrefere : p.getPreferences()){  // pour chaque chambre préféré de la personne ( dans l'ordre des préférences )
                
                if (  AttributionChambres.containsKey(chambrePrefere) && AttributionChambres.get(chambrePrefere) == null  ){
                    AttributionChambres.replace(chambrePrefere, p);
                    p.ajoutChambre(chambrePrefere);
                    break;
                }
            }
        }
    }
    
    public void afficheSolutionNaive() {
    getSolutionNaive();
    System.out.println("--- Solution Naïve ---");
    for (Map.Entry<String, Personne> entry : AttributionChambres.entrySet()) {
        String numChambre = entry.getKey();
        Personne occupant = entry.getValue();
        // Evite le NullPointerException si la chambre est null
        String nomOccupant = (occupant != null) ? occupant.getNom() : "Libre";
        System.out.println("c" + numChambre + " : " + nomOccupant);
    }
}

    public void echangerChambres(Personne A, Personne B) throws Exception {
        if ( !( AttributionChambres.containsValue(A) && AttributionChambres.containsValue(B) ) ){
            throw new Exception("erreur, l'une des personnes n'existe pas ");
        }
        // { c1 : A , c2 : B}
        // on trouve A , on note sa chambre , on trouve B , on note sa chambre , on attribue a la chambre de A B et a la chambre de B A
        String chambreA = A.getChambre();
        String chambreB = B.getChambre();
        AttributionChambres.replace(chambreA, B);
        AttributionChambres.replace(chambreB, A);
        A.ajoutChambre(chambreB);
        B.ajoutChambre(chambreA);

    }


    @Override 
    public String toString() {
    StringBuilder sb = new StringBuilder("=== État du Groupe de Voyage ===\n");
    for (Map.Entry<String, Personne> entry : AttributionChambres.entrySet()) {
        String numChambre = entry.getKey();
        Personne occupant = entry.getValue();

        sb.append("Chambre ").append(numChambre).append(" : ");
        if (occupant != null) {
            sb.append(occupant.getNom());
        } else {
            sb.append("Non attribuée");
        }
        sb.append("\n");
    }
    return sb.toString();
}

    public void affiche(){
        System.out.println(toString());
    }

}
