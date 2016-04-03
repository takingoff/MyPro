/**
 *	2015年9月11日 下午9:23:53
 *	tangli
 */
package aaaautil;

/**
 * @author tangli
 * 2015年9月11日下午9:23:53
 */
public class Util
{
	
	public static interface DoSome
	{
		public void doSome()throws Exception;
	}
	
	public static void timing(DoSome ds) throws Exception
	{
		long time = System.currentTimeMillis();
		System.out.println("//**************************begin");
		ds.doSome();
		System.out.println("//**************************end for" + (System.currentTimeMillis()-time)+"ms");
	}
	
	
}
