package dao;

import java.util.List;

import entities.Client;
import entities.Conteneur;


public interface IClientImpDao {
	public Client save(Client p);
	public List<Client> ClientAll();
	public List<Client> ClientParMC(String mc);
	public Client getClient(int id);
	public Client update (Client p);
	public void deleteClient(int id);
	public boolean login1(String l, String pwd);
	public Client getClient(String l, String pwd);
}
