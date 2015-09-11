/**
 *	2015年9月11日 下午10:08:38
 *	tangli
 */
package aaexplore;

/**
 * @author tangli
 * 2015年9月11日下午10:08:38
 */
public class TStack
{

	public static void main(String[] ars)
	{
		
		test();
		
	}
	public static void test()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		(new Throwable()).printStackTrace();
		stackTrace[0].getMethodName();
	}
}
