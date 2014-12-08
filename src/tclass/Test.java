/**
 *	2014年12月2日 上午9:30:12
 *	TangLi
 */
package tclass;

/**
 * @author TangLi 2014年12月2日上午9:30:12
 */
class Candy
{
	static
	{
		System.out.println("static Candy");
	}
	
	{System.out.println("un static candy");}
	
}

class Gum
{
	static
	{
		System.out.println("static Gum");
	}
	{System.out.println("un static gum");}
}


public class Test
{
	public static void main(String[] args)throws Exception
	{
		new Candy();
		Class.forName("tclass.Gum").newInstance();
	}
}


