/**
 *	2014年11月17日 下午4:07:44
 *	TangLi
 */
package design.model.command;

/**
 * @author TangLi
 * 2014年11月17日下午4:07:44
 */
public class CommandB extends Command
{

	@Override
	public void execute()
	{
		this.executor = Executor.getInstance();
		executor.executeB();
	}
	
}
