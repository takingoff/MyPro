/**
 *	2014年11月17日 上午10:00:31
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi
 * 2014年11月17日上午10:00:31
 */
public abstract class PeopleBuilder
{
	
	public abstract void builderSex();
	
	
	protected People people;
	public People getResult()
	{
		return people;
	}
}
