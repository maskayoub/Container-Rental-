package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entities.CommandeFr;

public class ICommandeFrImp  implements ICommandeFrDao {

	@Override
	public CommandeFr save(CommandeFr CmD) {
		Connection connection= SingletonConnection.getConnection();
		try {
				PreparedStatement ps1 = connection.prepareStatement 
						("SELECT * FROM fournisseur WHERE id_fournisseur="+CmD.getFournisseur().getId_fournisseur()+"");
	            ResultSet rs1 = ps1.executeQuery();
				if(rs1.next()){
				
		            	PreparedStatement ps = connection.prepareStatement 
		    					("INSERT INTO commandefr( id_fournisseur, type, quantite, adresse_livraison, code_postal, ville)"
		    							+ " VALUES (?,?,?,?,?,?)");
		            	ps.setInt(1, rs1.getInt("id_fournisseur")); 
		            	ps.setString(2, CmD.getType());
		    			ps.setInt(3, CmD.getQuantite());
		    			ps.setString(4, CmD.getAdresseLivraison());
		    			ps.setString(5, CmD.getCodePostal());
		    			ps.setString(6, CmD.getVille());
		    			ps.executeUpdate();
		    			ps.close();
		         
				//INSERT INTO `commandefr`(`id_commande`, `id_fournisseur`, `date_commande`, `type`, `quantite`, `adresse_livraison`, `code_postal`, `ville`)
		    			//VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CmD;
	}

	@Override
	public List<CommandeFr> CommandeFrAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandeFr getCommandeFr(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandeFr update(CommandeFr CmD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCommandeFr(int id) {
		// TODO Auto-generated method stub
		
	}

}
