package dao;

import entities.Client;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     IClientImpl store  = new IClientImpl() ;
     
     store.save(new Client("Oussama", "Dridi", "oussama@gmai.com", "kenitra", "123", "123", "Oussama11"));
	}

}
