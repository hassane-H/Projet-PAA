import java.util.Scanner;

class Main{

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choixUtilisateur1 = 1;
        // nombre de personnes n dans le groupe ( = nombre de chambres ) 
        System.out.println("Nombre de personnes dans le groupe ( = nombre de chambres ) : ");
        int n = sc.nextInt();

        // on crée la liste de personnes
        Personne[] personnes = new Personne[n];
        for (int i = 0; i < n; i++){
            System.out.println("Entrez le nom de la personne");
            personnes[i] = new Personne(sc.next(), n);
        }
        


        GroupeVoyage gp = new GroupeVoyage(personnes, n);
        
        gp.init();
        gp.affiche();
        // bloc 1 , initialisation des chambres et des relations
        while ( choixUtilisateur1 != 3 ){
            try{
                do{

                    // choix de l'utilisateur , initialisation 

                    System.out.println("Que voulez-vous faire ? ");
                    System.out.println("1) ajouter une relation 'jaloux' entre deux personnes");
                    System.out.println("2) ajouter les préférences d'une personne");
                    System.out.println("3) passer à l'étape suivante");
                    
                    while (!sc.hasNextInt()) {
                        System.out.println("Entrez un nombre : 1, 2 ou 3.");
                        sc.nextLine(); // discard invalid input
                    }

                    choixUtilisateur1 = sc.nextInt();
                    sc.nextLine(); // vider le buffer du sc ( retirer le \n entrée dans la ligne précédente)

                }while(choixUtilisateur1 < 1 || choixUtilisateur1 > 3);

                if ( choixUtilisateur1 == 1 ){
                    System.out.println("Entrez le nom des 2 personnes à la suite ( ex : A B ou C D ) :");
                    
                    String entreeUtilisateur1 = sc.nextLine();

                    String[] elements = entreeUtilisateur1.split(" "); // elements est sous forme ["A", "B"]
 
                    Personne p = gp.getPersonne(elements[0]);
                    p.ajoutJaloux(gp.getPersonne(elements[1])); 
                    for(int i=0;i< p.getJaloux().size(); i++){
                        System.out.println(p.getNom() + " jalouse " + p.getJaloux().get(i).getNom()+"\n");
                    }
                }
                else if ( choixUtilisateur1 == 2 ){

                    System.out.println("Entrez le nom de la personne suivi des numéros de chambre ( ex : A 1 2 3 ) : ");
                    String entreeUtilisateur1 = sc.nextLine();

                    String[] elements = entreeUtilisateur1.split(" "); // elements est sous forme ["A", "1", "2", "3"]

                    String nom = elements[0];  // on récupère le "A" ( = nom de la personne suivie ) 
                    Personne p = gp.getPersonne(nom); 


                    int[] preferencesChambres = new int[elements.length - 1]; // tableau d'entiers de la taille de elements-1 ( on a retiré la lettre A )
                    for( int i = 1; i < elements.length; i++){
                        preferencesChambres[i-1] = Integer.parseInt(elements[i]);
                    }


                    p.ajoutPreferences(preferencesChambres);
                    System.out.println("préférences ajoutés avec succès \n\n");

                    for(int i=0;i<gp.getPersonnes().length;i++){
                        System.out.println(gp.getPersonnes()[i].getNom() + " : ");
                        for(int j=0;j<gp.getPersonnes()[i].getPreferences().length;j++){
                            System.out.print(gp.getPersonnes()[i].getPreferences()[j] + " ");
                        }
                    System.out.println("\n");
                    }
                }

            }catch(Exception e){
                System.out.println("erreur : " + e);
            }finally{
                System.out.println("fin bloc 1");
            }
        }

        for(int i=0;i<gp.getPersonnes().length;i++){
            System.out.println(gp.getPersonnes()[i].getNom() + " : ");
            for(int j=0;j<gp.getPersonnes()[i].getPreferences().length;j++){
                System.out.print(gp.getPersonnes()[i].getPreferences()[j] + " ");
            }
            System.out.println("\n");
        }

        for(int i=0;i<gp.getPersonnes().length;i++){
            System.out.println(gp.getPersonnes()[i].getNom() + " jalouse : ");
            for(int j=0;j<gp.getPersonnes()[i].getJaloux().size();j++){
                System.out.print(gp.getPersonnes()[i].getJaloux().get(j).getNom() + " ");
            }
            System.out.println("\n");
        }


        // affichage d'une solution naïve : 
        gp.afficheSolutionNaive();
        // bloc 2 , proposition solution naïve + possibilité pour l'utilisateur de modifier solution
        int choixUtilisateur2 = -1;
        while ( choixUtilisateur2 != 3 ){
            try{
                do{
                    System.out.println("Que voulez-vous faire ? ");
                    System.out.println("1) échanger les chambres de deux personnes");
                    System.out.println("2) afficher le nombre de personnes jalouses");
                    System.out.println("3) passer à l'étape suivante");

                    while (!sc.hasNextInt()) {
                        System.out.println("Entrez un nombre : 1, 2 ou 3.");
                        sc.nextLine(); // discard invalid input
                    }

                    choixUtilisateur2 = sc.nextInt();
                    sc.nextLine(); // vider le buffer du sc ( retirer le \n entrée dans la ligne précédente)

                }while( choixUtilisateur2 < 1 || choixUtilisateur2 > 3 );

                if ( choixUtilisateur2 == 1 ){
                    System.out.println("Entrer les deux personnes dont vous voulez échanger les chambres ( ex : A B ) : ");
                }
                else if ( choixUtilisateur2 == 2 ){
                    System.out.println("Nombre de personnes jalouses : ");
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