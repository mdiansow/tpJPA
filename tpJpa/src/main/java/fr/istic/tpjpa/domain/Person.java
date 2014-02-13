package fr.istic.tpjpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

    private Long id;
    private String nom;
    private String prenom;
    private char genre;
    private String mail;
    private Date dateNaiss;
    private String profilFb;

    private List<Person> friends = new ArrayList<Person>();

    private List<Home> homes = new ArrayList<Home>();

    private List<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();

    /**
     * Default constructor
     */
    public Person() {
    }

    public Person(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

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
     * @param nom
     *            the nom to set
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
     * @param prenom
     *            the prenom to set
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
     * @param genre
     *            the genre to set
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
     * @param mail
     *            the mail to set
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
     * @param dateNaiss
     *            the dateNaiss to set
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
     * @param profilFb
     */
    public void setProfilFb(String profilFb) {
        this.profilFb = profilFb;
    }

    /**
     * @return the friends
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Friends_Amis")
    public List<Person> getFriends() {
        return new ArrayList<Person>(this.friends);
    }

    /**
     * @param friends
     */
    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    /**
     * @return the devices
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    public List<ElectronicDevice> getDevices() {
        return new ArrayList<ElectronicDevice>(this.devices);
    }

    /**
     * @param devices
     *            the devices to set
     */
    public void setDevices(List<ElectronicDevice> devices) {
        this.devices = devices;
    }

    /**
     * @return the homes
     */
    @OneToMany(mappedBy = "personne", cascade = CascadeType.PERSIST)
    public List<Home> getHomes() {
        return new ArrayList<Home>(homes);
    }

    /**
     * @param homes
     *            the homes to set
     */
    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }
}
