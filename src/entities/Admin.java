package entities;
public class Admin {
	private int  Id ;
	private String login;
	private String mdp;
	
	
	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", login=" + login + ", mdp="
				+ mdp + "]";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return mdp;
	}
	public void setPassword(String mdp) {
		this.mdp = mdp;
	}
	public Admin(String login, String mdp) {
		this.login = login;
		this.mdp= mdp;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
