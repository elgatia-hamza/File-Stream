package gestion.fichier;

import java.io.IOException;

public class TestGestionFichier {

	public static void main(String[] args) throws IOException {
		Fichier f = new Fichier();
		//Ecriture:
		f.ouvrir("valeur.txt", "Ecrire");
		for(int i=0;i<=5;i++) {
			f.ecrire(String.valueOf(i));
		}
		f.fermer();
		
		//Lecture:
		f.ouvrir("valeur.txt","lecture");
		for(int i=0;i<5;i++) {
			System.out.println(f.lire());
		}
		f.fermer();
		
	}

}
