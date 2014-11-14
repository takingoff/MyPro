/**
 *	2014年11月14日 下午3:32:28
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi
 * 2014年11月14日下午3:32:28
 */
public class BuilderB extends Builder
{
	@Override
	public void buildCpu()
	{
		this.computer.cpu = "cpuI7";
	}

	@Override
	public void buildMemory()
	{
		this.computer.memory = "memory4G";
		
	}

	@Override
	public void buildDisplay()
	{
		this.computer.display = "display50Inch";
	}
}
