/**
 *	2014年11月13日 下午1:53:20
 *	TangLi
 */
package design.model.Proxy;

/**
 * @author TangLi
 * 2014年11月13日下午1:53:20
 */
public class Reality 
{

	public void abilityA()
	{
		System.out.println("reality's A ability");
	}
	public void abilityB()
	{
		System.out.println("reality's B ability");
	}

	public void abilityC()
	{
		System.out.println("reality's C ability");
	}
	
	/*--------------------------------------不会被代理曝露的能力。--------------------------------------*/
	
	public void abilityD()
	{
		System.out.println("reality's D ability");
	}
	public void abilityE()
	{
		System.out.println("reality's E ability");
		
	}
	
	
	
	
}
