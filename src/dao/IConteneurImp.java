package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnection;
import entities.Conteneur;


public class IConteneurImp implements IConteneurDao{

	@Override
	public Conteneur save(Conteneur c) {
		Connection connection= SingletonConnection.getConnection();
		try{
			PreparedStatement ps1 = connection.prepareStatement 
					("SELECT id_depot FROM `depot` WHERE nb_place =(SELECT min(nb_place) FROM depot)");	
			         ResultSet rs = ps1.executeQuery();
			         while(rs.next()){
				        	c.setId_depot(rs.getInt("id_depot"));
				        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = connection.prepareStatement 
					("INSERT INTO conteneur (id_depot,type, largeur, hauteur, longueur, largeur_porte, hauteur_porte, longueur_porte, poids, capacite, prix)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)");			
			ps.setInt(1, c.getId_depot());
			System.out.println(c.getId_depot());
			ps.setString(2, c.getType());
			ps.setDouble(3, c.getLargeur());
			ps.setDouble(4, c.getHauteur());
			ps.setDouble(5, c.getLongueur());
			ps.setDouble(6, c.getLargeur_porte());
			ps.setDouble(7, c.getHauteur_porte());
			ps.setDouble(8, c.getLongueur_porte());
			ps.setDouble(9, c.getPoids());
			ps.setDouble(10, c.getCapacite());
			ps.setDouble(11, c.getPrix());	
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 0;
		try{
			PreparedStatement ps2 = connection.prepareStatement 
					("SELECT nb_place FROM `depot` WHERE id_depot=?");
			System.out.println(c.getId_depot());
			ps2.setInt(1,c.getId_depot());
			ResultSet rs = ps2.executeQuery();
			         while(rs.next()){
				        	a=rs.getInt("nb_place");
				        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a=a+1;
		try{
			PreparedStatement ps = connection.prepareStatement  ("UPDATE depot SET nb_place = ? WHERE id_depot = ?");
			ps.setInt(1,a);
			ps.setInt(2, c.getId_depot());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List<Conteneur> ConteneurAll() {
		List<Conteneur> contns = new ArrayList<>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT * FROM conteneur");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Conteneur c = new Conteneur();
				c.setId(rs.getInt("id"));
				c.setId_depot(rs.getInt("id_depot"));
				c.setType(rs.getString("type"));
				c.setLargeur(rs.getDouble("largeur"));
				c.setHauteur(rs.getDouble("hauteur"));
				c.setLongueur(rs.getDouble("longueur"));	
				c.setLongueur_porte(rs.getDouble("largeur_porte"));
				c.setLargeur_porte(rs.getDouble("largeur_porte"));
				c.setHauteur_porte(rs.getDouble("hauteur_porte"));
				c.setPoids(rs.getDouble("poids"));
				c.setCapacite(rs.getDouble("capacite"));
				c.setPrix(rs.getDouble("prix"));
				contns.add(c);		
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contns;
	}
	@Override
	public List<Conteneur> produitParMC(String mc) {
		return null;
	}

	@Override
	public Conteneur getConteneur(int id) {
		Conteneur c = new Conteneur();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT * FROM conteneur where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				c.setId(rs.getInt("id"));
				c.setId_depot(rs.getInt("id_depot"));
				c.setType(rs.getString("type"));
				c.setLargeur(rs.getDouble("largeur"));
				c.setHauteur(rs.getDouble("hauteur"));
				c.setLongueur(rs.getDouble("longueur"));	
				c.setLongueur_porte(rs.getDouble("largeur_porte"));
				c.setLargeur_porte(rs.getDouble("largeur_porte"));
				c.setHauteur_porte(rs.getDouble("hauteur_porte"));
				c.setPoids(rs.getDouble("poids"));
				c.setCapacite(rs.getDouble("capacite"));
				c.setPrix(rs.getDouble("prix"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public Conteneur update(Conteneur c) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE conteneur SET "			
					+ "id_depot =?,"
					+ " type = ?,"
					+ "largeur = ?,"
					+ "hauteur = ?,"
					+ "longueur = ?,"
					+ "largeur_porte = ?,"
					+ "hauteur_porte=?,"
					+ "longueur_porte=?,"
					+ "poids = ?,"
					+ "capacite = ?,"
					+ "prix=?"
					+ " WHERE  id = ?") ;
			
			ps.setInt(1,c.getId_depot());
			ps.setString(2,c.getType());
			ps.setDouble(3,c.getLargeur());
			ps.setDouble(4,c.getHauteur());
			ps.setDouble(5,c.getLongueur());
			ps.setDouble(6,c.getLargeur_porte());
			ps.setDouble(7,c.getHauteur_porte());
			ps.setDouble(8,c.getLongueur_porte());
			ps.setDouble(9,c.getPoids());
			ps.setDouble(10,c.getCapacite());
			ps.setDouble(11,c.getPrix());
			ps.setInt(12, c.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return c;
		
	}

	@Override
	public void deleteConteneur(int id) {
		Connection connection= SingletonConnection.getConnection();
		int number_of_depots = 0;
		try{
			PreparedStatement ps1 = connection.prepareStatement 
					("SELECT nb_place from depot d , conteneur c where c.id =?   AND c.id_depot = d.id_depot");
			         ps1.setInt(1, id);
			         ResultSet rs = ps1.executeQuery();
			         while(rs.next()){
				        	number_of_depots=rs.getInt("nb_place");

				        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = connection.prepareStatement 
					("DELETE FROM  conteneur  WHERE  id =?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ID = 0;
		try{
			PreparedStatement ps1 = connection.prepareStatement 
					("SELECT id_depot from depot where nb_place = ? ");
			         ps1.setInt(1, number_of_depots);
			         ResultSet rs = ps1.executeQuery();
			         while(rs.next()){
				        	ID=rs.getInt("id_depot");
				        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ID);
		number_of_depots = number_of_depots - 1 ;
		try{
			PreparedStatement ps = connection.prepareStatement  ("UPDATE depot SET nb_place = ? WHERE id_depot = ?");
			ps.setInt(1, number_of_depots);
            ps.setInt(2, ID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
}
