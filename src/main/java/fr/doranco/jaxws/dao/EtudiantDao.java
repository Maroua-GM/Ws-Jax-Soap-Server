package fr.doranco.jaxws.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.connexion.DataSourceConnexion;

public class EtudiantDao implements IEtudiantDao {

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		Session session = null;
		Transaction tx = null;
		if (etudiant == null || etudiant.getNom() == null || etudiant.getNom().trim().isEmpty()
				|| etudiant.getPrenom() == null || etudiant.getPrenom().trim().isEmpty()
				|| etudiant.getSpecialite() == null || etudiant.getSpecialite().trim().isEmpty()) {
			throw new IllegalArgumentException("on accepte pas une valeur null");
		}

		try {
			session = DataSourceConnexion.getSession();
			tx = session.beginTransaction();
			Integer id = (Integer) session.save(etudiant);
			etudiant.setId(id);
			tx.commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return etudiant;
	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {

		Session session = null;

		List<Etudiant> etudiants = null;
		try {
			session = DataSourceConnexion.getSession();
			etudiants = session.createQuery("from Etudiant").list();
			if (etudiants.isEmpty()) {
				throw new NoSuchElementException("la liste est vide");
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return etudiants;
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws Exception {
		Session session = null;
		Etudiant etudiant = null;
		if (id == null || id < 0) {
			throw new IllegalArgumentException("parametre erroné");
		}
		try {
			session = DataSourceConnexion.getSession();
			etudiant = (Etudiant) session.createQuery("select e from Etudiant e where id=?1").setParameter(1, id)
					.getSingleResult();
		} catch (Exception e) {
			throw new NoSuchElementException("l'etudiant n'existe pas");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return etudiant;
	}

}
