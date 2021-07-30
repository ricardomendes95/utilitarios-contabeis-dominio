package TiCont.utilitarioscontabeis;

import TiCont.utilitarioscontabeis.database.IDatabase;
import TiCont.utilitarioscontabeis.database.SQLAnywhereDatabaseConnection;

public class Container implements IContainer {
	private IDatabase sqlAnywhereDatabaseConnection;

	@Override
	public IDatabase getSQLAnywhereDatabaseConnection() {
		if (sqlAnywhereDatabaseConnection == null) {
			sqlAnywhereDatabaseConnection = new SQLAnywhereDatabaseConnection();
		}
		
		return sqlAnywhereDatabaseConnection;
	}

}
