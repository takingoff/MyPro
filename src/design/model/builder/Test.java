/**
 *	2014年11月17日 上午10:10:48
 *	TangLi
 */
package design.model.builder;

/**
 * @author TangLi
 * 2014年11月17日上午10:10:48
 */
public class Test
{
	
	public static void main(String[] ar)
	{
		
		Diractor diractor = new Diractor();
		PeopleBuilder man = new ManBuilder("小明",21);
		PeopleBuilder woman = new WomanBuilder("小红",21);

		diractor.create(woman);
		diractor.create(man);
		
		
		System.out.println(man.getResult());
		System.out.println(woman.getResult());
	}
	
	
	
}
