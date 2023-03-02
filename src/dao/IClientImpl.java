package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Client;
import entities.Conteneur;


public class IClientImpl implements IClientImpDao{

	@Override
	public Client save(Client p) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement  ("INSERT INTO client (nom, prenom, email, adresse, tel, fax, password)  VALUES (?,?,?,?,?,?,?)");			
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getAdresse());
			ps.setString(5, p.getTel());
			ps.setString(6, p.getFax());
			ps.setString(7, p.getPassword());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Client> ClientAll() {
			List<Client> clients = new ArrayList<>();
			Connection connection = SingletonConnection.getConnection();
			try {
				//SELECT `id`, `nom`, `prenom`, `email`, `adresse`, `tel`, `fax`, `password` FROM `client` WHERE 1
				PreparedStatement ps  = connection.prepareStatement("SELECT * FROM client");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Client c  = new Client();
					c.setId(rs.getInt("id"));
					c.setNom(rs.getString("nom"));					
					c.setPrenom(rs.getString("prenom"));
					c.setEmail(rs.getString("email"));
					c.setAdresse(rs.getString("adresse"));
					c.setTel(rs.getString("tel"));
					c.setFax(rs.getString("fax"));
					c.setPassword(rs.getString("password"));
					clients.add(c);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clients;
		}
	

	@Override
	public List<Client> ClientParMC(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClient(int id) {
		Connection connection= SingletonConnection.getConnection();
		Client c  = new Client();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT * FROM client WHERE id=?");
			
			ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setAdresse(rs.getString("adresse"));
				c.setTel(rs.getString("tel"));
				c.setFax(rs.getString("fax"));
				c.setPassword("mdp");
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Client update (Client p) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement  ("UPDATE client SET nom = ?,prenom = ?,"
					+ "email = ?,adresse = ?,tel = ?,fax = ?,password = ? WHERE id = ?");						
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getAdresse());
			ps.setString(5, p.getTel());
			ps.setString(6, p.getFax());
			ps.setString(7, p.getPassword());	
			ps.setInt(8, p.getId());
            System.out.println("p="+p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return p;
	}



	@Override
	public void deleteClient(int id) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("DELETE FROM  client  WHERE  id =?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public boolean login1(String l, String pw) {
		boolean a=false;	
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT password FROM client WHERE email=?");
			//System.out.println("HIIIIIIHELP?");
			ps.setString(1, l);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() && rs.getString("password").equals(pw) ){
				a=true;			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;		
	}

	@Override
	public Client getClient(String l, String pwd) {
		Connection connection= SingletonConnection.getConnection();
		Client c  = new Client();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT id, nom, prenom, adresse, tel, fax  FROM client WHERE email=? and password=?");
			ps.setString(1, l);
			ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();		
			if(rs.next()){
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(l);
				c.setAdresse(rs.getString("adresse"));
				c.setTel(rs.getString("tel"));
				c.setFax(rs.getString("fax"));
				c.setPassword("mdp");		
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
