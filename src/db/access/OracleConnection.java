/**
 *	2014年10月31日 上午9:11:59
 *	TangLi
 */
package db.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author TangLi
 * 2014年10月31日上午9:11:59
 */
public class OracleConnection
{
	
	
	public static void main(String[] ars)throws Exception
	{
		
		try
		{
			
//			10.150.64.105
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			String url="jdbc:oracle:thin:@192.168.118.199:1521:orcl";
			//orcl为数据库的SID
			String user="skysw";
			String password="skysw";
			Connection con= DriverManager.getConnection(url,user,password);
			
			
			Statement s = con.createStatement(); 
			ResultSet r = s.executeQuery("select * from e0301_flt where rownum <10");
			
			while (r.next())
				System.out.println(r.getString(1)); 
			
			
			
			r.close();
			s.close();
			con.close();
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		

		
		
		
		
		
	}
		
	
	
}
