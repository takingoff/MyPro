/**
 *	2014年11月13日 下午2:33:59
 *	TangLi
 */
package design.model.decorator;

/**
 * @author TangLi
 * 2014年11月13日下午2:33:59
 */
public class Test
{
	
	public static void main(String[] ars)
	{
		
		Base b = new Base();
		
		DecorateA da = new DecorateA(b);
		DecorateB db = new DecorateB(da);
		DecorateC dc = new DecorateC(db);
		
		dc.baseFunction();
		
	}
	
}
