/**
 *	2014年11月13日 下午2:31:56
 *	TangLi
 */
package design.model.decorator;

/**
 * @author TangLi
 * 2014年11月13日下午2:31:56
 */
public class DecorateC extends Decorator
{

	/**
	 * @param base
	 */
	public DecorateC(Base base)
	{
		super(base);
	}

	@Override
	public void baseFunction()
	{
		System.out.print("decorateC<<");
		super.baseFunction();
		System.out.print("decorateC>>");
	}
	
	

}
