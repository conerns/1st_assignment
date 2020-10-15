package unimib.assignment;
import java.sql.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    try {
        // create our mysql database connection
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/Assignment1";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
        
        // our SQL SELECT query. 
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM Accessi";

        // create the java statement
        Statement st = conn.createStatement();
        
        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);
        
        // iterate through the java resultset
        while (rs.next())
        {
            int id = rs.getInt("id_accessi");
            String Nome_Utente = rs.getString("Nome_Utente");
            int numero_accessi = rs.getInt("numero_accessi");
            
            // print the results
            System.out.format("%s, %s, %s\n", id, Nome_Utente, numero_accessi);
        }
        st.close();
        }
        catch (Exception e)
        {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
        }
      
    }
}
