/**
 *	2014年11月17日 上午10:00:42
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi
 * 2014年11月17日上午10:00:42
 */
public class WomanBuilder extends PeopleBuilder
{

	
	public WomanBuilder(String name,int age)
	{
		this.people = new People();
		this.people.age = age;
		this.people.name = name;
	}

	@Override
	public void builderSex()
	{
		this.people.sex = "woman";
	}

}
