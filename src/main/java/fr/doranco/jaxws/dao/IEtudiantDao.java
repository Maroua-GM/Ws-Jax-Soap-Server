package fr.doranco.jaxws.dao;

import java.util.List;

import fr.doranco.entity.Etudiant;

public interface IEtudiantDao {

	public Etudiant addEtudiant(Etudiant etudiant) throws Exception;

	public List<Etudiant> getEtudiants() throws Exception;

	public Etudiant getEtudiantById(Integer id) throws Exception;

}
