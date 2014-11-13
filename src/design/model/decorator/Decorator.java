/**
 *	2014年11月13日 下午2:28:54
 *	TangLi
 */
package design.model.decorator;

/**
 * @author TangLi
 * 2014年11月13日下午2:28:54
 */
public class Decorator extends Base
{
	private Base base;

	/**
	 * @param base
	 */
	public Decorator(Base base)
	{
		super();
		this.base = base;
	}

	
	@Override
	public void baseFunction()
	{
		base.baseFunction();
	}
	

	
}
