package TiCont.utilitarioscontabeis;

import TiCont.utilitarioscontabeis.database.IDatabase;

public interface IContainer {
	public IDatabase getSQLAnywhereDatabaseConnection();
}
