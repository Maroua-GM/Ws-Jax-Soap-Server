package fr.doranco.jaxws.main;

import java.util.List;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.EtudiantService;
import fr.doranco.jaxws.IEtudiantService;

public class Test {

	public static void main(String[] args) throws Exception {
		IEtudiantService etudiantService = new EtudiantService();

		Etudiant etudiant = new Etudiant("benkhedir", "maroua", "java", 29);
		System.out.println("Test de la methode d'ajout d'un etudiant: " + etudiant);
		Etudiant etudiantAdded = etudiantService.addEtudiant(etudiant);
		if (etudiantAdded.getId() != 0) {
			System.out.println("l'etudiant a bien ete ajouté: " + etudiantAdded);

		} else {
			System.err.println("l'etudiant n'a pas pu etre ajouté");
		}

		System.out.println("**************************************************");

		Etudiant etudiant2 = new Etudiant("gamraoui", "mahfoud", "securité", 29);
		System.out.println("Test de la methode d'ajout d'un autre etudiant: " + etudiant2);
		Etudiant etudiantAdded2 = etudiantService.addEtudiant(etudiant2);
		if (etudiantAdded2.getId() != 0) {
			System.out.println("l'etudiant a bien ete ajouté: " + etudiantAdded2);

		} else {
			System.err.println("l'etudiant n'a pas pu etre ajouté");
		}

		System.out.println("**************************************************");
		System.out.println("Test de la methode de recuperation de tous les etudiants: ");
		List<Etudiant> etudiants = etudiantService.getEtudiants();
		etudiants.forEach(System.out::println);

	}

}
