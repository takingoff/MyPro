/**
 *	2014年11月17日 下午4:07:09
 *	TangLi
 */
package design.model.command;

/**
 * @author TangLi
 * 2014年11月17日下午4:07:09
 */
public class Executor
{
	public void executeA()
	{
		System.out.println("A Command execute");
	}
	public void executeB()
	{
		System.out.println("B Command execute");
	}
	
	private Executor()
	{
		
	}
	public static Executor executor;
	public static Executor getInstance()
	{
		if(executor == null)
			executor = new Executor();
		
		return executor;
	}
	
}
