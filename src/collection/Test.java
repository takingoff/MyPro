/**
 *	2014年12月9日 上午11:12:01
 *	TangLi
 */
package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author TangLi
 * 2014年12月9日上午11:12:01
 */
public class Test
{
	public static void main(String[] ar)
	{
		testSet();
		testHashTable();
		testHashMap();
	}
	
	public static void testSet()
	{
		System.out.println("set 中不允许重复对象，怎么判断对象是否重复呢？通过判断其hashCode值是否相同。");
		HashSet<Object> set = new HashSet<Object>();
		set.add(new Object());
		set.add(new Object());

		System.out.println(set.size());
	}

	
	public static void testHashTable()
	{
		Hashtable<String, String> table = new Hashtable<String, String>();

		table.put("s1", "v1");
		table.put("s2", "v2");
		table.put("s3", "v3");

		TIterateHashTable tit = new TIterateHashTable(table);
		Thread thread2 = new Thread(tit);
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
		table.put("sd", "sd");
	}

	public static void testHashMap()
	{
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("s1", "v1");
		map.put("s2", "v2");
		map.put("s3", "v3");

		TIterateHashMap tim = new TIterateHashMap(map);
		Thread thread1 = new Thread(tim);
		thread1.start();

		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("main thread will change map structure right now ------------");
		map.put("sd", "sd");
	}

	public static class TIterateHashTable implements Runnable
	{

		private Hashtable<String, String> ht;

		public TIterateHashTable(Hashtable<String, String> ht)
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

	public static class TIterateHashMap implements Runnable
	{

		private HashMap<String, String> map;

		public TIterateHashMap(HashMap<String, String> map)
		{
			this.map = map;
		}

		@Override
		public void run()
		{
			System.out.println("thread  iterating    map ------------");
			while (true)
			{
				for (String s : map.keySet())
				{
					System.out.println(map.get(s));

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
