/**
 *	2014年11月17日 下午3:59:24
 *	TangLi
 */
package design.model.visitor;

/**
 * @author TangLi
 * 2014年11月17日下午3:59:24
 */
public class Callee
{

	public void targetMethod()
	{
		System.out.println("targetMethod invoked!");
	}
	
	public void visiteTargetMethod(Visitor visitor)
	{
		visitor.visite(this);
	}
	
	
}
