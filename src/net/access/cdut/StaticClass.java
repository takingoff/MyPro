package net.access.cdut;

import org.apache.log4j.Logger;

public class StaticClass
{
	/**
	 * 如果返回的数据大于 successLineNum 说明密码测试成功。
	 */
	public static int successLineNum = 5;
	
	public static final String ACCESSURI = "http://202.115.133.161/login.php";
	
	public static  String intToFullString(int i,int digits)
	{
		
		String result = String.valueOf(i);
		
		int zeroNum = digits - result.length();
		if(zeroNum >0 )
		{
			for(int j = 1; j <= zeroNum ; j++)
			{
				result = "0" + result;
			}
		}
		
		return  result;
		
	}
	
	public static boolean find = false;
	
	public static final Logger logger = Logger.getRootLogger();
	
	public static void main(String[] as)
	{
		for(int j = 0; j <10 ;j ++)
		{
			
			Long time = System.currentTimeMillis();
			
//			for(int i = 0 ;i <10; i++)
//				AccessFunc.accessCdutStatic("2010050s70204","super_tanghao");
			
//		AccessCdut ac = new AccessCdut(ACCESSURI);
//		for(int i = 0 ;i <10 ;i ++)
//			ac.accessOnece("201005070204","super_tanghao");
			
			
			time = System.currentTimeMillis() - time;
			logger.info(time);
			
		}
		
	}
	
	
	
}
