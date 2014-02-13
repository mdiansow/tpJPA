package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ELECTRONICDEVICE_ID")
public class ElectroMenager extends ElectronicDevice {

    protected ElectroMenager() {
    }

    public ElectroMenager(String nom, double poids) {
        super();
        this.setNom(nom);
        this.poids = poids;
    }

    /**
     * @return the poids
     */
    public double getPoids() {
        return poids;
    }

    /**
     * @param poids {@link Double} 
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    private double poids;
}
