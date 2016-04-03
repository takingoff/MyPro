package java8;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author TangLi
 * 2015年4月15日下午7:24:21
 */
public class Test
{
	
	public static void main(String[] ar)
	{
		
		
		/*--------------------------------------interface default method--------------------------------------*/
		InterfaceMethod sub = new InterfaceMethod()
		{
		};
		sub.defaultMethod();
		
		
		
		/*--------------------------------------lambda 函数式接口--------------------------------------*/
		/*每一个lambda表达式都对应一个类型，通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，
		 * 每一个该类型的lambda表达式都会被匹配到这个抽象方法。因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。*/
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		Collections.sort(names, ( a, b) -> b.compareTo(a));
		
		
		
		/*--------------------------------------reference method--------------------------------------*/
		FunctionalInterface msger = Test::privateMethod;		//将Test的静态函数引用给FunctionalInterface1,即便是private，只要此时能访问都可以的！！
//		FunctionalInterface msger = String::valueOf;			//将stirng的静态函数引用给FunctionalInterface1,
		String msg = msger.getResult(50);
		System.out.println(msg);   
		
		FunctionalInterface msger1 = "java"::substring;		//将stirng的成员函数subString引用给FunctionalInterface,
		String msg1 = msger1.getResult(2);
		System.out.println(msg1);   
		
		
		FunctionalInterface1 msger2 = String::new;			//将stirng的构造函数引用给FunctionalInterface1,
		String msg2 = msger2.getResult("msg");
		System.out.println(msg2);   
		
		
	}
	
	static interface FunctionalInterface
	{
		public String getResult(int i);
	}
	
	static interface FunctionalInterface1
	{
		public String getResult(String i);
	}
	

	private static String privateMethod(int i)
	{
		return "private";
	}
	public static String publicMethod(int i)
	{
		return null;
	}
	
}
