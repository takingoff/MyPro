/**
 *	2015年4月15日 下午7:20:15
 *	TangLi
 */
package java8;

/**
 * @author TangLi
 * 2015年4月15日下午7:20:15
 */
public interface InterfaceMethod
{

		default void defaultMethod()
		{
			System.out.println("this is default method:deafult method can invoke by class which implements interface");
		}
		
}
