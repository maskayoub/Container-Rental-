package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import entities.Fournisseur;

public class IFournisseurImp implements IFournisseurImpDao {

	@Override
	public Fournisseur save(Fournisseur f) {
		Connection connection= SingletonConnection.getConnection();
		try{
			PreparedStatement ps =connection.prepareStatement("INSERT INTO Fournisseur(nom, prenom, email, adresse, tel, fax) VALUES (?,?,?,?,?,?)");
			ps.setString(1, f.getNom());
			ps.setString(2, f.getPrenom());
			ps.setString(3, f.getEmail());
			ps.setString(4, f.getAdresse());
			ps.setString(5, f.getTel());
			ps.setString(6, f.getFax());
			ps.executeUpdate();
			ps.close();
			
		} catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public List<Fournisseur> FournisseurAll() {
		List<Fournisseur> fournisseurs =  new ArrayList<>();
		Connection  connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM fournisseur WHERE 1");
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Fournisseur f = new Fournisseur();
				f.setId_fournisseur(rs.getInt("id_fournisseur"));
				f.setNom(rs.getString("nom"));
				f.setPrenom(rs.getString("prenom"));
				f.setEmail(rs.getString("email"));
				f.setAdresse(rs.getString("adresse"));
				f.setTel(rs.getString("tel"));
				f.setFax(rs.getString("fax"));
				fournisseurs.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return fournisseurs;
	}
	@Override
	public List<Fournisseur> FournisseurParMC(String mc) {
		List<Fournisseur> fournisseurs =  new ArrayList<>();
		Connection  connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM fournisseur WHERE nom LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Fournisseur f = new Fournisseur();
				f.setId_fournisseur(rs.getInt("id_fournisseur"));
				f.setNom(rs.getString("nom"));
				f.setPrenom(rs.getString("prenom"));
				f.setEmail(rs.getString("email"));
				f.setAdresse(rs.getString("adresse"));
				f.setTel(rs.getString("tel"));
				f.setFax(rs.getString("fax"));
				fournisseurs.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return fournisseurs;
		
		
	}

	@Override
	public Fournisseur getFournisseur(int id) {
		Fournisseur f = new Fournisseur();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT  nom, prenom, email, adresse, tel,"
					+ " fax FROM fournisseur WHERE id_fournisseur = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				f.setId_fournisseur(id);
				f.setNom(rs.getString("nom"));
				f.setPrenom(rs.getString("prenom"));
				f.setEmail(rs.getString("email"));
				f.setAdresse(rs.getString("adresse"));
				f.setTel(rs.getString("tel"));
				f.setFax(rs.getString("fax"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return f;
	}

	@Override
	public Fournisseur update(Fournisseur f) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE fournisseur SET nom = ?, prenom = ?, email = ?,"
					+ " adresse = ?, tel = ?, fax = ? WHERE id_fournisseur = ?") ;
			ps.setString(1, f.getNom());
			ps.setString(2, f.getPrenom());
			ps.setString(3, f.getEmail());
			ps.setString(4, f.getAdresse());
			ps.setString(5, f.getTel());
			ps.setString(6, f.getFax());
			ps.setInt(7, f.getId_fournisseur());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 
		return f;
	}

	@Override
	public void deleteFournisseur(int id) {
		// DELETE FROM `fournisseur` WHERE 0
		Connection  connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM fournisseur WHERE id_fournisseur = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
