/**
 *	2014年11月13日 下午2:58:28
 *	TangLi
 */
package design.model.strategy;

/**
 * @author TangLi
 * 2014年11月13日下午2:58:28
 */
public class StrategyA implements IStrategy
{

	@Override
	public int strategy(int in)
	{
		if(in == 0)
		return 0;
		return 1;
	}

}
