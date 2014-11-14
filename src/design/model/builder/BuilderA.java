/**
 *	2014年11月14日 下午3:29:08
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi
 * 2014年11月14日下午3:29:08
 */
public class BuilderA extends Builder
{

	@Override
	public void buildCpu()
	{
		this.computer.cpu = "cpuI3";
	}

	@Override
	public void buildMemory()
	{
		this.computer.memory = "memory2G";
		
	}

	@Override
	public void buildDisplay()
	{
		this.computer.display = "display30Inch";
	}

}
