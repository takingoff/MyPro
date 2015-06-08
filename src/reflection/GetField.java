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
		
		Field[] fields = Juno.class.getFields();
		
		for(Field field :fields)
		{
			System.out.println(field.getName());
			
		}
		
		
		
		Method[] methods = Juno.class.getMethods();
		for(Method method :methods)
		{
			if(method.getName().startsWith("set"))
				System.out.println(method.getName().substring(3, 4).toLowerCase()+method.getName().substring(4,method.getName().length()));
			
		}
		
		System.out.println(Juno.class.getCanonicalName());
		
	}
	
	static class Juno
	{
		public String test;
		
		
		private String id;
		private String name ;
		private int age;
		private int level;
		private char sex;
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
