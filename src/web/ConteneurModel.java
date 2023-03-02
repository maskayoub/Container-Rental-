package web;

import java.util.List;

import entities.Admin;
import entities.Client;
import entities.Conteneur;
import entities.DemLocation;
import entities.Depot;
import entities.Fournisseur;

public class ConteneurModel {
	private Conteneur c;
	private List<Conteneur> conteneurs;
	private Client cl;
	private List<Client> clients;
	private Fournisseur fr;
	private List<Fournisseur> fournisseurs; 
	private List<Depot> depots;
	private Depot dep;	
	private Admin admin;
	private DemLocation demande;
	private List<DemLocation> demandes;
	//Liste depot
	public List<Depot> getDepots() {
		return depots;
	}
	public void setDepots(List<Depot> depots) {
		this.depots = depots;
	}
	// fin liste depot
	//depot
	public Depot getDep() {
		return dep;
	}
	public void setDep(Depot dep) {
		this.dep = dep;
	}
	// fin depot
	//fournisseur
	public Fournisseur getFr() {
		return fr;
	}
	public void setFr(Fournisseur fr) {
		this.fr = fr;
	}
	//fin fournissuer
	//
	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	public Client getCl() {
		return cl;
	}

	public void setCl(Client cl) {
		this.cl = cl;
	}

	public List<Conteneur> getConteneurs() {
		return conteneurs;
	}

	public void setConteneurs(List<Conteneur> conteneurs) {
		this.conteneurs = conteneurs;
	}

	public Conteneur getC() {
		return c;
	}

	public void setC(Conteneur c) {
		this.c = c;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public DemLocation getDemande() {
		return demande;
	}
	public void setDemande(DemLocation demande) {
		this.demande = demande;
	}
	public List<DemLocation> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<DemLocation> demandes) {
		this.demandes = demandes;
	}

}
