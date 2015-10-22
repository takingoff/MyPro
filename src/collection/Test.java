/**
 *	2014年12月9日 上午11:12:01
 *	TangLi
 */
package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author TangLi
 * 2014年12月9日上午11:12:01
 */
public class Test
{
	public static void main(String[] ar)
	{
		testSet();
		
		System.err.println("一个线程正在迭代时，另外线程改变其结构（删除添加元素）会引起异常！，但是只是访问值，或者修改值是不会异常的哦。");
		testMap(new HashMap<String, String>());
		testMap(new Hashtable<String, String>());
	}
	
	public static void testSet()
	{
		System.out.println("set 中不允许重复对象，怎么判断对象是否重复呢？通过判断其hashCode值是否相同。");
		HashSet<Object> set = new HashSet<Object>();
		set.add(new Object());
		set.add(new Object());

		System.out.println(set.size());
	}
	
	public static void testMap(Map<String,String> map)
	{
		Map<String, String> table = map;

		table.put("s1", "v1");
		table.put("s2", "v2");
		table.put("s3", "v3");

		Thread thread2 = new Thread(new TIterateMap(table));
		thread2.start();

		// pause one seconde let table structure change when the iterator is
		// operating it
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("main thread will change table structure right now ------------");
		table.put("s","s");
		
//		System.out.println("main thread will change table element value right now ------------");
//		table.put("s1","s");
//		table.put("s1","s");
//		table.put("s1","s");
//		table.put("s1","s");
	}


	public static class TIterateMap implements Runnable
	{

		private Map<String, String> ht;

		public TIterateMap(Map<String, String> ht)
		{
			this.ht = ht;
		}

		@Override
		public void run()
		{
			System.out.println("thread  iterating    table ------------");
			while (true)
			{
				for (String s : ht.keySet())
				{
					System.out.println(ht.get(s));

					try
					{
						Thread.sleep(1000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}

			}

		}

	}
}
