/**
 *	2015年3月10日 下午4:02:15
 *	TangLi
 */
package tclass;

/**
 * @author TangLi
 * 2015年3月10日下午4:02:15
 */
public interface TInterface
{
	
	/////interface 虽然可以定义 public friendly 的各种变量，但他们最终被 置为 static final.
	
	public int a = 3;
	int b = 4 ;
//	private int c = 0 ;
	
	public static int d = 9;
	public static final int e = 10;
	public final  int f = 122;
	
	public void method();
	
	public class Good
	{
		private int a = 1;
		public void showSome()
		{
			System.out.println("asdfasdf---"+a);
		}
		
	}
	public static class StaticGood
	{
		private int a = 1;
		public void showSome()
		{
			System.out.println("asfdasdf---"+a);
		}
		
	}
}
