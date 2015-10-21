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
	
	
	public static void main(String[] args)throws Exception
	{
		
		System.err.println("先找本类，再找基类，最后找接口");
		
		System.err.println("/////////////////////////////////////getFields  all public include base's public");
		Field[] fields = Juno.class.getFields();
		
		for(Field field :fields)
		{
			System.out.println(field.getName());
			
		}
		
		System.err.println("/////////////////////////////////////getDeclaredFields contain all self include private  ");
		Field[] f = Juno.class.getDeclaredFields();
		for(Field field :f)
		{
			System.out.println(field.getName());
		}
		
		
		System.err.println("/////////////////////////////////////static value can access by null object");
		System.err.println(Juno.class.getField("staticStr").get(null).toString());
		System.err.println(Juno.class.getField("constantStr").get(null).toString());
		
		
		System.out.println("/////////////////////////////////////getDeclaredMethods all self methods contain construct and private");
		
		Method[] methods = Juno.class.getDeclaredMethods();
		for(Method method :methods)
		{
			System.out.println(method.getName());
		}
		
		System.err.println("/////////////////////////////////////getMethods all public include base's public");
		
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
		public static String staticStr = "static value";
		public static final String constantStr = "static final value";
		
		
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
