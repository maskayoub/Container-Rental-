package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entities.Admin;
import entities.Client;

public class IAdminImp   implements IAdminDao {

	@Override
	public Admin getAdmin(String l, String pwd) {
		Connection connection= SingletonConnection.getConnection();
		Admin c  = new Admin();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT id  FROM admin  WHERE login = ? and password = ?");	
			ps.setString(1, l);
			ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c.setId(rs.getInt("id"));
				c.setLogin(rs.getString("login"));
				c.setPassword(rs.getString("password"));
				c.setPassword(pwd);		
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	// login function.
	public boolean login(String l, String pw) {
		boolean a=false;		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT password FROM admin WHERE login = ?");
			ps.setString(1, l);
			ResultSet rs = ps.executeQuery();
			if(rs.next() &&(rs.getString("password")).equals(pw) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}


	