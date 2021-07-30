package TiCont.utilitarioscontabeis;

import java.sql.SQLException;

import TiCont.utilitarioscontabeis.database.IDatabase;

public class App 
{	
    public static void main( String[] args )
    {
    	IContainer container = new Container();
    	
    	IDatabase db = container.getSQLAnywhereDatabaseConnection();
    	
    	try {
			db.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("App funcionando!");
    }
}
