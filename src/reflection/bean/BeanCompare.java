/**
 *	2015年9月11日 下午11:29:55
 *	tangli
 */
package reflection.bean;

import java.lang.reflect.Field;
import java.util.Date;

import thibernate.TStudent;

/**
 * @author tangli 2015年9月11日下午11:29:55
 */
public class BeanCompare
{

	public static boolean compare(Object self, Object other) throws Exception
	{
		Class<? extends Object> clazz = self.getClass();

		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields)
		{
			field.setAccessible(true);
			Object val1 = field.get(self);
			Object val2 = field.get(other);
			if ( (val1==null && val2 == null) ||(val1!=null && val1.equals(val2)))
				continue;
			return false;
		}
		return true;

	}

	public static void main(String[] ars) throws Exception
	{
		TStudent s = new TStudent();
		s.setAge(112);
		s.setBirth(new Date());
		s.setId("xxx");
		s.setName("asdfasdfasdfa");

		TStudent s1 = new TStudent();
		s1.setAge(12);
		s1.setBirth(new Date());
		s1.setId("xxx");
		s1.setName("asdfasdfasdfa");

		System.err.println(compare(s, s1) ? "equal" : "not equal");

	}
}
