/**
 *	2014年11月17日 下午4:07:32
 *	TangLi
 */
package net;

import design.model.command.Command;
import design.model.command.Executor;

/**
 * @author TangLi
 * 2014年11月17日下午4:07:32
 */
public class CommandA extends Command
{
	@Override
	public void execute()
	{
		this.executor = Executor.getInstance();
		executor.executeA();
	}

}
