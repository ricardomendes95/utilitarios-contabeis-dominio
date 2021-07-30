package TiCont.utilitarioscontabeis.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabase {
	public Connection getConnection();
	public boolean hasConnection();
}
