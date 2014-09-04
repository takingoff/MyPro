package aa.tangli.explore;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;



public class DateTest
{

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException
	{
		
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());   /// 13 位，十亿秒，万亿毫秒，从1970年到现在的毫秒数。
		System.out.println(System.currentTimeMillis());  /// 可以直接替代 date.getTime()
		
		
		System.out.println(DateFormat.getDateInstance(DateFormat.DEFAULT).format(date));
		
		//y M d h m s  H(24小时) D全是关键字不能够乱写
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format1.format(date));
        
		date = format1.parse("2010-5-1 1:1:1");
		System.out.println(format1.format(date));
		
		
		String s = "olde string";
		changeString(s);
		System.out.println(s);
	}
	
	
	public static void  changeString(String s)
	{
		s = "new Sting !!";
	}

}
