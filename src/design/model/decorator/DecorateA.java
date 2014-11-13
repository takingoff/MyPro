/**
 *	2014年11月13日 下午2:30:51
 *	TangLi
 */
package design.model.decorator;

/**
 * @author TangLi
 * 2014年11月13日下午2:30:51
 */
public class DecorateA extends Decorator
{
	/**
	 * @param base
	 */
	public DecorateA(Base base)
	{
		super(base);
	}

	@Override
	public void baseFunction()
	{
		System.out.print("decorateA<<");
		super.baseFunction();
		System.out.print("decorateA>>");
	}

	
	
	
}
