package fr.istic.tpjpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Person {

	public Person() {
	}

	public Person(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	private Long id;
	private String nom;
	private String prenom;
	private char genre;
	private String mail;
	private Date dateNaiss;
	private String profilFb;

	private List<Person> friends = new ArrayList<Person>();

	@Transient
	private List<Home> homes;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	

	public String toString() {
		return "Person[id=" + id + " , Nom=" + this.nom + "]";
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the genre
	 */
	public char getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(char genre) {
		this.genre = genre;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the dateNaiss
	 */
	public Date getDateNaiss() {
		return dateNaiss;
	}

	/**
	 * @param dateNaiss the dateNaiss to set
	 */
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	/**
	 * @return the profilFb
	 */
	public String getProfilFb() {
		return profilFb;
	}

	/**
	 * @param profilFb the profilFb to set
	 */
	public void setProfilFb(String profilFb) {
		this.profilFb = profilFb;
	}

	/**
	 * @return the friends
	 */
	@ManyToMany
	public List<Person> getFriends() {
		return new ArrayList<Person>(this.friends);
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<Person> friends) {
		this.friends = friends;
//		for(Person next : friends){
//			this.friends.add(next);
//		}
	}

//	/**
//	 * @return the friends
//	 */
//	public List<Person> getFriends() {
//		return friends;
//	}
//
//	/**
//	 * @param friends the friends to set
//	 */
//	public void setFriends(List<Person> friends) {
//		this.friends = friends;
//	}
//
//	/**
//	 * @return the homes
//	 */
//	public List<Home> getHomes() {
//		return homes;
//	}
//
//	/**
//	 * @param homes the homes to set
//	 */
//	public void setHomes(List<Home> homes) {
//		this.homes = homes;
//	}
}
