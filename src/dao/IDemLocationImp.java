package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.DemLocation;
import entities.Depot;

public class IDemLocationImp implements IDemLocationImpDao {

	@Override
	public DemLocation save(DemLocation d) {
		Connection connection= SingletonConnection.getConnection();
		try {
				PreparedStatement ps1 = connection.prepareStatement 
						("SELECT * FROM client WHERE id="+d.getClient().getId()+"");
	            ResultSet rs1 = ps1.executeQuery();
				if(rs1.next()){
					PreparedStatement ps2 = connection.prepareStatement 
							("SELECT * FROM  conteneur  WHERE id="+d.getConteneur().getId()+"");
		            ResultSet rs2 = ps2.executeQuery();
		            if(rs2.next()){
		            	PreparedStatement ps = connection.prepareStatement 
		    					("INSERT INTO demlocation (id_client, id_conteneur,  date_demande_loc, date_debut_loc, date_fin_loc, "
		    							+ "quantite, adresse_livraison, code_postal, ville) VALUES (?,?,?,?,?,?,?,?,?)");
		    			ps.setInt(1, rs1.getInt("id"));
		    			ps.setInt(2, rs2.getInt("id"));
		            	ps.setDate(3,(Date) d.getDate_demande_loc());
		    			ps.setDate(4,(Date) d.getDate_debut_loc());
		    			ps.setDate(5,(Date) d.getDate_fin_loc());
		    			ps.setInt(6, d.getQuantite());
		    			ps.setString(7, d.getAdresse_livraison());
		    			ps.setString(8, d.getCode_postal());
		    			ps.setString(9, d.getVille());		    			
		    			ps.executeUpdate();		    			
		    			ps.close();	            	
		            }			
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public List<DemLocation> DemLocationAll() {
		List<DemLocation> ListDemLocations = new ArrayList<>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT * FROM demlocation WHERE 1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DemLocation d = new DemLocation();
				d.setId_demande(rs.getInt("id_demande"));
			//	System.out.println("");
				d.setId_client(rs.getInt("id_client"));	
				d.setId_conteneur(rs.getInt("id_conteneur"));
				d.setDate_demande_loc(rs.getDate("date_demande_loc"));
				d.setDate_debut_loc(rs.getDate("date_debut_loc"));
				d.setDate_fin_loc(rs.getDate("date_fin_loc"));
				d.setQuantite(rs.getInt("quantite"));
				d.setAdresse_livraison(rs.getString("adresse_livraison"));
				d.setCode_postal(rs.getString("code_postal"));
				d.setVille(rs.getString("ville"));
				ListDemLocations.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListDemLocations;
	}

	@Override
	public DemLocation getDemLocation(int id) {
		DemLocation dm  = new DemLocation();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT id_client, id_conteneur,date_demande_loc,date_debut_loc,date_fin_loc,quantite,adresse_livraison,code_postal,ville FROM demlocation WHERE id_demande = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dm.setId_client(rs.getInt("id_client"));
				System.out.println("1");
				dm.setId_conteneur(rs.getInt("id_conteneur"));
				System.out.println("2");
				dm.setDate_demande_loc(rs.getDate("date_demande_loc"));
				System.out.println("3");
				dm.setDate_debut_loc(rs.getDate("date_debut_loc"));
				System.out.println("4");
				dm.setDate_fin_loc(rs.getDate("date_fin_loc"));
				System.out.println("5");
				dm.setQuantite(rs.getInt("quantite"));
				System.out.println("6");
				dm.setAdresse_livraison(rs.getString("adresse_livraison"));
				System.out.println("7");
				dm.setCode_postal(rs.getString("code_postal"));
				System.out.println("8");
				dm.setVille(rs.getString("ville"));	
				System.out.println("9");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dm;		
	}

	@Override
	public DemLocation update(DemLocation f) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE demlocation SET id_client = ?, id_conteneur = ?,"
					+ " date_demande_loc = ?, date_debut_loc = ?,date_fin_loc=? ,quantite =? ,  adresse_livraison =? "
					+ ",code_postal = ?,ville =? WHERE id_demande = ?") ;
			ps.setInt(1, f.getId_client());	
			System.out.println(f.getId_client());
			ps.setInt(2, f.getId_conteneur());
			System.out.println( f.getId_conteneur());
			ps.setDate(3,f.getDate_demande_loc());
			System.out.println(f.getDate_demande_loc());
			ps.setDate(4, f.getDate_debut_loc());
			System.out.println(f.getDate_debut_loc());
			ps.setDate(5, f.getDate_fin_loc());
			System.out.println(f.getDate_fin_loc());
			ps.setInt(6, f.getQuantite());
			System.out.println(f.getQuantite());
			ps.setString(7, f.getAdresse_livraison());
			System.out.println( f.getAdresse_livraison());
			ps.setString(8, f.getCode_postal());
			System.out.println(f.getCode_postal());
			ps.setString(9, f.getVille());
			System.out.println(f.getVille());
			ps.setInt(10,f.getId_demande());
			System.out.println(f.getId_demande());
			ps.executeUpdate();
			ps.close();
	}catch(Exception e){
		e.printStackTrace();

	}
		return f;
	}
	@Override
	public void deleteDemLocation(int id) {
		Connection  connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM demlocation WHERE id_demande = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();	
		} catch (Exception e) {
			// TODO: handle exception
		}
}
}
