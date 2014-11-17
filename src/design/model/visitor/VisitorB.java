/**
 *	2014年11月17日 下午3:59:45
 *	TangLi
 */
package design.model.visitor;

/**
 * @author TangLi
 * 2014年11月17日下午3:59:45
 */
public class VisitorB implements Visitor
{
	@Override
	public void visite(Callee callee)
	{
		System.out.println("visitorB before visite targetMethod");
		callee.targetMethod();
		System.out.println("visitorB after visite targetMethod");
	}


}
