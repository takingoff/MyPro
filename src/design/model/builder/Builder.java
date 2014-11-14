/**
 *	2014年11月14日 下午1:24:32
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi 2014年11月14日下午1:24:32
 */
public abstract class Builder
{
	protected Computer computer = new Computer();
	
	public abstract void buildCpu();

	public abstract void buildMemory();

	public abstract void buildDisplay();

	
	public Computer getResult()
	{
		return computer;
	}
}
