import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcFactory {
	private JdbcFactory() {
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Properties p = new Properties();
			p.load(new FileReader("src/oracle.info"));
			
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(
							p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));
			
		} catch (ClassNotFoundException | IOException e) {
			throw new SQLException(e.getMessage());
		}
		
		return conn;
	}
}
