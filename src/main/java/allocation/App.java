package allocation;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import allocation.DAO.DB;
import allocation.models.Chambre;
import allocation.models.Pavillon;
import allocation.services.ChambreService;
import allocation.services.PavillonService;


public class App {

    public static void main(String[] args) throws Exception {
        Connection conn = DB.getConnection();
        Scanner scanner = new Scanner(System.in);
        ChambreService chambreService = new ChambreService(conn);
        PavillonService pavillonService = new PavillonService(conn);
        int idPavillon;
        int choix;
        int choix1;
        int choix2;
        do {
            System.out.println("1-Chambre");
            System.out.println("2-Pavillon");
            System.out.println("3-Quitter");

            System.out.println("Faites votre choix");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                System.out.println("################ Menu Chambre #################");

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
                                System.out.println("Voulez-vous lui affecter un pavillon");
                                System.out.println("1-oui , 2-non");
                                int choixPav = scanner.nextInt();
                                if (choixPav == 1) {

                                    System.out.println("################ Pavillon disponible #################");

                                    List<Pavillon> pavillons = pavillonService.getAllPavillons();
                                    for (Pavillon pavillo : pavillons) {
                                        System.out.println("#################################");
                                        System.out.println("ID : " + pavillo.getId());
                                        System.out.println("Numero Chambre : " + pavillo.getNum());
                                        System.out.println("Numero Etage : " + pavillo.getNbreEtage());

                                    }
                                    System.out.println("Entrer l'id du pavillon");
                                    idPavillon = scanner.nextInt();
                                    Pavillon pavillon = pavillonService.rechercherPavillon(idPavillon);
                                    if (pavillon == null) {
                                        System.out.println("pavillon inexistant");
                                        break;
                                    } else {
                                        chambreService.addChambre(chambres, pavillon);
                                    }
                                } else if (choixPav == 2) {
                                    chambreService.addChambre(chambres);
                                } 

                                break;

                            case 2:
                            System.out.println("################ Autres Chambre #################");

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

                                            } else {
                                                chambreService.deleteChambre(chambres);
                                            }
                                            break;

                                        case 2:
                                            System.out.println("Entrer l'id de la chambre");
                                            int ids = scanner.nextInt();
                                            chambres = chambreService.rechercherChambre(ids);
                                            if (chambres == null) {
                                                System.out.println("Chambre inexistante");

                                            } else {
                                                System.out.println("Entrer le numero de la chambre");
                                                chambres.setNumCh(scanner.nextInt());

                                                System.out.println("Entrer le numero de l'etage");
                                                chambres.setNumEtage(scanner.nextInt());

                                                System.out.println("Entrer l'etat de la chambre");
                                                chambres.setEtat(scanner.next());

                                                chambreService.modifierChambre(chambres);
                                            }
                                            break;

                                       
                                    }

                                }  while (choix2 != 3);

                                break;

                            default:
                                break;
                        }
                    } while (choix1 != 3);
                    break;

                case 2:
                System.out.println("################ Menu Pavillon #################");

                    do {
                        System.out.println("1-Ajouter");
                        System.out.println("2-Lister");
                        System.out.println("3-Retour");

                        System.out.println("Faites votre choix");

                        choix1 = scanner.nextInt();

                        switch (choix1) {
                            case 1:
                                Pavillon pavillon = new Pavillon();
                                System.out.println("Entrer le numero du pavillon");
                                pavillon.setNum(scanner.nextInt());

                                System.out.println("Entrer le nombre d'etages");
                                pavillon.setNbreEtage(scanner.nextInt());

                                pavillonService.addPavillon(pavillon);
                                break;

                            case 2:
                            System.out.println("################ Autres Pavillon #################");

                                do {

                                    System.out.println("1-Modifier");
                                    System.out.println("2-Retour");

                                    List<Pavillon> pavillons = pavillonService.getAllPavillons();
                                    for (Pavillon pavillo : pavillons) {
                                        System.out.println("#################################");
                                        System.out.println("ID : " + pavillo.getId());
                                        System.out.println("Numero Chambre : " + pavillo.getNum());
                                        System.out.println("Numero Etage : " + pavillo.getNbreEtage());

                                    }

                                    System.out.println("Faites votre choix");

                                    choix2 = scanner.nextInt();

                                    switch (choix2) {
                                        case 1:
                                            System.out.println("Entrer l'id du pavillon");
                                            int ids = scanner.nextInt();
                                            pavillon = pavillonService.rechercherPavillon(ids);
                                            if (pavillon == null) {
                                                System.out.println("Chambre inexistante");

                                            } else {
                                                System.out.println("Entrer le numero du paviilon");
                                                pavillon.setNum(scanner.nextInt());

                                                System.out.println("Entrer le nombre d'etage");
                                                pavillon.setNbreEtage(scanner.nextInt());

                                                pavillonService.modifierPavillon(pavillon);
                                            }
                                            break;

                                        default:
                                            break;
                                    }

                                } while (choix2 != 2);

                                break;

                            default:
                                break;
                        }

                    } while (choix1 != 3);
                    break;

                
            }
        } while (choix != 3);
        conn.close();
        System.out.println("Au revoir!!!");
    }
}

