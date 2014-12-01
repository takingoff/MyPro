/**
 *	2014年12月1日 上午10:43:06
 *	TangLi
 */
package design.model.Proxy.dynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author TangLi 2014年12月1日上午10:43:06
 */
public class CgLibProxy implements MethodInterceptor
{
	private Object target;

	/**
	 * 创建代理对象
	 * 
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target)
	{
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
	{
		System.out.println("事物开始");
		proxy.invokeSuper(obj, args);
		System.out.println("事物结束");
		return null;

	}
}
