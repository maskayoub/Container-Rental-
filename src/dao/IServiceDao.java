package dao;

import java.util.List;

import entities.Service;

public interface IServiceDao {
	public Service save(Service s);
	public List<Service> ServiceAll();
	public List<Service> ServiceParMC(String mc);
	public Service getService(int id_service);
	public Service update(Service D);
	public void deleteService(int id);
}
