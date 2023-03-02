package dao;

import java.util.List;

import entities.Conteneur;


public interface IConteneurDao {
	public Conteneur save(Conteneur p);
	public List<Conteneur> ConteneurAll();
	public List<Conteneur> produitParMC(String mc);
	public Conteneur getConteneur(int id);
	public Conteneur update(Conteneur p);
	public void deleteConteneur(int id);
}
