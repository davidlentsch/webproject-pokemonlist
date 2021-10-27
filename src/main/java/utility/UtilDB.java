package utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import datamodel.Pokemon;

public class UtilDB {
	static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) { return sessionFactory; }
		
		// New versions of Hibernate don't like the code given in class and is considered deprecated.
		// Source for this code: https://stackoverflow.com/questions/33005348/hibernate-5-org-hibernate-mappingexception-unknown-entity
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		return metadata.getSessionFactoryBuilder().build();
	}
	
	public static void createPokemon(String pokemonName, String nickname, String favDescription, String emailAddress) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Pokemon(pokemonName, nickname, favDescription, emailAddress));
			tx.commit();
		} catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	public static List<Pokemon> listPokemon() {
		List<Pokemon> resultList = new ArrayList<Pokemon>();
		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List<?> pokemon = session.createQuery("FROM Pokemon").list();
			for (Iterator<?> iterator = pokemon.iterator(); iterator.hasNext();) {
				Pokemon pkmn = (Pokemon) iterator.next();
				resultList.add(pkmn);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return resultList;
	}
	
}
