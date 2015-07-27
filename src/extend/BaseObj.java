/**
 *	2015年7月27日 下午8:23:45
 *	TangLi
 */
package extend;

/**
 * @author TangLi
 * 2015年7月27日下午8:23:45
 */
public abstract class BaseObj
{
	
	public abstract void dynamic(); 
	public void trunk()
	{
		System.out.println("-----------begin dynamic");
		dynamic();
		System.out.println("-----------end dynamic");
	}
	
	public void pubFunction()
	{
		System.out.println("-----------begin pubFunction");
		Class<? extends BaseObj> class1 = this.getClass();
		System.out.println(class1.getName());							// it will be implObj's name !!!
		System.out.println("-----------end pubFunction");
	}
	
}
