/**
 *	2014年12月1日 上午11:19:19
 *	TangLi
 */
package design.model.adapter;

/**
 * @author TangLi
 * 2014年12月1日上午11:19:19
 */
public class AdapterComposite implements IAbility
{
	private Adaptee adaptee;

	/**
	 * @param adaptee
	 */
	public AdapterComposite(Adaptee adaptee)
	{
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void ablityA()
	{
		adaptee.ablityA();
	}

	@Override
	public void ablityB()
	{
		adaptee.ablityB();
	}
	@Override
	public void ablityC()
	{
		System.out.println(" ablity C come from AdapterComposite");
	}
	
}
