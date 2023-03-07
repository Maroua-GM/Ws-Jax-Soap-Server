package fr.doranco.jaxws.connexion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class DataSourceConnexion {

	private static DataSourceConnexion instance;
	private static SessionFactory sessionFactory;
	private static Session session;

	public DataSourceConnexion() throws HibernateException {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}

	}

	public synchronized static Session getSession() throws HibernateException {
		if (instance == null) {
			instance = new DataSourceConnexion();
		}
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

}
