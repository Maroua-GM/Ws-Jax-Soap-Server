package fr.doranco.jaxws.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.entity.Cours;
import fr.doranco.jaxws.connexion.DataSourceConnexion;

public class CoursDao implements ICoursDao {

	@Override
	public List<Cours> getCours() throws Exception {
		Session session = null;
		List<Cours> cours = null;
		try {
			session = DataSourceConnexion.getSession();
			cours = session.createQuery("from Cours").list();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cours;
	}

	@Override
	public Cours getCoursById(Integer id) throws Exception {
		Session session = null;
		Cours cours = null;
		if (id == null || id < 0) {
			throw new IllegalArgumentException("parametre erroné");
		}
		try {
			session = DataSourceConnexion.getSession();
			cours = (Cours) session.createQuery("select c from Cours c where id=?1").setParameter(1, id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cours;
	}

	@Override
	public Cours addCours(Cours cours) throws Exception {
		if (cours == null) {
			throw new Exception("on accepte pas une valeur null");
		}
		Session session = null;
		Transaction tx = null;

		try {
			session = DataSourceConnexion.getSession();
			tx = session.beginTransaction();
			Integer id = (Integer) session.save(cours);
			cours.setId(id);
			tx.commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cours;
	}

}
