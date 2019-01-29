package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Person;

public class DAO {

	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void populate(Person person) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

	
		session.saveOrUpdate(person);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Person> queryPersonByName(String firstName,String lastName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("Person.byName");
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		
		@SuppressWarnings("unchecked")
		List<Person> personList = query.getResultList();


		session.getTransaction().commit();
		session.close();
		return personList;
	}
	
	public List<Person> queryAllPerson() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Person.all");
		
		@SuppressWarnings("unchecked")
		List<Person> personList = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return personList;
	}

}
