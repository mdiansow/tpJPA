package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Home {

	public Home() {

	}

	public Home(String adresse, Double superficie, String ipAdress) {
		super();
		this.adresse = adresse;
		this.superficie = superficie;
		this.ipAdress = ipAdress;
	}

	private Long id;
	
	private String adresse;

	private Double superficie;

	private String ipAdress;

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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
