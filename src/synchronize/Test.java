/**
 *	2014年12月9日 上午9:47:33
 *	TangLi
 */
package synchronize;

/**
 * @author TangLi 2014年12月9日上午9:47:33
 */
public class Test
{
	static public void main(String[] ar)
	{
		System.out.println("非同步块中不能够执行wait，并且只能被同步的对象才能执行wait和notify。否者抛出异常.\n"
				+ "要注意的是synchronized(obj),意味着该对象被锁定，其它所有地方试图调用synchronized(obj)将会被阻塞。而不是局限于当前同步块！！");
		
		deadLock();
		
//		synMenthod();
		
		
	}

	public static void deadLock()
	{
		MySynchronizedClass synClass = new MySynchronizedClass();
		Thread t1 = new Thread(new CheckResourceThread(synClass, true));
		t1.start();
		Thread t2 = new Thread(new CheckResourceThread(synClass, false));
		t2.start();
	}
	
	public static void synMenthod()
	{
		MySynchronizedClass synClass = new MySynchronizedClass();
		Thread t1 = new Thread(new SynMethodThread(synClass));
		t1.start();
		Thread t2 = new Thread(new SynMethodThread(synClass));
		t2.start();
	}

	static class MySynchronizedClass
	{
		boolean isResource1Avaliable = true;
		boolean isResource2Avaliable = true;
		synchronized public void synMethod() throws Exception
		{

			System.out.println("enter synMethod.." + "---" + Thread.currentThread().getId());

			Thread.sleep(5000);

			System.out.println("end synMethod" + "---" + Thread.currentThread().getId());

		}

		public void firstCheckResource1() throws Exception
		{
			if (isResource1Avaliable == false)
			{
				System.out.println("resource1 is locked so wait" + "---" + Thread.currentThread().getId());
				//this.wait();/////非同步块中不能够执行wait。否者抛出异常
			}
			else
			{
				isResource1Avaliable = false;
				System.out.println("resource1 is avaliable so lock resource1" + "---" + Thread.currentThread().getId());
			}
			Thread.sleep(6000);
			synchronized (this)
			{

				if (isResource2Avaliable == false)
				{
					System.out.println("resource2 is locked so wait" + "---" + Thread.currentThread().getId());
					this.wait();
				}
				else
				{

					isResource2Avaliable = false;
					System.out.println("resource2 is avaliable so lock resource1" + "---" + Thread.currentThread().getId());
				}

				System.out.println("two resources avaliable so can do some thing! then releas two resource!" + "---" + Thread.currentThread().getId());
				isResource1Avaliable = true;
				isResource2Avaliable = true;
				this.notify();

			}
		}

		public void firstCheckResource2() throws Exception
		{
			if (isResource2Avaliable == false)
			{
				System.out.println("resource2 is locked so wait" + "---" + Thread.currentThread().getId());
				//this.wait();/////非同步块中不能够执行wait。否者抛出异常
			}
			else
			{
				isResource2Avaliable = false;
				System.out.println("resource2 is avaliable so lock resource2" + "---" + Thread.currentThread().getId());
			}

			Thread.sleep(3000);
			synchronized (this)
			{
				Thread.sleep(10000);
				if (isResource1Avaliable == false)
				{
					System.out.println("resource1 is locked so wait" + "---" + Thread.currentThread().getId());
					this.wait();
				}
				else
				{
					isResource1Avaliable = false;
					System.out.println("resource1 is avaliable so lock resource1" + "---" + Thread.currentThread().getId());
				}

				System.out.println("two resources avaliable so can do some thing! then releas two resource!" + "---" + Thread.currentThread().getId());
				isResource1Avaliable = true;
				isResource2Avaliable = true;
				this.notify();
			}
		}

	}

	static class SynMethodThread implements Runnable
	{
		MySynchronizedClass synClass;

		public SynMethodThread(MySynchronizedClass synClass)
		{
			super();
			this.synClass = synClass;
		}

		@Override
		public void run()
		{
			try
			{
				synClass.synMethod();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	static class CheckResourceThread implements Runnable
	{
		MySynchronizedClass synClass;
		boolean isFirstCheckResource1;

		public CheckResourceThread(MySynchronizedClass synClass, boolean isFirstCheckResource1)
		{
			super();
			this.synClass = synClass;
			this.isFirstCheckResource1 = isFirstCheckResource1;
		}

		@Override
		public void run()
		{
			try
			{
				if (isFirstCheckResource1)
					synClass.firstCheckResource1();
				else
					synClass.firstCheckResource2();

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
