/**
 *	2015年7月27日 下午8:25:27
 *	TangLi
 */
package extend;

/**
 * @author TangLi
 * 2015年7月27日下午8:25:27
 */
public class ImplObj extends BaseObj
{

	@Override
	public void dynamic()
	{
		Class<? extends ImplObj> cla = this.getClass();
		System.out.println(cla.getName());
		
	}

	
	
	public static void main(String[] ar)
	{
		ImplObj o = new ImplObj();
		o.trunk();
		o.pubFunction();
	}
	
}
