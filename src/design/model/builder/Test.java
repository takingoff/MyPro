/**
 *	2014年11月14日 下午3:34:23
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi
 * 2014年11月14日下午3:34:23
 */
public class Test
{
	
	public static void main(String[] ar)
	{
		Diractor d = new Diractor();
		Builder b1 = new BuilderA();
		Builder b2 = new BuilderB();
		d.construct(b1);
		d.construct(b2);
		
		System.out.println(b1.getResult());
		System.out.println(b2.getResult());
		
	}

	
	
}
