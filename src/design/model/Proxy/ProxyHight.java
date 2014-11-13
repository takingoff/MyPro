/**
 *	2014年11月13日 下午1:53:35
 *	TangLi
 */
package design.model.Proxy;

/**
 * @author TangLi
 * 2014年11月13日下午1:53:35
 */
public class ProxyHight implements IExposeHight
{

	Reality rel;
	
	/**
	 * @param rel
	 */
	public ProxyHight(Reality rel)
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

	@Override
	public void abilityC()
	{
		rel.abilityC();
	}


	@Override
	public void abilityD()
	{
		rel.abilityD();
	}
	
}
