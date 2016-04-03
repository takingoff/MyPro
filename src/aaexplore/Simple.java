/**
 *	2014年12月15日 上午10:42:02
 *	TangLi
 */
package aaexplore;

/**
 * @author TangLi
 * 2014年12月15日上午10:42:02
 */
public class Simple
{
	/**
	 * this is some "adff"
	 */
	public volatile static String StringFeild = "ss";
	float floatField = 23.1f; 
	
	public void myMethod1()throws Exception
	{
			throw new Exception();
	}
	
	public int myMethod2(int a,int b)
	{
		int c = a + b;
		return c;
	}
	
	public static void main(String[] ar)
	{
		
	}
}
