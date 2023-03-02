package dao;

import java.util.List;
import entities.Depot;

public interface IDepotImplDao {
	
	public Depot save(Depot D);
	public List<Depot> DepotAll();
	public List<Depot> DepotParMC(String mc);
	public Depot getDepot(int id_depot);
	public Depot update(Depot D);
	public void deleteDepot(int id_depot);
	
}

