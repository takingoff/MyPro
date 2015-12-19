package aaexplore;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class TDate
{

	/**
	 * @param args
	 * @throws ParseException
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws Exception
	{

		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime()); // / 13 位，十亿秒，万亿毫秒，从1970年到现在的毫秒数。
		System.out.println(System.currentTimeMillis()); // / 可以直接替代
														// date.getTime()

		System.out.println(DateFormat.getDateInstance(DateFormat.DEFAULT).format(date));

		// y M d h m s H(24小时) D全是关键字不能够乱写
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format1.format(date));

		date = format1.parse("2010-5-1 1:1:1");
		System.out.println(format1.format(date));

		// Get standard date and time
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime();

		
		System.err.println("..............");
		System.out.println("The Java Date is:" + javaDate.toString());
		
		// Get and display SQL DATE by www.yiibai.com
		java.sql.Date sqlDate = new java.sql.Date(javaTime);
		System.out.println("The SQL DATE is: " + sqlDate.toString());

		// Get and display SQL TIME
		java.sql.Time sqlTime = new java.sql.Time(javaTime);
		System.out.println("The SQL TIME is: " + sqlTime.toString());
		// Get and display SQL TIMESTAMP
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
		System.out.println("The SQL TIMESTAMP is: " + sqlTimestamp.toString());
	}

}
