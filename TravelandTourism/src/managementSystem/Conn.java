package managementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	Connection c ;
	Statement s;
	Conn() throws Exception
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelAndManagement", "root", "root");
		 s = c.createStatement();
		
	
	}

	public static void main(String[] args) {

	}

}
