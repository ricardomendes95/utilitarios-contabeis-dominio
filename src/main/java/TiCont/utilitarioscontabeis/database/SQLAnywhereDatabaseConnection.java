package TiCont.utilitarioscontabeis.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TiCont.utilitarioscontabeis.utils.PropertiesReader;

public class SQLAnywhereDatabaseConnection implements IDatabase {
	private Connection connection;
	private String uid;
	private String pwd;
	private String server;
	private String database;
	private String host;

	public SQLAnywhereDatabaseConnection() {
		PropertiesReader propertiesReader = new PropertiesReader("database.properties");

		this.uid = propertiesReader.getProp("uid");
		this.pwd = propertiesReader.getProp("pwd");
		this.server = propertiesReader.getProp("server");
		this.database = propertiesReader.getProp("database");
		this.host = propertiesReader.getProp("host");
	}

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(getDatabaseURL());
		
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			
			connection = null;
			
			return connection;
		}
	}
	
	private String getDatabaseURL() {
		return "jdbc:sqlanywhere:uid=" + uid +
				";pwd=" + pwd + 
				";eng=" + server + 
				";database=" + database + 
				";links=tcpip(host=" + host  + ")";
	}
	
	public boolean hasConnection() {
		return connection != null;
	}
}
