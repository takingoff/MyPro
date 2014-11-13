/**
 *	2014年11月13日 下午1:56:47
 *	TangLi
 */
package design.model.Proxy;

/**
 * @author TangLi
 * 2014年11月13日下午1:56:47
 */
public class Test
{
	public static void main(String[] ars)
	{
		Reality rel = new Reality();
		
		System.out.println("proxyLow-------------------");
		IExposeLow proxy = new ProxyLow(rel);
		proxy.abilityA();
		proxy.abilityB();
		
		System.out.println("proxyHight-------------------");
		IExposeHight proxy2 = new ProxyHight(rel);
		proxy2.abilityA();
		proxy2.abilityB();
		proxy2.abilityC();
		proxy2.abilityD();
	}
}
