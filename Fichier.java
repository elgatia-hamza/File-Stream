package gestion.fichier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Fichier {
	private BufferedReader fr;
	private BufferedWriter fw;
	private char mode;

	public Fichier() {

	}

	public Fichier(char mode) {
		this.mode = mode;
	}

	public char getMode() {
		return mode;
	}

	public void setMode(char mode) {
		this.mode = mode;
	}
	
	public void ouvrir(String nomFichier, String m) {
		mode = (m.toUpperCase()).charAt(0);
		try {
			if(mode=='R' || mode=='L') {
				fr=new BufferedReader(new FileReader(new File(nomFichier)));
			}
			else if(mode=='W'||mode=='E') {
				fw=new BufferedWriter(new FileWriter(new File(nomFichier)));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ecrire(String fileContent) throws IOException {
		if(fileContent != null) {				
			fw.write(fileContent);
			fw.newLine();
		}
	}
	
	public String lire() throws IOException {
		String chaine = fr.readLine();
		return chaine;
	}
	
	public void fermer() throws IOException {
		if(mode=='R' || mode=='L') {
			fr.close();
		}
		else if(mode=='W'||mode=='E') {
			fw.close();
		}
	}
}
