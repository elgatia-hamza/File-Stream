package gestion.fichier;

import java.io.IOException;

public class TestObjectFichier {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		FichierEtudiant fe =new FichierEtudiant();
		Etudiant e =new Etudiant(1, "El Gatia", "Hamza");
		//Ecriture:
		fe.ouvrir("Ecrire");
		fe.ecrire(e);
		fe.fermer();
		
		//Lecture
		fe.ouvrir("Lecture");
		Etudiant e1 = fe.lire();
		System.out.println(e1);
		
		

	}

}
