package projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Don {
	private String table;
	private String chaise;
	private String electroMenager;
	private String cuisinière;
	private String refrigérateur;
	private String laveLinge;
	private String Vaisselle;
	private String couverts;
	private String assiettees;
	
	public Don (String table,String chaise,String electromenager,String cuisiniere,String refrigerateur,String laveLinge,String vaisselle,String couverts,String assiettess) {
		this.table=table;
		this.chaise=chaise;
		this.electroMenager=electromenager;
		this.cuisinière=cuisiniere;
		this.refrigérateur=refrigerateur;
		this.laveLinge=laveLinge;
		this.Vaisselle=vaisselle; 
		this.couverts=couverts;
		this.assiettees=assiettess;
		}
	public Don() {
	}
	public void creeundon(String Datededon,String file,String nom,String prenom,String adresse,String numtel2,String fonction,String don,String Statue)  throws IOException{
		 FileWriter fileWriter = new FileWriter(file);
		 String acef= "En attente";
		 PrintWriter printWriter = new PrintWriter(fileWriter);
		 printWriter.printf(Datededon+","+ don +","+ nom +","+ prenom +","+ adresse + ","+ "0"+numtel2 + "," + fonction +","+ Statue + "," + acef);
		
	}
	public static int nbLignes(String file) throws IOException {
		
		int nblignes = 0;
		
		BufferedReader fichier = new BufferedReader(new FileReader(file));
		
		while(fichier.readLine() != null) { //Pour chaque ligne, incrémente nblignes.
			nblignes++;
		}
		return nblignes;
	}
	public void accundon(String file,String option,int lignededon) throws IOException {
	        File fileToBeModified = new File(file);
	         
	        String oldContent = "";
	         
	        BufferedReader reader = null;
	        String acef= "En attente";
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
	             
	            String newContent = oldContent.replaceAll(acef, option);
	             
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
	    System.out.print("don stocker");
	    }
	
}	