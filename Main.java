import java.util.Scanner;

class Main{

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Entrez le nombres de personnes dans le groupe de voyage ( entre 1 et 26 inclu )");
            n = Integer.parseInt(sc.nextLine().trim());
        }while ( n < 1 || n > 26);

        GroupeVoyage gp = new GroupeVoyage(n);
        int choixUtilisateurBloc1 = 0;
        boolean verifFinBoucle1 = false;

        //bloc 1 
        while ( !verifFinBoucle1){
            try{
                
                System.out.println(gp.toString());
                System.out.println("Tapez : ");
                System.out.println("1) ajouter une relation entre 2 personnes");
                System.out.println("2) Ajouter les préférences d'une personne");
                System.out.println("3) Fin.");
                choixUtilisateurBloc1 = Integer.parseInt(sc.nextLine().trim());
                
                if ( choixUtilisateurBloc1 == 1 ){      // ajouter une relation entre 2 personnes

                    System.out.println("Entrez le nom de la 1ere Personne");
                    String nomPersonneRelation1 = sc.nextLine();
                    Personne personneRelation1 = gp.getUnePersonne(nomPersonneRelation1);

                    System.out.println("Entrez le nom de la 2eme Personne");
                    String nomPersonneRelation2 = sc.nextLine();
                    Personne personneRelation2 = gp.getUnePersonne(nomPersonneRelation2);
                

                    gp.ajouterRelation(personneRelation1, personneRelation2);
                }



                else if ( choixUtilisateurBloc1 == 2){  // ajouter preferences d'une personne
                    
                    System.out.println("Nom suivi des numéros de chambre (ex : A 1 2 3) : ");
                    String[] mots = sc.nextLine().trim().split("\\s+");

                    if (mots.length < 2) {
                        throw new IllegalArgumentException("Il faut un nom suivi des numéros de chambre.");
                    }

                    int[] prefs = new int[mots.length - 1];
                    for (int i = 1; i < mots.length; i++) {
                        prefs[i - 1] = Integer.parseInt(mots[i]);                            
                    }


                    Personne personnePreference = gp.getUnePersonne(mots[0]);
                    gp.ajouterPreferencesPersonne( personnePreference, prefs);

                }


                else if  (choixUtilisateurBloc1 == 3){
                    // vérification de l'initialisation des préférences de tous
                    verifFinBoucle1 = gp.verifierInitialisation();
                }
                else{
                    System.out.println("entrez un nombre entre 1 et 3 selon ce que vous voulez faire");
                }
            }catch(GroupeVoyageException gve){
                System.out.println("erreur : " + gve.getMessage());
            }catch(Exception e){
                System.out.println("erreur inconnue : " + e.getMessage());
                }
            }
        sc.close();
        }
}