/**
 *	2015年9月11日 下午8:28:00
 *	tangli
 */
package reflection.bean;

import java.util.Date;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import thibernate.TStudent;
import aaaautil.Util;

/**
 * @author tangli 2015年9月11日下午8:28:00
 */

public class BeanCopy
{

	public static void main(String[] ar) throws Exception
	{
		final TStudent s = new TStudent();

		s.setAge(11);
		s.setBirth(new Date());
		s.setId("xxx");
		s.setName("asdfasdfasdfa");

		final TStudent s1 = new TStudent();
		final TStudent s2 = new TStudent();
		final TStudent s3 = new TStudent();
		final TStudent s4 = new TStudent();

		final int count = 100000;

		// 极大次数下优势明显，很稳定
		Util.timing(new Util.DoSome()
		{
			@Override
			public void doSome() throws Exception
			{
				BeanCopier copier = BeanCopier.create(s.getClass(), s.getClass(), false);
				// good
				for (int i = 0; i < count; i++)
				{
					copier.copy(s, s4, null);
				}
			}
		});
		
		// 极大次数下优势明显，很稳定
		Util.timing(new Util.DoSome()
		{
			@Override
			public void doSome() throws Exception
			{
				// good
				for (int i = 0; i < count; i++)
				{
					org.springframework.beans.BeanUtils.copyProperties(s,s3);
				}
				
			}
		});

		// 次数越少 优势越明显，速度虽次数变大而变慢
		Util.timing(new Util.DoSome()
		{
			@Override
			public void doSome() throws Exception
			{
				// good
				for (int i = 0; i < count; i++)
					PropertyUtils.copyProperties(s2, s);
			}
		});

		// 次数极小时速度很快。
		Util.timing(new Util.DoSome()
		{
			@Override
			public void doSome() throws Exception
			{
				// too slow
				for (int i = 0; i < count; i++)
					BeanUtils.copyProperties(s1, s);
			}
		});

		
		System.out.println(s1.getName());
		System.out.println(s2.getName());
		System.out.println(s3.getName());
		System.out.println(s4.getName());

	}

}
