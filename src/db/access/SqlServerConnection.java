package db.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SqlServerConnection
{
	public static void main(String[] arg) throws Exception
	{

		Connection con = null;
		Class.forName("net.sourceforge.jtds.jdbc.Driver"); 
		con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/SqlServerTangLi;user=sa;password=sa");
		
		Statement s = con.createStatement(); 
		ResultSet r = s.executeQuery("select id from person");
		
		while (r.next())
			System.out.println(r.getString(1)); 
		
		con.close();
	}

}
