package dao;

import java.util.List;

import entities.Fournisseur;



public interface IFournisseurImpDao {
	public Fournisseur save(Fournisseur f);
	public List<Fournisseur> FournisseurAll();
	public List<Fournisseur> FournisseurParMC(String mc);
	public Fournisseur getFournisseur(int id);
	public Fournisseur update(Fournisseur f);
	public void deleteFournisseur(int id);
}
