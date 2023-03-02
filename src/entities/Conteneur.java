package entities;

public class Conteneur {
//SELECT `id_conteneur`, `prix_location`, `Status`, `Type` FROM `conteneurs` WHERE 1
	
	private int id;
	private int id_depot;
	private String etat;
	private String type;
	private double largeur;
	private double hauteur;
	private double longueur;
	private double largeur_porte;
	private double hauteur_porte;
	private double longueur_porte;
	private double poids;
	private double capacite;
	private double prix;
	@Override
	public String toString() {
		return "Conteneur [id=" + 1 + ", id_depot=" + id_depot + ", type="
				+ type + ", largeur=" + largeur + ", hauteur=" + hauteur
				+ ", longueur=" + longueur + ", largeur_porte=" + largeur_porte
				+ ", hauteur_porte=" + hauteur_porte + ", longueur_porte="
				+ longueur_porte + ", poids=" + poids + ", capacite="
				+ capacite + ", prix=" + prix + "]";
	}

	public Conteneur(int id_depot, String type, double largeur, double hauteur, double longueur, double largeur_porte,
			double hauteur_porte, double longueur_porte, double poids, double capacite, double prix , String etat) {
		super();
		this.id_depot = id_depot;
		this.type = type;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.longueur = longueur;
		this.largeur_porte = largeur_porte;
		this.hauteur_porte = hauteur_porte;
		this.longueur_porte = longueur_porte;
		this.poids = poids;
		this.capacite = capacite;
		this.prix = prix;
		this.etat = etat;
	}
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getId_depot() {
		return id_depot;
	}

	public void setId_depot(int id_depot) {
		this.id_depot = id_depot;
	}
	public Conteneur() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	public double getLargeur_porte() {
		return largeur_porte;
	}
	public void setLargeur_porte(double largeur_porte) {
		this.largeur_porte = largeur_porte;
	}
	
	public double getHauteur_porte() {
		return hauteur_porte;
	}
	public void setHauteur_porte(double hauteur_porte) {
		this.hauteur_porte = hauteur_porte;
	}
	public double getLongueur_porte() {
		return longueur_porte;
	}
	public void setLongueur_porte(double longueur_porte) {
		this.longueur_porte = longueur_porte;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public double getCapacite() {
		return capacite;
	}
	public void setCapacite(double capacite) {
		this.capacite = capacite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	}
