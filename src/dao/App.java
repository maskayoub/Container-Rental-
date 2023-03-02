package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.Calendar;

import entities.CommandeFr;
import entities.Conteneur;
import entities.DemLocation;
import entities.Fournisseur;


public class App {
  

		private static Connection connection;
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhosts:3306/projet","root","");
				System.out.println("connecté");
				
			} catch (Exception e) {
				System.out.println("Erreur");
				e.printStackTrace();
			}
		}
}
    	

