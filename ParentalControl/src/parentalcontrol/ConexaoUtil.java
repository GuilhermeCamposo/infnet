package parentalcontrol;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoUtil {
	
	public static Connection getConexao(){
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/javainfnet?user=postgres&password=postgres");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
}
