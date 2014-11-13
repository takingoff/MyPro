/**
 *	2014年11月13日 下午2:52:34
 *	TangLi
 */
package design.model.strategy;

/**
 * @author TangLi
 * 2014年11月13日下午2:52:34
 */
public class Process
{
	
	public static void process(int in,IStrategy s)
	{
		
		System.out.println("使用此策略处理结果是："+s.strategy(in));
		
	}
	
}
