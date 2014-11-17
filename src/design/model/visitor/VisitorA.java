/**
 *	2014年11月17日 下午3:59:37
 *	TangLi
 */
package design.model.visitor;

/**
 * @author TangLi
 * 2014年11月17日下午3:59:37
 */
public class VisitorA  implements Visitor
{

	@Override
	public void visite(Callee callee)
	{
		System.out.println("visitorA before visite targetMethod");
		callee.targetMethod();
		System.out.println("visitorA after visite targetMethod");
	}

}
