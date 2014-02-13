package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ELECTRONICDEVICE_ID")
public class Smartphone extends ElectronicDevice {
    
    protected Smartphone() {}

    public Smartphone(String nom, double voltage, double ecran) {
        super();
        this.setNom(nom);
        this.voltage = voltage;
        this.ecran = ecran;
    }

    private double voltage;
    
    private double ecran;

    /**
     * @return the voltage
     */
    public double getVoltage() {
        return voltage;
    }

    /**
     * @param voltage the voltage to set
     */
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    /**
     * @return the ecran
     */
    public double getEcran() {
        return ecran;
    }

    /**
     * @param ecran the ecran to set
     */
    public void setEcran(double ecran) {
        this.ecran = ecran;
    }
}
