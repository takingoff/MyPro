/**
 *	2014年10月31日 上午9:11:59
 *	TangLi
 */
package db.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
			
			
			PreparedStatement pst = con.prepareStatement("select * from user_tab_columns where table_name=?");
			pst.setString(1, "E0301_FLT");
			ResultSet r = pst.executeQuery();
			while(r.next())
			{
				System.out.print(r.getString(2)+"　");
			}
			
			
			Statement s = con.createStatement(); 
			ResultSet r2 = s.executeQuery("select distinct AIR_LINE from E0301_FLT f where rownum <100 and length(AIR_LINE) >10");
			while (r2.next())
			{
				System.out.println(r2.getString(1)); 
			}
			
			r.close();
			r2.close();
			s.close();
			con.close();
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
		
	
	
}
