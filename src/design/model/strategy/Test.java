/**
 *	2014年11月13日 下午2:51:56
 *	TangLi
 */
package design.model.strategy;

/**
 * @author TangLi
 * 2014年11月13日下午2:51:56
 */
public class Test
{
	
	public static void main(String[] ar)
	{
		Process.process(0, new StrategyA());
		
		Process.process(0, new StrategyB());
	}
}
