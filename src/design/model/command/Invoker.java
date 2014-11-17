/**
 *	2014年11月17日 下午4:06:43
 *	TangLi
 */
package design.model.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLi
 * 2014年11月17日下午4:06:43
 */
public class Invoker
{
	List<Command> cmds = new ArrayList<Command>();
	
	
	public void addCommand(Command cmd)
	{
		this.cmds.add(cmd);
	}
	
	public void notifyCmd()
	{
		for(Command cmd:cmds)
		{
			cmd.execute();
		}
	}
	
}
