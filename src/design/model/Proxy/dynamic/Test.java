/**
 *	2014年12月1日 上午10:06:29
 *	TangLi
 */
package design.model.Proxy.dynamic;

import design.model.Proxy.IExposeAll;
import design.model.Proxy.Reality;

/**
 * @author TangLi
 * 2014年12月1日上午10:06:29
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JDKDynamicProxy proxy = new JDKDynamicProxy();
		IExposeAll obj = (IExposeAll) proxy.bind(new Reality());  
	    obj.abilityA();
	    obj.abilityB();
	        
	    
	    CgLibProxy cglibProxy = new CgLibProxy();
	    Reality reality = (Reality) cglibProxy.getInstance(new Reality());
	    reality.abilityA();    
	    reality.abilityB();    
	}

}
