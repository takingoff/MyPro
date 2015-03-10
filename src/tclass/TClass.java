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
	static public String staticField =  "this field is come from candy";
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


public class TClass
{
	public static void main(String[] args)throws Exception
	{
//		System.out.println("before access father's static Field by child class");
//		System.out.println(AppleCandy.staticField);
//		System.out.println("通过子类访问父类的静态成员，是不会导致子类初始化的，这叫‘被动初始化’\n");
		
//		System.out.println("before new a AppleCandy");
//		new AppleCandy();
//		System.out.println("先父后子，先初始化（静态）后实例化\n");
		
		
		System.out.println("before access gum's classs");
		System.out.println(Gum.class.getName());
		System.out.println("访问class并不会导致初始化！\n");

		System.out.println("before initial gum by reflection.");
		Class.forName("tclass.Gum").newInstance();
	}
}




