package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Client;
import entities.Depot;
import entities.Fournisseur;

public class IDepotImpl implements IDepotImplDao{

	@Override
	public Depot save(Depot d) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement  ("INSERT INTO depot ( nb_place, adresse, ville, code_postal) VALUES (?,?,?,?)");			
			ps.setInt(1, d.getNb_place());
			ps.setString(2, d.getAdresse());
			ps.setString(3, d.getVille());
			ps.setString(4, d.getCode_postal());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public List<Depot> DepotAll() {
		
		List<Depot> ListDepots = new ArrayList<>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT * FROM depot WHERE 1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Depot d = new Depot();
				d.setId_depot(rs.getInt("id_depot"));
				d.setNb_place(rs.getInt("nb_place"));
				d.setAdresse(rs.getString("adresse"));
				d.setVille(rs.getString("ville"));
				d.setCode_postal(rs.getString("code_postal"));
				ListDepots.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListDepots;
	}

	@Override
	public List<Depot> DepotParMC(String mc) {
		List<Depot> ListDepots =  new ArrayList<>();
		Connection  connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM depot WHERE lib_depot LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Depot d = new Depot();
			//	d.setLib_depot(rs.getString("lib_depot"));
				d.setNb_place(rs.getInt("nb_place"));
				d.setAdresse(rs.getString("adresse"));
				d.setVille(rs.getString("ville"));
				d.setCode_postal(rs.getString("code_postal"));
				ListDepots.add(d);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return ListDepots;
	}

	@Override
	public Depot getDepot(int id_depot) {
		Depot d = new Depot();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM depot WHERE id_depot = ?");
			ps.setInt(1, id_depot);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				d.setId_depot(rs.getInt("id_depot"));
				d.setNb_place(rs.getInt("nb_place"));
				d.setAdresse(rs.getString("adresse"));
				d.setVille(rs.getString("ville"));
				d.setCode_postal(rs.getString("code_postal"));				
			}
		} catch (Exception e) {

		}		
		return d;
	}
	@Override
	public Depot update(Depot d) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE depot SET nb_place = ?, adresse = ?, ville = ?, code_postal = ?  WHERE id_depot = ?") ;
			ps.setInt(1, d.getNb_place());
			ps.setString(2, d.getAdresse());
			ps.setString(3, d.getVille());
			ps.setString(4, d.getCode_postal());
			ps.setInt(5, d.getId_depot());
			ps.executeUpdate();
			ps.close();				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return d;	
	}
	@Override
	public void deleteDepot(int id_depot) {
		Connection  connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM depot WHERE id_depot = ?");
			ps.setInt(1, id_depot);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	

}
