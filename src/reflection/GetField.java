/**
 *	2015年6月8日 下午9:48:04
 *	TangLi
 */
package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author TangLi
 * 2015年6月8日下午9:48:04
 */
public class GetField
{
	
	
	public static void main(String[] args)
	{
		
		System.out.println("先找本类，再找基类，最后找接口");
		
		System.out.println("/////////////////////////////////////getFields  only public but contain base's field");
		Field[] fields = Juno.class.getFields();
		
		for(Field field :fields)
		{
			System.out.println(field.getName());
			
		}
		
		System.out.println("/////////////////////////////////////getDeclaredFields contain all private not contain base's field ");
		Field[] f = Juno.class.getDeclaredFields();
		for(Field field :f)
		{
			System.out.println(field.getName());
			
		}
		System.out.println("/////////////////////////////////////getDeclaredMethods contain private methods not contain construct base's method");
		
		Method[] methods = Juno.class.getDeclaredMethods();
		for(Method method :methods)
		{
			System.out.println(method.getName());
		}
		
		System.out.println("/////////////////////////////////////getMethods only public and base's method");
		
		Method[] mm = Juno.class.getMethods();
		for(Method method :mm)
		{
			System.out.println(method.getName());
		}
		
		
	}
	
	static class Base
	{
		public String baseid;
		public String baseFunction()
		{
			return "";
		}
		
	}
	
	static class Juno extends Base
	{
		public String test;
		public static String staticStr;
		public static final String constantStr = "xxx";
		
		
		private String id;
		private String name ;
		private int age;
		private int level;
		private char sex;
		
		private void privateMethod_______(){};
		public Juno(){privateMethod_______();};
		
		public String getId()
		{
			return id;
		}
		public void setId(String id)
		{
			this.id = id;
		}
		public String getName()
		{
			return name;
		}
		public void setName(String name)
		{
			this.name = name;
		}
		public int getAge()
		{
			return age;
		}
		public void setAge(int age)
		{
			this.age = age;
		}
		public int getLevel()
		{
			return level;
		}
		public void setLevel(int level)
		{
			this.level = level;
		}
		public char getSex()
		{
			return sex;
		}
		public void setSex(char sex)
		{
			this.sex = sex;
		}
	
		
		
	}
	

}
