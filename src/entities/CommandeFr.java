package entities;

import java.sql.Date;

public class CommandeFr {
	private int idCommande;
	private Fournisseur fournisseur;
	private String  type;
	private int quantite;
	private String adresseLivraison;
	private String codePostal;
	private String ville;
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getAdresseLivraison() {
		return adresseLivraison;
	}
	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public CommandeFr() {
		super();
	}
	
	@Override
	public String toString() {
		return "CommandeFr [idCommande=" + idCommande + ", fournisseur=" + fournisseur + ", type=" + type
				+ ", dateCommande="  + ", quantite=" + quantite + ", adresseLivraison=" + adresseLivraison
				+ ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	public CommandeFr(String type, int quantite, String adresseLivraison, String codePostal,
			String ville) {
		super();
		this.type = type;
		this.quantite = quantite;
		this.adresseLivraison = adresseLivraison;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	

}
