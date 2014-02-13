package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater {

    protected Heater() {
    }

    public Heater(Home home, String nom) {
        this.home = home;
        this.nom = nom;
    }

    private Long id;

    private Home home;

    private String nom;

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

    /**
     * @return the home
     */
    @ManyToOne
    public Home getHome() {
        return home;
    }

    /**
     * @param home
     *            the home to set
     */
    public void setHome(Home home) {
        this.home = home;
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

}
