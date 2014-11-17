/**
 *	2014年11月17日 下午4:06:25
 *	TangLi
 */
package design.model.command;

import net.CommandA;

/**
 * @author TangLi
 * 2014年11月17日下午4:06:25
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		Invoker invoker = new Invoker();
		
		invoker.addCommand(new CommandA());
		invoker.addCommand(new CommandB());
		invoker.addCommand(new CommandB());
		invoker.addCommand(new CommandA());
		invoker.addCommand(new CommandB());
		
		System.out.println("/////////// invoker notifyCmd");
		
		invoker.notifyCmd();
	}

}
