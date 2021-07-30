package TiCont.utilitarioscontabeis.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLAnywhereDatabaseConnection {
	private String uid;
	private String pwd;
	private String eng;
	private String database;
	private String host;
	
	
	 public SQLAnywhereDatabaseConnection() {
		this.uid = uid;
		this.pwd = pwd;
		this.eng = eng;
		this.database = database;
		this.host = host;
	}




	public void getConnection() throws SQLException {
		 // uid - user id
		    // pwd - password
		    // eng - Sybase database server name
		    // database - sybase database name
		    // host - database host machine ip
		    String dburl = "jdbc:sqlanywhere:uid=CONSU;pwd=DBA;eng=devdb;database=devdb;links=tcpip(host=172.20.20.20)";
		     
		    // Connect to Sybase Database
		    Connection con = DriverManager.getConnection(dburl);
		    Statement statement = con.createStatement();

		    // We use Sybase specific select getdate() query to return date
		    ResultSet rs = statement.executeQuery("SELECT GETDATE()");
		     
		     
		    if (rs.next()) {
		        Date currentDate = rs.getDate(1); // get first column returned
		        System.out.println("Current Date from Sybase is : "+currentDate);
		    }
		    rs.close();
		    statement.close();
		    con.close();
	 }
}
