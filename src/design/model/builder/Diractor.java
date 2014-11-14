/**
 *	2014年11月14日 下午3:33:12
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi
 * 2014年11月14日下午3:33:12
 */
public class Diractor
{
	
	public void construct(Builder b)
	{
		b.buildCpu();
		b.buildDisplay();
		b.buildMemory();
	}
	
}
