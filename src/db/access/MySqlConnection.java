package db.access;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class MySqlConnection
{
	public static void main(String[] arg) throws Exception
	{

		Class.forName("org.gjt.mm.mysql.Driver");
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost/test"
						+ "?user=sa&password=sa&useUnicode=true&characterEncoding=8859_1");

		// Statement s = con.createStatement();
		// ResultSet r = s.executeQuery("select id from city");
		//
		// while (r.next())
		// System.out.println(r.getString(1));

		CallableStatement call = con.prepareCall("{call MYPROCEDURE(?,?)}");

		// 输入参数设置。
		call.setInt(1, 3);

		// 输出参数注册--不是必要的
		call.registerOutParameter(2, Types.NCHAR);

		// 执行存储过程
		call.execute();

		// 获取返回值
		System.out.println(call.getString(2));

		// 获取结果集
		boolean flag = true;
		while (flag)
		{
			System.out
					.println("this is a resultSet from precedure's selct sentence");
			ResultSet rs = call.getResultSet();
			while (rs.next())
			{
				System.out.println(rs.getObject(1));
			}
			rs.close();
			flag = call.getMoreResults();
		}

		con.close();

	}

}
