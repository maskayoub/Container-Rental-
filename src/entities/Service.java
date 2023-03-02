package entities;

public class Service {
	int id;
	String service;
	
	public Service(String service) {
		super();
		this.service = service;
	}
	public Service() {
		super();
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", service=" + service + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}

}
