package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {

    public Home() {
    }

    public Home(String adresse, Double superficie, String ipAdress) {
        this.adresse = adresse;
        this.superficie = superficie;
        this.ipAdress = ipAdress;
    }

    private Long id;

    private String adresse;

    private Double superficie;

    private String ipAdress;

    private Person personne;

    private List<Heater> heaters = new ArrayList<Heater>();

    private List<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse
     *            the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the superficie
     */
    public Double getSuperficie() {
        return superficie;
    }

    /**
     * @param superficie
     *            the superficie to set
     */
    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    /**
     * @return the ipAdress
     */
    public String getIpAdress() {
        return ipAdress;
    }

    /**
     * @param ipAdress
     *            the ipAdress to set
     */
    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
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

    /**
     * @return the personne
     */
    @ManyToOne
    public Person getPersonne() {
        return personne;
    }

    /**
     * @param personne
     *            the personne to set
     */
    public void setPersonne(Person personne) {
        this.personne = personne;
    }

    /**
     * @return the heaters
     */
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
    public List<Heater> getHeaters() {
        return new ArrayList<Heater>(this.heaters);
    }

    /**
     * @param heaters
     *            the heaters to set
     */
    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

}
