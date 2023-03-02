package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Depot;
import entities.Service;

public class IServiceImp  implements IServiceDao{

	@Override
	public Service save(Service s) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement  ("INSERT INTO `services`(`Type de Service`) VALUES (?)");			
			ps.setString(1, s.getService());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Service> ServiceAll() {
		List<Service> ListServices = new ArrayList<>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT * FROM services WHERE 1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Service s = new  Service();
				s.setId(rs.getInt("id"));
				s.setService(rs.getString("Type de service"));
				ListServices.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListServices;
	}

	@Override
	public List<Service> ServiceParMC(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service getService(int id_service) {
		Service s = new Service();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT `Type de Service` FROM `services` WHERE id = ?");
			ps.setInt(1, id_service);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				s.setService(rs.getString("Type de service"));		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
	@Override
	public Service update(Service s) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE `services` SET `Type de Service`= ? WHERE id =  ?") ;
			ps.setString(1, s.getService());
			ps.setInt(2, s.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			
		}
		// 
		return s;
	}
	@Override
	public void deleteService(int id) {
		Connection  connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM services WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
