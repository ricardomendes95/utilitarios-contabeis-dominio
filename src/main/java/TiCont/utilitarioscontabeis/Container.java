package TiCont.utilitarioscontabeis;

import TiCont.utilitarioscontabeis.database.IDatabase;
import TiCont.utilitarioscontabeis.database.SQLAnywhereDatabaseConnection;
import TiCont.utilitarioscontabeis.repositories.ResponsabilityLetterRepository;
import TiCont.utilitarioscontabeis.repositories.interfaces.IResponsabilityLetterRepository;

public class Container implements IContainer {
	private IDatabase sqlAnywhereDatabaseConnection;
	private IResponsabilityLetterRepository responsabilityLetterRepository;

	@Override
	public IDatabase getSQLAnywhereDatabaseConnection() {
		if (sqlAnywhereDatabaseConnection == null) {
			sqlAnywhereDatabaseConnection = new SQLAnywhereDatabaseConnection();
		}
		
		return sqlAnywhereDatabaseConnection;
	}

	@Override
	public IResponsabilityLetterRepository getResponsabilityLetterRepository() {
		if (responsabilityLetterRepository == null) {
			getSQLAnywhereDatabaseConnection();
			
			responsabilityLetterRepository = new ResponsabilityLetterRepository(sqlAnywhereDatabaseConnection.getConnection());
		}
		
		return responsabilityLetterRepository;
	}

}
