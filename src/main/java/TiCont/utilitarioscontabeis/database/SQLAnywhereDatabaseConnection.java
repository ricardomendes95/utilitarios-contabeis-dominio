package TiCont.utilitarioscontabeis.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TiCont.utilitarioscontabeis.utils.PropertiesReader;

public class SQLAnywhereDatabaseConnection implements IDatabase {
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

	public void getConnection() {
		// uid - user id
		// pwd - password
		// eng - Sybase database server name
		// database - sybase database name
		// host - database host machine ip
		String databaseURL = getDatabaseURL();

		// Connect to Sybase Database
		Connection con;
		try {
//			Class.forName("sybase.jdbc4.sqlanywhere.IDriver");
			con = DriverManager.getConnection(databaseURL);
		
			Statement statement = con.createStatement();
	
			// We use Sybase specific select getdate() query to return date
			ResultSet rs = statement.executeQuery("SELECT * FROM BETHADBA.geempre");
	
			while (rs.next()) {				
				String currentDate = rs.getString("nome_emp"); // get first column returned
				System.out.println("Current Date from Sybase is : " + currentDate);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getDatabaseURL() {
		return "jdbc:sqlanywhere:uid=" + uid +
				";pwd=" + pwd + 
				";eng=" + server + 
				";database=" + database + 
				";links=tcpip(host=" + host  + ")";
	}
}
