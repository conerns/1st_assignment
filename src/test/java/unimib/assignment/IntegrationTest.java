package unimib.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class IntegrationTest {

	@Test
	public void test() {
		try {
	    	Utente intProva = new Utente(2, "Utente Generico", 0);
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/Assignment1";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "INSERT INTO `assignment1`.`Accessi` (`id_accessi`, `Nome_Utente`, `numero_accessi`) VALUES ('"+intProva.getIdUtente()+"', '"+intProva.getNomeUtente()+"', '"+intProva.getNumeroAccessi()+"');";
			Statement st = conn.createStatement();	        
	        st.executeUpdate(query);
	        String newQuery = "select * from Accessi where id_accessi = "+intProva.getIdUtente()+";";
	        ResultSet rs = st.executeQuery(newQuery);
	        while (rs.next()) {
		        int id = rs.getInt("id_accessi");
	            String Nome_Utente = rs.getString("Nome_Utente");
	            int numero_accessi = rs.getInt("numero_accessi");
	            System.out.format("%s, %s, %s\n", id, Nome_Utente, numero_accessi);
	        }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
