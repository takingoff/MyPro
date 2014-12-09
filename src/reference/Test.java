package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{

		 testWeakReference();

		testPhantomReference();

	}

	public static void testWeakReference()
	{
		ReferenceQueue<ReferenceClass> queue = new ReferenceQueue<ReferenceClass>();
		List<WeakReference<ReferenceClass>> list = new ArrayList<WeakReference<ReferenceClass>>();

		System.out.println("////////////////添加5个弱引用");
		for (int i = 1; i < 6; i++)
		{
			MyWeakReference reference = new MyWeakReference(new ReferenceClass(i), queue);
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
			MyPhantomReference reference = new MyPhantomReference(new ReferenceClass(i), rq);
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
			data = referent.property;
		}
	}

	static class MyPhantomReference extends PhantomReference<ReferenceClass>
	{
		public int data;

		public MyPhantomReference(ReferenceClass referent, ReferenceQueue<? super ReferenceClass> q)
		{
			super(referent, q);
			data = referent.property;
		}
	}

	static class ReferenceClass
	{

		public int property = 1;

		public ReferenceClass(int property1)
		{
			this.property = property1;
		}

		public ReferenceClass()
		{
		}

		@Override
		protected Object clone() throws CloneNotSupportedException
		{
			return super.clone();
		}

		@Override
		protected void finalize() throws Throwable
		{
			System.out.println("referenceClass finalizing ...property :" + property);
			super.finalize();
		}
	}

}
