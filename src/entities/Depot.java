package entities;

import java.io.Serializable;

public class Depot implements Serializable{
	@Override
	public String toString() {
		return "Depot [id_depot=" + id_depot + 
				 ", nb_place=" + nb_place + ", adresse=" + adresse
				+ ", ville=" + ville + ", code_postal=" + code_postal + "]";
	}
	private int id_depot;
	private int nb_place;
	private String adresse;
	private String ville;
	private String code_postal;
	public int getNb_place() {
		return nb_place;
	}
	public void setNb_place(int nb_place) {
		this.nb_place = nb_place;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public Depot( int nb_place, String adresse, String ville, String code_postal) {
		super();
		this.nb_place = nb_place;
		this.adresse = adresse;
		this.ville = ville;
		this.code_postal = code_postal;
	}
	public Depot() {
		super();
	}
	public int getId_depot() {
		return id_depot;
	}
	public void setId_depot(int id_depot) {
		this.id_depot = id_depot;
	}
	

}
