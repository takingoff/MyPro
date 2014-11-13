/**
 *	2014年11月13日 下午2:46:16
 *	TangLi
 */
package design.model.template;

/**
 * @author TangLi
 * 2014年11月13日下午2:46:16
 */
public class Test
{
	public static void main(String[] ar)
	{
		ConcreateA a = new ConcreateA();
		ConcreateB b = new ConcreateB();
		
		a.function();
		System.out.println("\n--------------");
		b.function();
	}
}
