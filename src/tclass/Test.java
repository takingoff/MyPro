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
	public Candy()
	{
		System.out.println("candy construction");
	}
	static
	{
		System.out.println("static Candy");
	}
	
	{System.out.println("un static candy");}
	
}

class AppleCandy extends Candy
{
	
	public AppleCandy()
	{
		System.out.println("AppleCandy construction");
	}
	{
		System.out.println("static AppleCandy block");
	}
	
	{System.out.println("un static Applecandy block");}
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
		System.out.println("--------------先父后子，先静态");
		new AppleCandy();
		System.out.println("--------------");
		Class.forName("tclass.Gum").newInstance();
	}
}


