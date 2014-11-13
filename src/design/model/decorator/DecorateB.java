/**
 *	2014年11月13日 下午2:31:42
 *	TangLi
 */
package design.model.decorator;

/**
 * @author TangLi
 * 2014年11月13日下午2:31:42
 */
public class DecorateB extends Decorator
{
	/**
	 * @param base
	 */
	public DecorateB(Base base)
	{
		super(base);
	}

	@Override
	public void baseFunction()
	{
		
		System.out.print("decorateB<<");
		super.baseFunction();
		System.out.print("decorateB>>");
	}

	
	
}
