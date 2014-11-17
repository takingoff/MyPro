/**
 *	2014年11月17日 下午3:57:42
 *	TangLi
 */
package design.model.visitor;

/**
 * @author TangLi
 * 2014年11月17日下午3:57:42
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Callee callee = new Callee();
		System.out.println("///////////////////////////");
		callee.targetMethod();
		System.out.println("///////////////////////////");
		callee.visiteTargetMethod(new VisitorA());
		System.out.println("///////////////////////////");
		callee.visiteTargetMethod(new VisitorB());
		
	}

}
