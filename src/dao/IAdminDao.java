/**
 * 
 */
package dao;

import entities.Admin;
import entities.Client;
/**
 * @author compaq
 *
 */
public interface IAdminDao {
	public Admin getAdmin(String l, String pwd);	
	public boolean login(String l, String pwd);
}
