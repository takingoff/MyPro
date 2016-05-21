package synchronize;

/**
 * @author TangLi 2014年12月9日上午9:47:33
 */
public class TSynchronize
{

	private static Object lock = new Object();

	static public void main(String[] ar) throws InterruptedException
	{
		// "非同步块中不能够执行wait，并且只能被同步的对象才能执行wait和notify。否者抛出异常.\n" +
		// "要注意的是synchronized(obj),意味着该对象被锁定，其它所有地方试图调用synchronized(obj)将会被阻塞。而不是局限于当前同步块！！");

		synchronized (lock)
		{
			try
			{
				System.out.println("主线程wait1秒--" + System.currentTimeMillis());
				lock.wait(1000L);
				System.out.println("主线程wait1秒之后自动醒来--" + System.currentTimeMillis());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		}

		System.out.println("===================");
		new Thread(new Runnable()
		{
			public void run()
			{
				System.out.println("子线程启动");
				try
				{
					Thread.sleep(2000L);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("子线程使用在同步块中使用notify唤醒主线程");
				synchronized (lock)
				{
					lock.notify();
				}
			}
		}).start();

		synchronized (lock)
		{
			try
			{
				System.out.println("主线程永久wait--" + System.currentTimeMillis());
				lock.wait();
				System.out.println("永久wait的主线程被唤醒--" + System.currentTimeMillis());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("===================");
		Thread mainThread = Thread.currentThread();
		new Thread(new Runnable()
		{
			public void run()
			{
				System.out.println("子线程启动");
				try
				{
					Thread.sleep(2000L);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("子线程用interrupt打断主线程");
				mainThread.interrupt();
			}
		}).start();

		synchronized (lock)
		{
			System.out.println("主线程永久wait/sleep/join--" + System.currentTimeMillis());
			try
			{
				//lock.wait();
				//Thread.sleep(500000L);
				Thread.currentThread().join(); // 等待自己执行完毕，也就是永远等待！
			}
			catch (InterruptedException e)
			{
				System.out.println("永久阻塞的主线程抛出InterruptedException异常--" + System.currentTimeMillis());
			}
		}
		

	}

}
