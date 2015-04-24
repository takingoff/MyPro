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
	public static final String ffffff = "tttttttttttttttttttt";
	@SuppressWarnings("unused")
	private int age = 110;
	protected long longField = 1000L;
	double doublefield = 12.2;
	boolean bool=true;
	char charField = 'g';
	short shortField = 20;
	float floatField = 23.1f; 
	
	public void myMethod1()throws Exception
	{
			throw new Exception();
	}
	
	@Deprecated
	public void myMethod2()
	{
		System.out.println("ss".split("fs").toString());
		System.out.println(Simple.ffffff);
		System.out.println(((int)'c'));
	}
}
