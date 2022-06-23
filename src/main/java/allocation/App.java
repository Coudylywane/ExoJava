package allocation;

import java.util.List;
import java.util.Scanner;

import allocation.models.Chambre;
import allocation.services.ChambreService;

/**
 * Hello world!
 *
 */
public class App 
{
   /*  public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DB.getConnection();

   } */

   public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    ChambreService chambreService = new ChambreService();

    int choix ;
    int choix1 ;
    int choix2 ;
    do {
       System.out.println("1-Chambre"); 
       System.out.println("2-Pavillon"); 
       System.out.println("3-Quitter"); 

       System.out.println("Faites votre choix"); 


       choix = scanner.nextInt();


       switch (choix) {
           case 1:
            do {
                System.out.println("1-Ajouter"); 
                System.out.println("2-Lister"); 
                System.out.println("3-Retour"); 
         
                System.out.println("Faites votre choix"); 
         
                choix1 = scanner.nextInt();

                switch (choix1) {
                    case 1:
                            Chambre chambres = new Chambre();
                            System.out.println("Entrer le numero de la chambre");
                            chambres.setNumCh(scanner.nextInt());
            
                            System.out.println("Entrer le numero de l'etage");
                            chambres.setNumEtage(scanner.nextInt());

            
                            System.out.println("Entrer l'etat de la chambre");
                            chambres.setEtat(scanner.next());
            
                            chambreService.addChambre(chambres);
                        break;


                    case 2:

                        do {

                            System.out.println("1-Supprimer"); 
                            System.out.println("2-Modifier"); 
                            System.out.println("3-Retour"); 

                            List<Chambre> chambr = chambreService.getAllChambres();
                            for (Chambre chambre : chambr) {
                                System.out.println("#################################");
                                System.out.println("ID : " + chambre.getId());
                                System.out.println("Numero Chambre : " + chambre.getNumCh());
                                System.out.println("Numero Etage : " + chambre.getNumEtage());
                                System.out.println("Etat : " + chambre.getEtat());
                                
                            }
         
                            System.out.println("Faites votre choix"); 
         
                            choix2 = scanner.nextInt();

                            switch (choix2) {
                                case 1:
                                System.out.println("Entrer l'id de la chambre");
                                int id = scanner.nextInt();
                                    chambres = chambreService.rechercherChambre(id);
                                    if (chambres == null) {
                                        System.out.println("Chambre inexistante");
                                    
                                    }else{
                                        chambreService.deleteChambre(chambres);
                                    }
                                    break;
                                
                                case 2:
                                System.out.println("Entrer l'id de la chambre");
                                int ids = scanner.nextInt();
                                    chambres = chambreService.rechercherChambre(ids);
                                    if (chambres == null) {
                                        System.out.println("Chambre inexistante");
                                    
                                    }else{
                                        System.out.println("Entrer le numero de la chambre");
                                        chambres.setNumCh(scanner.nextInt());
            
                                        System.out.println("Entrer le numero de l'etage");
                                        chambres.setNumEtage(scanner.nextInt());

            
                                        System.out.println("Entrer l'etat de la chambre");
                                        chambres.setEtat(scanner.next());
            
                                        chambreService.modifierChambre(chambres);
                                    }
                                    break;    
                            
                                default:
                                System.out.println("Veillez faire un bon choix"); 
                                    break;
                            }
                            
                        } while (choix2!= 3);


                        break;
                
                    default:
                        System.out.println("Veillez faire un bon choix"); 
                        break;
                }
                
            } while (choix1!= 3);
               

            case 2:
            System.out.println("Pavillon");
            break; 
              
       
           default:
           System.out.println("Veillez faire un bon choix"); 
               break;
       }
    } while (choix!= 3);
}
}


/*  */

