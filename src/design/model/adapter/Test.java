/**
 *	2014年12月1日 上午11:21:22
 *	TangLi
 */
package design.model.adapter;

/**
 * @author TangLi
 * 2014年12月1日上午11:21:22
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		IAbility ability1 = new AdapterExtends();
		IAbility ability2 = new AdapterComposite(new Adaptee());
		
		ability1.ablityA();
		ability1.ablityB();
		ability1.ablityC();
		
		ability2.ablityA();
		ability2.ablityB();
		ability2.ablityC();
		
	}

}
