package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import synchronize.Child;
import synchronize.Father;
import synchronize.GrandFather;

public class Test
{

	/**
	 * @param args
	 * @throws CloneNotSupportedException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws Exception
	{

		 testClass();
//		testWeakReference();

		// testPhantomReference();

		// testMathRound();

		// testSet();

		// testClone();

		// testSynchronizedWaitAndNotify();

		// testHashMap();

		// testHashTable();

	}

	public static void testClass() throws Exception
	{
		// RererenceClass ms = new RererenceClass();
		Class.forName("reference.RererenceClass", true, Test.class.getClassLoader()).newInstance();
//		Class.forName("reference.RererenceClass", true, String.class.getClassLoader()).newInstance();

	}

	public static void testWeakReference()
	{
		ReferenceQueue<ReferenceClass> queue = new ReferenceQueue<ReferenceClass>();
		List<WeakReference<ReferenceClass>> list = new ArrayList<WeakReference<ReferenceClass>>();

		System.out.println("////////////////添加5个弱引用");
		for (int i = 1; i < 6; i++)
		{
			MyWeakReference reference = new MyWeakReference(new ReferenceClass(i, "str" + i), queue);
			list.add(reference);
		}

		System.out.println("////////////////ReferenceQueue中查看是否有引用被回收");
		Reference<? extends ReferenceClass> ref = null;
		while ((ref = queue.poll()) != null)
		{
			MyWeakReference r = (MyWeakReference) ref;
			System.out.println(" In queue and the referent is still avaliable --data is :" + r.data);
		}

		// 提醒依次垃圾回收器，但是不会保证立刻执行！等空闲了系统才会执行回收。回收之前先执行finalize函数，之后
		// Reference的get方法返回null,
		// 但是并不是说Reference就被加入到Queue，这是不能确定的，但是基本上申明一个大空间的数组后，马上就可以看到Reference被加入到queue中。

		System.out.println("///////////////执行一次gc并且声明一个8388608（8M）字节的数组");
		System.gc();
		@SuppressWarnings("unused")
		byte[] b = new byte[8 * 1024 * 1024];

		System.out.println("////////////////再次在ReferenceQueue中查看是否有引用被回收");
		while ((ref = queue.poll()) != null)
		{
			MyWeakReference r = (MyWeakReference) ref;
			System.out.println(" In queue and the referent is still avaliable --data is :" + r.data);
		}

	}

	public static void testPhantomReference()
	{
		ReferenceQueue<ReferenceClass> rq = new ReferenceQueue<ReferenceClass>();

		List<PhantomReference<ReferenceClass>> list = new ArrayList<PhantomReference<ReferenceClass>>();
		for (int i = 1; i < 6; i++)
		{
			MyPhantomReference reference = new MyPhantomReference(new ReferenceClass(i, "str" + i), rq);
			list.add(reference);
		}

		// 提醒依次垃圾回收器，但是不会保证立刻执行！等空闲了系统才会执行回收。回收之前先执行finalize函数，之后
		// Reference的get方法返回null,
		// 但是不管怎样 phantomReference 不会被加入到 queue中。除非对象被完全释放掉！
		System.gc();

		// byte[] b = new byte[8 * 1024 * 1024];
		// byte[] b1 = new byte[8 * 1024 * 1024];
		// byte[] b2 = new byte[8 * 1024 * 1024];
		// byte[] b3 = new byte[8 * 1024 * 1024];
		// byte[] b4 = new byte[8 * 1024 * 1024];
		// System.out.println(b.length);

		Reference<? extends ReferenceClass> ref = null;

		while (true)
		{
			System.gc();
			while ((ref = rq.poll()) != null)
			{
				MyPhantomReference r = (MyPhantomReference) ref;
				System.out.println(" In queue and the referent is : " + ref.get() + "--data is :" + r.data);
			}
		}
	}

	static class MyWeakReference extends WeakReference<ReferenceClass>
	{

		public int data;

		public MyWeakReference(ReferenceClass referent, ReferenceQueue<? super ReferenceClass> q)
		{
			super(referent, q);
			data = referent.property1;
		}
	}

	static class MyPhantomReference extends PhantomReference<ReferenceClass>
	{

		public int data;

		public MyPhantomReference(ReferenceClass referent, ReferenceQueue<? super ReferenceClass> q)
		{
			super(referent, q);
			data = referent.property1;
		}
	}

	public static void testMathRound()
	{
		System.out.println(Math.round(11.4));
		System.out.println(Math.round(-11.4));

		System.out.println(Math.round(11.5));
		System.out.println(Math.round(-11.5));

		System.out.println(Math.round(11.6));
		System.out.println(Math.round(-11.6));
	}

	public static void testSet()
	{
		System.out.println("set 中不允许重复对象，怎么判断对象是否重复呢？通过判断其hashCode值是否相同。");
		HashSet<ReferenceClass> set = new HashSet<ReferenceClass>();
		set.add(new ReferenceClass());
		set.add(new ReferenceClass());

		System.out.println(set.size());
	}

	public static void testClone() throws CloneNotSupportedException
	{
		ReferenceClass msc = new ReferenceClass(7, "ss");

		ReferenceClass mscClone = (ReferenceClass) msc.clone();

		System.out.println("int 值类型不需要深拷贝。----------------------------------");
		System.out.println(mscClone.property1);
		msc.property1 = 2;
		System.out.println(mscClone.property1);

		System.out.println("String[] 需要深拷贝----------------------------------");
		System.out.println(mscClone.name[1]);
		msc.name[1] = "new Name ";
		System.out.println(mscClone.name[1]);

		System.out.println("String 可以不用深拷贝，浅拷贝就行了，----------------------------------");
		System.out.println(mscClone.property2);
		msc.property2 = "new String";
		System.out.println(mscClone.property2);

		System.out.println("char[] 数组是引用类型需要深拷贝----------------------------------");
		System.out.println(mscClone.cs[1]);
		msc.cs[1] = 'n';
		System.out.println(mscClone.cs[1]);
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

	public static class TSynchronizeA implements Runnable
	{

		private ReferenceClass msc;

		public TSynchronizeA(ReferenceClass msc)
		{
			this.msc = msc;
		}

		@Override
		public void run()
		{
			msc.synchronizedFunction("----A", false);
			// msc.functionConatinSynchronizedSentences("----A");
		}

	}

	public static class TSynchronizeB implements Runnable
	{

		private ReferenceClass msc;

		public TSynchronizeB(ReferenceClass msc)
		{
			this.msc = msc;
		}

		@Override
		public void run()
		{

			msc.synchronizedFunction("----B", true);
			// msc.functionConatinSynchronizedSentences("----B");
		}

	}

}
