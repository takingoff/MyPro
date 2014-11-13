/**
 *	2014年11月13日 下午1:53:35
 *	TangLi
 */
package design.model.Proxy;

/**
 * @author TangLi
 * 2014年11月13日下午1:53:35
 */
public class ProxyLow implements IExposeLow
{

	Reality rel;
	
	/**
	 * @param rel
	 */
	public ProxyLow(Reality rel)
	{
		super();
		this.rel = rel;
	}

	
	@Override
	public void abilityA()
	{
		rel.abilityA();
	}

	@Override
	public void abilityB()
	{
		rel.abilityB();
	}

	
}
