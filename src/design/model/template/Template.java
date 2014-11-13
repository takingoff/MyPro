/**
 *	2014年11月13日 下午2:39:22
 *	TangLi
 */
package design.model.template;

/**
 * @author TangLi
 * 2014年11月13日下午2:39:22
 */
public abstract class Template
{
	public  void function()
	{
		System.out.print("重用部分__");
		diffrent1();
		System.out.print("__重用部分__");
		diffrent2();
		System.out.print("__重用部分");
	}
	
	protected abstract void diffrent1();
	protected abstract void diffrent2();
	
}
