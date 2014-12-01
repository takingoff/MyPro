/**
 *	2014年12月1日 上午10:01:10
 *	TangLi
 */
package design.model.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author TangLi 2014年12月1日上午10:01:10
 */
public class JDKDynamicProxy implements InvocationHandler
{

	private Object target;

	public Object bind(Object target)
	{
		this.target = target;
		//获取代理对象的时候 就把 invocationHandler对象通过this传给了代理对象，这样invoke函数将会被回调。
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this); // 要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Object result = null;
		System.out.println("begin invoke !");
		result = method.invoke(target, args);
		System.out.println("end invoke !");
		return result;
	}

}
