package entities;

import java.io.Serializable;

public class Fournisseur implements Serializable{
	private int id_fournisseur;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String tel;
	private String fax;
	public int getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
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
	public Fournisseur(String nom, String prenom, String email, String adresse, String tel, String fax) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.fax = fax;
	}
	public Fournisseur() {
		super();
	}
	@Override
	public String toString() {
		return "Fournisseur [id_fournisseur=" + id_fournisseur + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", adresse=" + adresse + ", tel=" + tel + ", fax=" + fax + "]";
	}

}
