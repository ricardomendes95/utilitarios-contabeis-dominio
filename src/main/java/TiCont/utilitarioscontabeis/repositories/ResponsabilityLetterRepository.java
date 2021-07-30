package TiCont.utilitarioscontabeis.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TiCont.utilitarioscontabeis.models.ResponsabilityLetter;
import TiCont.utilitarioscontabeis.repositories.interfaces.IResponsabilityLetterRepository;

public class ResponsabilityLetterRepository implements IResponsabilityLetterRepository {
	private Connection connection;
	
	public ResponsabilityLetterRepository(Connection connection) {
		this.connection = connection;
	}	

	@Override
	public ResponsabilityLetter getResponsabilityLetter() {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM BETHADBA.geempre");
		
		
			ResultSet rs = statement.executeQuery();
	
			while (rs.next()) {				
				String currentDate = rs.getString("nome_emp"); // get first column returned
				System.out.println("Current Date from Sybase is : " + currentDate);
			}
			
			statement.close();
			
			return new ResponsabilityLetter();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}
	
}
