import java.util.ArrayList;
import java.util.HashSet;




public class GroupeVoyage {

    private ArrayList<Personne> groupePersonnes;    // [A, B, C, D]
    

    public GroupeVoyage(int n) {
        if (n < 1 || n > 26) {
            throw new IllegalArgumentException("Le nombre de personnes doit être compris entre 1 et 26.");
        }
        this.groupePersonnes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            groupePersonnes.add(new Personne(String.valueOf((char) ('A' + i))));
        }
    }

    /**
     * Permet de vérifier que chaque personne a des préférences 
     * @throws GroupeVoyageException
     * @return true si toutes les personnes ont des préférences initialisées , false sinon
     */
    public boolean verifierInitialisation() throws GroupeVoyageException{
        boolean initialise = true;
        ArrayList<Personne> listePasInitialisees = new ArrayList<Personne>();
        for ( Personne p : groupePersonnes){
            if ( p.getPreferences() == null){
                listePasInitialisees.add(p);
                initialise = false;
            }
        }
        if ( !initialise ){ 
            StringBuffer sb = new StringBuffer();
            for ( Personne p : listePasInitialisees){
                sb.append(" " + p.getNom());
            }
            throw new GroupeVoyageException("Les préférences des personnes " + sb + " n'ont pas été initialisées");
        }
        return initialise;
    }


    /**
     * Permet d'ajouter une relation jaloux entre 2 personnes 
     * @param p1
     * @param p2
     */
    public void ajouterRelation(Personne p1 , Personne p2) throws GroupeVoyageException{
        if ( p1.equals(p2)){
            throw new GroupeVoyageException("Les 2 personnes sont les memes");
        }
        else if ( p1.getJaloux().contains(p2) || p2.getJaloux().contains(p1)){
            throw new GroupeVoyageException( p1.getNom() + " est déjà jaloux de " + p2.getNom() );
        }
        p1.ajoutJaloux(p2);
        p2.ajoutJaloux(p1);
    }




    /**
     * Permet d'initialiser les préférences d'une personne
     * @param p1
     * @param preferences
     * @throws Exception
     */
    public void ajouterPreferencesPersonne(Personne p1, int[] preferences) throws GroupeVoyageException{
        int nbChambres = groupePersonnes.size();
        HashSet<Integer> ensPreferences = new HashSet<Integer>();

        if ( preferences.length != groupePersonnes.size() ){
            throw new GroupeVoyageException("la taille de la liste de préférences est inexacte");
        }
        
        
        for ( int numChambre : preferences){
            ensPreferences.add(numChambre);
            if ( numChambre < 1 || numChambre > nbChambres){
                throw new GroupeVoyageException("La chambre " + numChambre + " n'existe pas (valeurs acceptees de 1 à " + nbChambres + ")");
            }
        }
        if ( ensPreferences.size() != nbChambres) {
            throw new GroupeVoyageException("Il faut entrer " + nbChambres + " chambres ,nb de chambre recu : " + ensPreferences);
        }
        
        p1.setPreferences(preferences);
    }



    /**
    *Permet de récuperer la Personne en fonction de son nom
    *@param String le nom de la personne
    *@return la Personne en fonction de son nom
    */
    public Personne getUnePersonne(String nom) throws GroupeVoyageException{
        for ( Personne p : groupePersonnes){
            if ( p.getNom().equals(nom)){
                return p;
            }
        }
        throw new GroupeVoyageException("la personne " + nom + "n'a pas été trouvée");
    }
    





    /**
     * Permet de récuperer la lisye de toutes les personnes du groupe
     * @return la liste des personnes du groupe
     */
    public ArrayList<Personne> getPersonnes(){
        return groupePersonnes;
    }
 


    public String NomsString(){
        StringBuffer sb = new StringBuffer();
        for ( Personne p : groupePersonnes){
            sb.append(" " + p.getNom());
        }
        return new String(sb);
    }


    /**    (non-Javadoc)
     * Permet de récupérer l'ensemble des infos du GroupeVoyage sous forme de chaine de caracteres
     * @see java.lang.Object#toString()
     */
    @Override 
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for ( Personne p : groupePersonnes){
            sb.append(p.toString());
            sb.append("\n---------------------------\n");
        }
        return new String(sb);
    }
}
