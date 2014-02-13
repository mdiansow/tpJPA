package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.ElectroMenager;
import fr.istic.tpjpa.domain.ElectronicDevice;
import fr.istic.tpjpa.domain.Heater;
import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;
import fr.istic.tpjpa.domain.Smartphone;

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

    /**
     * Create person
     */
    public void createPerson() {
        int numOfPerson = manager
                .createQuery("select  p from Person p", Person.class)
                .getResultList().size();

        if (numOfPerson == 0) {
            Person p1 = new Person("Imane", "Hormal");

            Person p2 = new Person("Mamadou", "SOW");
            Person p3 = new Person("aaa", "trar");
            Person p4 = new Person("rthhztr", "erar");
            this.createDevice(p1);

            this.createHome(p1);
            this.createHome(p2);

            List<Person> persons3 = new ArrayList<Person>();
            List<Person> persons4 = new ArrayList<Person>();
            List<Person> listPersonne1 = new ArrayList<Person>();
            List<Person> listPerson2 = new ArrayList<Person>();

            listPersonne1.add(p3);
            persons3.add(p1);

            listPersonne1.add(p4);
            persons4.add(p1);

            // listPerson2.add(p1);
            // listPersonne1.add(p2);

            p4.setFriends(persons4);
            p1.setFriends(listPersonne1);
            p3.setFriends(persons3);
            p2.setFriends(listPerson2);

            manager.persist(p1);
            manager.persist(p2);
            manager.persist(p3);
            manager.persist(p4);

        }
    }

    /**
     * Cr�ation des homes
     */
    public void createHome(Person p) {
        List<Home> homes = new ArrayList<Home>();
        Home home1 = new Home("ADD " + p.getNom()
                + "\t 29, Avenue du prof Foulon.", 51545.0, "00.000.14.144");
        Home home3 = new Home("ADD " + p.getNom() + "\t 1, Guinée", 51545.0,
                "00.000.14.144");

        Heater h = new Heater(home1, "Electrique");
        /*
         * Ajout de la liste de chauffage à la maison
         */
        List<Heater> listH = new ArrayList<Heater>();
        listH.add(h);
        home1.setHeaters(listH);
        
        
        homes.add(home1);
        homes.add(home3);

        p.setHomes(homes);
    }

    /**
     * Cr�ation des devices
     */
    public void createDevice(Person p) {

        List<ElectronicDevice> list = new ArrayList<ElectronicDevice>();

        for (int i = 0; i < 2; i++) {
            ElectronicDevice smart;

            ElectronicDevice electro;
            try {
                smart = new Smartphone("Smartphone_" + i, Random.class
                        .newInstance().nextDouble() / (i + 1), 17.0 / (i + 2));
                electro = new ElectroMenager("Electromenager_" + i, 25.0);

                list.add(smart);
                list.add(electro);
            } catch (InstantiationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                System.out.println("prob d'instanciation");
            } catch (IllegalAccessException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                System.out.println("prob d'arguments");
            }
        }

        p.setDevices(list);
    }

    /**
     * liste de toutes les personnes
     */
    private void listPersons() {
        List<Person> resultList = manager.createQuery("select a from Person a",
                Person.class).getResultList();
        System.out.println("Nb of persons: " + resultList.size());
        for (Person next : resultList) {
            System.out.println("next person: " + next);
        }
    }

}
