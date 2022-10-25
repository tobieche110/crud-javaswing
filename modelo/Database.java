package modelo;

//Centraliza las conexiones a la base de datos
public class Database {

	//Lo que necesito para conectarme a una BDD
	String url;
	String uss; //user
	String pwd; //password
	String driver;
	
	public Database() {
		this.url = "jdbc:mysql://localhost:3306/crudlab2";
		this.uss = "root";
		this.pwd = "";
		this.driver = "com.mysql.jdbc.Driver";
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getDriver() {
		return driver;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getUss() {
		return uss;
	}
	
}
