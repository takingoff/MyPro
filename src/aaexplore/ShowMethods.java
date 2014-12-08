package aaexplore;

//: ShowMethods.java 
// Using Java 1.1 reflection to show all the  
// methods of a class, even if the methods are  
// defined in the base class. 
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ShowMethods
{

	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		try
		{

			
			Class<?> c = Class.forName(ShowMethods.class.getName());
			Method[] m = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			Field[] fields = c.getFields();
			
			// 显示某个类的全部方法 和变量
			for (int i = 0; i < m.length; i++)
				System.out.println(m[i].toString());
			for (int i = 0; i < ctor.length; i++)
				System.out.println(ctor[i].toString());
			for (int i = 0; i < fields.length; i++)
				System.out.println(fields[i].toString());
			
			
			ShowMethods.class.getAnnotations();
			
			//////////private 修饰的方法和属性是不能够访问的。
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("No such class: " + e);
		}
	}
	
	@SuppressWarnings("unused")
	private int  dddddddddddddddddd(){return 1;}
	public int  aaaaaaaaaaaaaaaaaaaaa(){return 1;}
	public int oooooooooooooooooooooooooooook = 0;
	@SuppressWarnings("unused")
	private int gooooooooooooooooooooood = 0;
}