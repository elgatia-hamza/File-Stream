package gestion.fichier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FichierEtudiant{
	private ObjectInputStream ofr;
	private ObjectOutputStream ofw;
	private String fileName="etudiant.dat";
	private char mode;
	
	public FichierEtudiant() {
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public char getMode() {
		return mode;
	}

	public void setMode(char mode) {
		this.mode = mode;
	}
	
	public void ouvrir(String mode)throws IOException {
		this.mode = (mode.toUpperCase()).charAt(0);
		if(this.mode =='R'||this.mode=='L') {
			ofr=new ObjectInputStream(new FileInputStream(fileName));
		}
		else if(this.mode=='E'||this.mode=='W') {
			ofw=new ObjectOutputStream(new FileOutputStream(fileName));
		}
	}
	
	public void ecrire(Etudiant e) throws IOException {
		if(e!=null) {
			ofw.writeObject(e);
		}
	}
	
	public Etudiant lire() throws IOException, ClassNotFoundException{
		Etudiant e = (Etudiant)ofr.readObject();
		return e;
	}
	
	public void fermer() throws IOException{
		if(this.mode=='R'||this.mode=='L') {
			ofr.close();
		}
		else if(this.mode=='W'||this.mode=='E') {
			ofw.close();
		}
	}
	
}
