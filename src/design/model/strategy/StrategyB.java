/**
 *	2014年11月13日 下午2:59:05
 *	TangLi
 */
package design.model.strategy;

/**
 * @author TangLi
 * 2014年11月13日下午2:59:05
 */
public class StrategyB implements IStrategy
{

	@Override
	public int strategy(int in)
	{
		if(in == 0)
		return 1;
		return 0;
	}

}
