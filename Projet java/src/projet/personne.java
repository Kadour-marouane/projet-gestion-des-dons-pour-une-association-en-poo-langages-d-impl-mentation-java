package projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class personne {
	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private int numtel;
	private String fonction;
	private String birthdate;
	
	
	public personne () {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.numtel=numtel;
		this.fonction=fonction;
		this.birthdate=birthdate;
	}
	public String Getid() {
		return id;
	}
	public String Getprenom() {
		return prenom;
	}
	public String Getnom() {
		return nom;
	}
	public String Getadresse() {
		return adresse;
	}
	public int Getnumtel() {
		return numtel;
	}
	public String Getfonction() {
		return fonction;
	}
	public String Getbirthdate() {
		return birthdate;
	}
	public void setid(String s) {
		id=s;
	}
	public void setprenom(String s) {
		prenom=s;
	}
	public void setnom(String s) {
		nom=s;
	}
	public void setadresse(String s) {
		adresse=s;
	}
	public void setnumtel(int s) {
		numtel=s;
	}
	public void setfonction(String s) {
		fonction=s;
	}
	public void setbirthdate(String s) {
		birthdate=s;
	}
	@SuppressWarnings("unchecked")
	public ArrayList setbeneficiaires(String id,String nom,String prenom,String adresse,int numtel2,String birthdate) {
		ArrayList arlist = new ArrayList();
	     arlist.add(id);
	     arlist.add(nom);
	     arlist.add(prenom);
	     arlist.add("0" + numtel2);
	     arlist.add(adresse);
	     arlist.add(birthdate);
	System.out.println(arlist);
	return arlist;
	}
	@SuppressWarnings("unchecked")
	public void setadherents(String id2,String nom,String prenom,String adresse,int numtel2,String fonction) {
		ArrayList arlist = new ArrayList();
	     arlist.add(id2);
	     arlist.add(nom);
	     arlist.add(prenom);
	     arlist.add(adresse);
	     arlist.add("0"+numtel2);
	     arlist.add(fonction);
	     
	System.out.println(arlist);
	}
	
			
	public static int nbLignes(String file) throws IOException {
		
		int nblignes = 0;
		
		BufferedReader fichier = new BufferedReader(new FileReader(file));
		
		while(fichier.readLine() != null) { //Pour chaque ligne, incrémente nblignes.
			nblignes++;
		}
		return nblignes;
		
	}
	public static int nlignes(String file) throws IOException {
		
		int nlignes = 0;
		
		BufferedReader fichier = new BufferedReader(new FileReader(file));
		
		while(fichier.readLine() != null) { //Pour chaque ligne, incrémente nblignes.
			nlignes++;
		}
		return nlignes;
		
	}
	public void adherents(String file) throws IOException {
		BufferedReader fichier = new BufferedReader(new FileReader(file));
		personne pn = new personne();
		for(int i = 2; i<nbLignes(file); i++) {
			
			String line = fichier.readLine();
			
			String[] elements = line.split(";");
			id = (elements [0]);
			nom= (elements [1]);
			prenom= (elements [4]);
			adresse = (elements [2]);
			numtel = Integer.parseInt(elements [3]);
			fonction = (elements [5]);
			pn.setadherents(id, nom, prenom,adresse ,numtel, fonction);
					
		}
	}
	public void Beneficiares(String files) throws IOException {
		BufferedReader fichier = new BufferedReader(new FileReader(files));
		personne pn = new personne();
		for(int i = 1; i<nlignes(files); i++) {
				
			String line = fichier.readLine();
				
			String[] elements = line.split(";");
			id = (elements [0]);
			nom= (elements [1]);
			adresse = (elements [2]);
			numtel = Integer.parseInt(elements [3]);
			prenom= (elements [4]);
			birthdate = (elements [5]);
			pn.setbeneficiaires(id, nom, prenom, adresse,numtel, birthdate);
			
		}
		fichier.close();
	}
	public void recherchebeniftel(String file,int tel) throws IOException {
			BufferedReader fichier = new BufferedReader(new FileReader(file));
			personne pn = new personne();
				for(int i = 0; i<nlignes(file); i++) {
				
					String line = fichier.readLine();
				
					String[] elements = line.split(";");
					id = (elements [0]);
					nom= (elements [1]);
					prenom= (elements [4]);
					adresse = (elements [2]);
					numtel = Integer.parseInt(elements [3]);
					birthdate = (elements [5]);
					if (tel == numtel) {
						System.out.println("la pressone que vous rechercher est" +" "+ nom +" "+ prenom +" "+ adresse + " "+ "0"+numtel + " " + birthdate);
			
					}
					
				}
				fichier.close();
	}
	
	
	public void recherchebeniftnom(String file,String noms) throws IOException{
	  File f1=new File(file);
      String[] words=null;  
      FileReader fr = new FileReader(f1); 
      BufferedReader br = new BufferedReader(fr);
      String s;       
      int count=0;   
      while((s=br.readLine())!=null)  
      {	
         words=s.split(";"); 
          for (String word : words) 
          {
                 if (word.equals(noms))  
                 {
                	String[] elements = s.split(";");
             		id = (elements [0]);
             		nom= (elements [1]);
             		prenom= (elements [4]);
             		adresse = (elements [2]);
             		numtel = Integer.parseInt(elements [3]);
             		birthdate = (elements [5]);
                    count++;  
                 }
          }
      }
      if(count!=0)  
      {
         System.out.println("la pressone que vous rechercher est" +" "+ nom +" "+ prenom +" "+ adresse + " "+ "0"+numtel + " " + birthdate);
      }
      else
      {
         System.out.println("la persone que vous chercher n'existe pas dans l'association");
      }
      
         fr.close();
   }
	public void supppersonne(String file,String so) {
	        File fileToBeModified = new File(file);
	         
	        String oldContent = "";
	        String ne = " ";
	         
	        BufferedReader reader = null;
	         
	        FileWriter writer = null;
	         
	        try
	        {
	            reader = new BufferedReader(new FileReader(fileToBeModified));
	             
	            //Reading all the lines of input text file into oldContent
	             
	            String line = reader.readLine();
	             
	            while (line != null) 
	            {
	                oldContent = oldContent + line + System.lineSeparator();
	                 
	                line = reader.readLine();
	            }
	             
	            //Replacing oldString with newString in the oldContent
	             
	            String newContent = oldContent.replaceAll(so, ne);
	             
	            //Rewriting the input text file with newContent
	             
	            writer = new FileWriter(fileToBeModified);
	             
	            writer.write(newContent);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                //Closing the resources
	                 
	                reader.close();
	                 
	                writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	  
	public void modifpersonne(String file,String so,String si) {
	        File fileToBeModified = new File(file);
	         
	        String oldContent = "";
	         
	        BufferedReader reader = null;
	         
	        FileWriter writer = null;
	         
	        try
	        {
	            reader = new BufferedReader(new FileReader(fileToBeModified));
	             
	            //Reading all the lines of input text file into oldContent
	             
	            String line = reader.readLine();
	             
	            while (line != null) 
	            {
	                oldContent = oldContent + line + System.lineSeparator();
	                 
	                line = reader.readLine();
	            }
	             
	            //Replacing oldString with newString in the oldContent
	             
	            String newContent = oldContent.replaceAll(so, si);
	             
	            //Rewriting the input text file with newContent
	             
	            writer = new FileWriter(fileToBeModified);
	             
	            writer.write(newContent);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                //Closing the resources
	                 
	                reader.close();
	                 
	                writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	public void recherchepersonne(String file,String noms) throws IOException{
		  File f1=new File(file);
	      String[] words=null;  
	      FileReader fr = new FileReader(f1); 
	      BufferedReader br = new BufferedReader(fr);
	      String s;       
	      int count=0;   
	      while((s=br.readLine())!=null)  
	      {	
	         words=s.split(";"); 
	          for (String word : words) 
	          {
	                 if (word.equals(noms))  
	                 {
	                	String[] elements = s.split(";");
	             		id = (elements [0]);
	             		nom= (elements [1]);
	             		prenom= (elements [4]);
	             		adresse = (elements [2]);
	             		numtel = Integer.parseInt(elements [3]);
	             		birthdate = (elements [5]);
	                    count++;  
	                 }
	          }
	      }
	      if(count!=0)  
	      {
	         System.out.println("la pressone que vous rechercher est" +" "+ nom +" "+ prenom +" "+ adresse + " "+ "0"+numtel + " " + birthdate);
	      }
	      else
	      {
	         System.out.println("la persone que vous chercher n'existe pas dans l'association");
	      }
	      
	         fr.close();
	   }
}


