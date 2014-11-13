/**
 *	2014年11月13日 下午2:40:00
 *	TangLi
 */
package design.model.template;

/**
 * @author TangLi
 * 2014年11月13日下午2:40:00
 */
public class ConcreateA extends Template
{

	@Override
	protected void diffrent1()
	{
		System.out.print("ConcreateADiffrent1");
	}

	@Override
	protected void diffrent2()
	{
		System.out.print("ConcreateADiffrent2");
		
	}

}
