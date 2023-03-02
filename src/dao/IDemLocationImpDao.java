package dao;

import java.util.List;

import entities.DemLocation;

public interface IDemLocationImpDao {
	public DemLocation save(DemLocation d);
	public List<DemLocation> DemLocationAll();
	public DemLocation getDemLocation(int id);
	public DemLocation update(DemLocation f);
	public void deleteDemLocation(int id);
}
