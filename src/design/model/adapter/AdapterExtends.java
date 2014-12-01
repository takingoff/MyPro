/**
 *	2014年12月1日 上午11:18:51
 *	TangLi
 */
package design.model.adapter;

/**
 * @author TangLi
 * 2014年12月1日上午11:18:51
 */
public class AdapterExtends extends Adaptee implements IAbility
{

	@Override
	public void ablityC()
	{
		System.out.println("ablity come from adapterExtends");
	}

}
