package br.com.informa.repositories.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

	/**
	 * Location of hibernate.cfg.xml file. Location should be on the classpath
	 * as Hibernate uses #resourceAsStream style lookup for its configuration
	 * file. The default classpath location of the hibernate config file is in
	 * the default package. Use #setConfigFile() to update the location of the
	 * configuration file for the current session.
	 */
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static SessionFactory sessionFactory;

	private HibernateSessionFactory() {
	}

	/**
	 * Create if necessary, and return the singleton Hibernate SessionFactory.
	 */
	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				// configuration settings from hibernate.cfg.xml
				Configuration configuration = new Configuration()
						.configure(CONFIG_FILE_LOCATION);

				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration
						.getProperties());
				ServiceRegistry serviceRegistry = serviceRegistryBuilder
						.build();

				sessionFactory = configuration
						.buildSessionFactory(serviceRegistry);
			}
			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Obtains the current Hibernate Session instance. Auto-initializes the
	 * <code>SessionFactory</code> if needed.
	 * 
	 * @return Session
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException {
		return getSessionFactory().getCurrentSession();
	}

	/*
	 * private static SessionFactory buildSessionFactory() { try { if
	 * (sessionFactory == null) { // configuration settings from
	 * hibernate.cfg.xml Configuration configuration = new
	 * Configuration().configure();
	 * 
	 * StandardServiceRegistryBuilder serviceRegistryBuilder = new
	 * StandardServiceRegistryBuilder();
	 * serviceRegistryBuilder.applySettings(configuration .getProperties());
	 * ServiceRegistry serviceRegistry = serviceRegistryBuilder .build();
	 * 
	 * sessionFactory = configuration .buildSessionFactory(serviceRegistry); }
	 * return sessionFactory; } catch (Throwable ex) {
	 * System.err.println("Initial SessionFactory creation failed." + ex); throw
	 * new ExceptionInInitializerError(ex); } }
	 */
}
