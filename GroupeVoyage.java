

public class GroupeVoyage {

    private Personne[] groupePersonnes;
    private int nbPersonnes;
    private String[] chambres;
    public GroupeVoyage(Personne[] groupePersonnes, int nbPersonnes){
        this.groupePersonnes = groupePersonnes;
        this.nbPersonnes = nbPersonnes;
    }

    public void init(){
        this.chambres = new String[nbPersonnes];

        for ( int i = 0; i < nbPersonnes; i++){
            chambres[i] = "c"+(i+1);
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

    public String[] getChambres(){
        return chambres;
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
