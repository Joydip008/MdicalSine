package connection1;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	static Connection con=null;
	public static Connection dbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "123");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}