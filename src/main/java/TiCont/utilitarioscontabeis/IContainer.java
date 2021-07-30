package TiCont.utilitarioscontabeis;

import TiCont.utilitarioscontabeis.database.IDatabase;
import TiCont.utilitarioscontabeis.repositories.interfaces.IResponsabilityLetterRepository;

public interface IContainer {
	public IDatabase getSQLAnywhereDatabaseConnection();
	public IResponsabilityLetterRepository getResponsabilityLetterRepository();
}
