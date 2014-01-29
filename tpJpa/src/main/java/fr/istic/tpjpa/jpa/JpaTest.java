package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		// create entity persist entityb
		test.createPerson();

		tx.commit();

		test.listPersons();

		System.out.println(".. done");
	}

	public void createPerson() {
		int numOfPerson = manager
				.createQuery("select  p from Person p", Person.class)
				.getResultList().size();

		if (numOfPerson == 0) {
			Home home = new Home("29, Avenue du prof Foulon.", 51545.0,
					"00.000.14.144");
			manager.persist(home);
			Person p1 = new Person("Imane", "Hormal");
			Person p2 = new Person("Mamadou", "SOW");
			Person p3 = new Person("aaa", "trar");
			Person p4 = new Person("rthhztr", "erar");

			List<Person> persons3 = new ArrayList<Person>();
			List<Person> persons4 = new ArrayList<Person>();
			List<Person> listPersonne1 = new ArrayList<Person>();
			List<Person> listPerson2 = new ArrayList<Person>();

			listPersonne1.add(p3);
			persons3.add(p1);
			
			listPersonne1.add(p4);
			persons4.add(p1);
		
			p4.setFriends(persons4);
			p1.setFriends(listPersonne1);
			p3.setFriends(persons3);
			
			manager.persist(p1);
			manager.persist(p2);
			manager.persist(p3);
			manager.persist(p4);

		}
	}

	private void listPersons() {
		List<Person> resultList = manager.createQuery("select a from Person a",
				Person.class).getResultList();
		System.out.println("Nb of persons: " + resultList.size());
		for (Person next : resultList) {
			System.out.println("next person: " + next);
		}
	}

}
