package entities;

import java.io.Serializable;
import java.sql.Date;

public class DemLocation implements Serializable {
	private int id_demande;
	private Date date_demande_loc;
	private Date date_debut_loc;
	private Date date_fin_loc;
	private int quantite;
	private String adresse_livraison;
	private String code_postal;
	private String ville;
	private Client client;
	private int id_client;
	private int id_conteneur;
	private Conteneur conteneur;

	public int getId_demande() {
		return id_demande;
	}
	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}
	public Date getDate_demande_loc() {
		return date_demande_loc;
	}
	public DemLocation() {
		super();
	}

	public DemLocation(Date date_demande_loc, Date date_debut_loc, Date date_fin_loc, int quantite,
			String adresse_livraison, String code_postal, String ville ) {
		super();
		this.date_demande_loc = date_demande_loc;
		this.date_debut_loc = date_debut_loc;
		this.date_fin_loc = date_fin_loc;
		this.quantite = quantite;
		this.adresse_livraison = adresse_livraison;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	public void setDate_demande_loc(Date date_demande_loc) {
		this.date_demande_loc = date_demande_loc;
	}

	
	
	
	public Date getDate_debut_loc() {
		return date_debut_loc;
	}
	public void setDate_debut_loc(Date date_debut_loc) {
		this.date_debut_loc = date_debut_loc;
	}
	public Date getDate_fin_loc() {
		return date_fin_loc;
	}
	public void setDate_fin_loc(Date date_fin_loc) {
		this.date_fin_loc = date_fin_loc;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getAdresse_livraison() {
		return adresse_livraison;
	}
	public void setAdresse_livraison(String adresse_livraison) {
		this.adresse_livraison = adresse_livraison;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Conteneur getConteneur() {
		return conteneur;
	}
	public void setConteneur(Conteneur conteneur) {
		this.conteneur = conteneur;
	}
	@Override
	public String toString() {
		return "DemLocation [id_demande=" + id_demande + ", date_demande_loc=" + date_demande_loc + ", date_debut_loc="
				+ date_debut_loc + ", date_fin_loc=" + date_fin_loc + ", quantite=" + quantite + ", adresse_livraison="
				+ adresse_livraison + ", code_postal=" + code_postal + ", ville=" + ville + ", client=" + client
				+ ", conteneur=" + conteneur + "]";
	}
	public int getId_conteneur() {
		return id_conteneur;
	}
	public void setId_conteneur(int id_conteneur) {
		this.id_conteneur = id_conteneur;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

}
