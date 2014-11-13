/**
 *	2014年11月13日 下午2:40:09
 *	TangLi
 */
package design.model.template;

/**
 * @author TangLi
 * 2014年11月13日下午2:40:09
 */
public class ConcreateB extends Template
{
	@Override
	protected void diffrent1()
	{
		System.out.print("ConcreateBDiffrent1");
	}

	@Override
	protected void diffrent2()
	{
		System.out.print("ConcreateBDiffrent2");
		
	}
}
