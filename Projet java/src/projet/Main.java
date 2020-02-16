package projet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main (String [] args) throws IOException {
		personne pn = new personne();
		/*pn.adherents("C:/Users/kadour/Desktop/projet/Adherents.txt");
		pn.Beneficiares("C:/Users/kadour/Desktop/projet/Beneficiaires.txt");
		pn.recherchebeniftel("C:/Users/kadour/Desktop/projet/Beneficiaires.txt", 121298731 );
		pn.recherchebeniftnom("C:/Users/kadour/Desktop/projet/Beneficiaires.txt", "Levaillant");
		pn.supppersonne("C:/Users/kadour/Desktop/projet/Adherents.txt","0102030405","C:/Users/kadour/Desktop/projet/new.txt");
		pn.renamefile("C:/Users/kadour/Desktop/projet/Adherents.txt","C:/Users/kadour/Desktop/projet/new.txt" );
		pn.modifpersonne("C:/Users/kadour/Desktop/projet/Adherents.txt","0102030405", "C:/Users/kadour/Desktop/projet/new.txt", "002030405");
		pn.supprfile("C:/Users/kadour/Desktop/projet/Adherents.txt");*/
		Don dn = new Don();
		Scanner scanner = new Scanner(System.in);
		/*String file=null;
	 	System.out.print("entrez emplacement ficher adherents.txt");
		file = scanner.next();
		String files = null;
		System.out.print("entrez emplacement ficher beneficiare.txt");
		files = scanner.next();
		String filess="C:/Users/kadour/Desktop/projet/new.txt";
		*/
		String path = System.getProperty("user.dir");
		int sousmenu = 0;
	        boolean arret = false;
	        while (!arret){
		System.out.println("--Mon menu--");
		System.out.println("Module Personne : tapez 1");
		System.out.println("Module Don  : tapez 2");
		System.out.println("Module Recherche : tapez 3");
		System.out.println("Module Recherche : tapez 4");
	        System.out.println("quitter : tapez 9");
		sousmenu = scanner.nextInt();
		switch(sousmenu)
		{
			case 1 :{
						int choix = 0;
						System.out.println("---Module Personne---");
						System.out.println(" Lire les fichiers donnés en pièces jointes pour constituer l’ensemble personnes qui interagissent avec l’association : tapez 1");
						System.out.println("recherche sur les bénéficiaires : tapez 2");
						System.out.println(" Modification/Suppression des personnes : tapez 3");
						System.out.println("recherche sur les Adherents : tapez 4");
						System.out.println("quitter : tapez 9");
						choix = scanner.nextInt();
						switch(choix) { 
						case 1: {	pn.adherents(path+"/Adherents.txt");
									pn.Beneficiares(path+"/Beneficiaires.txt");
						} break;
						case 2: {
							
							System.out.println("Par téléphone choisir 1");
							System.out.println(" Par nom choisir 2");
							int choix1 = 0;
							choix1 = scanner.nextInt();
							switch (choix1) {
								case 1 :{
									System.out.print("entrez le numero de la personne que vous cherchez");
									int tel = 0;
									tel = scanner.nextInt();
									pn.recherchebeniftel(path+"/Beneficiaires.txt", tel);
								}	break;
								case 2 :{
									System.out.print("entrez le nom de la personne que vous cherchez");
									String nom = null;
									nom = scanner.next();
									pn.recherchebeniftnom(path+"/Beneficiaires.txt", nom);;
								}  break;
								
							}
						}break;
						case 3:{
							System.out.println("suprimez :tapez 1");
							System.out.println(" modifiez : tapez 2");
							int choix2 = 0;
							choix2 = scanner.nextInt();
							switch (choix2) {
							case 1 :{
								String supp = null;
								System.out.println("Entrez ce que vous souhaiter supprimer");
								supp = scanner.next();
								pn.supppersonne(path+"/Beneficiaires.txt", supp);
							}break;
							case 2 :{
								String supp = null;
								System.out.println("Entrez ce que vous souhaiter modifier");
								supp = scanner.next();
								String modif = null;
								System.out.println("Entrez la modificatation");
								pn.modifpersonne(path+"/Beneficiaires.txt",supp,modif);
							} break;
							
							}
						}break;
						case 4:{
							String supp = null;
							System.out.println("Entrez ce que vous souhaitez chercher dans notre base");
							supp = scanner.next();
							pn.recherchepersonne(path+"/Presonne.txt", supp);
							
						}
						}
			}break;
					
			case 2 : {
					int choix = 0;
					System.out.println("---Module Don---");
					System.out.println("Création d’un don : tapez 1");
					System.out.println("Stockage d’un don : tapez 2");
					System.out.println("Transfert du don au bénéficiaire : tapez 3");
					System.out.println("Archive d’un don : tapez 4");
					System.out.println("quitter : tapez 9");
					choix = scanner.nextInt();
					switch (choix) {
					case 1:{
						String Datededon = null;
						System.out.println("Entrez la date du jour");
						Datededon = scanner.next();
						String fonction = null;
						System.out.println("Entrez votre fonction");
						fonction = scanner.next();
						String nom = null;
						System.out.println("Entrez votre nom");
						nom = scanner.next();
						String prenom = null;
						System.out.println("Entrez votre prenom");
						prenom = scanner.next();
						String adresse = null;
						System.out.println("Entrez votre adresse");
						adresse = scanner.next();
						String numtel2 = null;
						System.out.println("Entrez votre numero");
						numtel2 = scanner.next();
						String don = null;
						System.out.println("Entrez votre don");
						don = scanner.next();
						String statue = null;
						System.out.println("Entrez la statue de votre don");
						statue = scanner.next();	
						dn.creeundon(Datededon,path+"/don.txt" , nom, prenom, adresse, numtel2, fonction, don, statue);
						
					} break;
					case 2:{
						String option=null;
						System.out.print("l'option : refuser ou accepter");
						option = scanner.next();
						int lignededon = 0;
						System.out.print("choisir la ligne de du don a stocker");
						lignededon = scanner.nextInt();
						dn.accundon(path+"/don.txt", option, lignededon);
					}
					}
			}
			case 3 : System.out.println("Sous menu 3"); break;
			case 4 : System.out.println("Sous menu 4"); break;
	                case 9 : arret = true; break;
			default : System.out.println("entrez un choix entre 1 et 4"); break;
		}
	                }
	}
	
	
	}
