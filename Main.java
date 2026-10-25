import java.util.Scanner;
import java.util.StringTokenizer;

class Main{

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choixUtilisateur1 = 1;
        // nombre de personnes n dans le groupe ( = nombre de chambres ) 
        // System.out.println("Nombre de personnes dans le groupe ( = nombre de chambres ) : ");
        int n = 3; //sc.nextInt();

        // on crée les personnes manuellement
        Personne p1 = new Personne("A", n);
        Personne p2 = new Personne("B", n);
        Personne p3 = new Personne("C", n);

        // on crée une liste de personnes 
        Personne[] personnes = {p1, p2, p3};


        GroupeVoyage gp = new GroupeVoyage(personnes, n);
        
        gp.init();

        // bloc 1 , initialisation des chambres et des relations
        while ( choixUtilisateur1 != 3 ){
            try{
                do{

                    // choix de l'utilisateur , initialisation 

                    System.out.println("Que voulez-vous faire ? ");
                    System.out.println("1) ajouter une relation 'jaloux' entre deux personnes");
                    System.out.println("2) ajouter les préférences d'une personne");
                    System.out.println("3) passer à l'étape suivante");

                    choixUtilisateur1 = sc.nextInt();
                    
                }while(choixUtilisateur1 == 1 || choixUtilisateur1 == 2);

                if ( choixUtilisateur1 == 1 ){
                    System.out.println("Entrez le nom des 2 personnes à la suite ( ex : A B ou C D ) :");
                    
                    
                }
                else if ( choixUtilisateur1 == 2 ){
                    // à faire
                }


            }catch(Exception e){
                System.out.println("erreur : " + e);
            }finally{
                System.out.println("fin bloc 1");
            }
        }



        
        // bloc 2 , proposition solution naïve + possibilité pour l'utilisateur de modifier solution
        int choixUtilisateur2 = -1;
        while ( choixUtilisateur2 != 3 ){
            try{
                do{
                    System.out.println("Que voulez-vous faire ? ");
                    System.out.println("1) échanger les chambres de deux personnes");
                    System.out.println("2) afficher le nombre de personnes jalouses");
                    System.out.println("3) passer à l'étape suivante");

                    choixUtilisateur2 = sc.nextInt();
                }while( choixUtilisateur2 == 1 || choixUtilisateur2 == 2 );

                if ( choixUtilisateur2 == 1 ){
                    // à faire
                }
                else if ( choixUtilisateur2 == 2 ){
                    // à faire
                }

            }catch(Exception e){
                System.out.println("Erreur : " + e);
            }finally{
                System.out.println("fin bloc 2");
            }
        } 

    sc.close();
    }
}