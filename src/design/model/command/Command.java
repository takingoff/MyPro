/**
 *	2014年11月17日 下午4:07:18
 *	TangLi
 */
package design.model.command;

/**
 * @author TangLi
 * 2014年11月17日下午4:07:18
 */
public abstract class Command
{

	protected Executor executor;
	
	public abstract void execute();
	
}
