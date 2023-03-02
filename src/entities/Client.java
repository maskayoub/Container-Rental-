package entities;

import java.io.Serializable;

public class Client implements Serializable {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String tel;
	private String fax;
	private String mdp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse + ", tel="
				+ tel + ", fax=" + fax + ", mdp=" + mdp + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPassword() {
		return mdp;
	}
	public void setPassword(String mdp) {
		this.mdp = mdp;
	}
	public Client(String nom, String prenom, String email, String adresse, String tel, String fax, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.fax = fax;
		this.mdp = mdp;
	}
	public Client() {
		super();
	}
	

}
