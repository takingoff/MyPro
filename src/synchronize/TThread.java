package synchronize;

/**
 * @author tangli
 * 2016年5月21日下午2:19:10
 */
public class TThread
{
	
	
	public static class MyThread extends Thread
	{
		
		public MyThread()
		{
			super();
		}
		
		public MyThread(Runnable r)
		{
			super(r);
		}

		@Override
		public synchronized void start()
		{
			super.start();
		}

		@Override
		public void interrupt()
		{
			super.interrupt();
		}
		
		
//		@Override
//		public void run()
//		{
//			System.err.println("when getState from run function state is RUNNABLE ..."
//					+ "and if override run function runnable interface will no use!");
//		}


		@SuppressWarnings("deprecation")
		@Override
		public void destroy()
		{
			System.err.println("before destroy state is " + "[" + this.getState() +"]");
			super.destroy();
			System.err.println("after destroy state is " + "[" + this.getState() +"]");
		}
		
	}
	
	// new -- runnable -- TERMINATED
	public static void main(String[] ar) throws InterruptedException
	{
		oneSimpleLifeCycle(new Runnable()
		{
			public void run()
			{
				try
				{
					Object lock = new Object();
					synchronized(lock)
					{
						System.err.println("	thread begin sleep(long) wait(long) join(long).......");
						//Thread.sleep(10000000L);
						//Thread.currentThread().join(1000000L);
						lock.wait(10000000L);
					}
				}
				catch (InterruptedException e)
				{
				}
			}
		});
		
		
		oneSimpleLifeCycle(new Runnable()
		{
			public void run()
			{
				try
				{
					Object lock = new Object();
					synchronized(lock)
					{
						System.err.println("	thread begin join(),wait().......");
						//Thread.currentThread().join();
						lock.wait();
					}
				}
				catch (InterruptedException e)
				{
				}
			}
		});
		
		
		
		oneSimpleLifeCycle(new Runnable()
		{
			public void run()
			{
				try
				{
					Object lock = new Object();
					Thread prime = Thread.currentThread();
					new Thread(new Runnable()
					{
						public void run()
						{
							synchronized(lock)
							{
								try
								{
									System.err.println("	some thread enter lock's synchronized block");
									Thread.sleep(1000L);
									System.err.println("	prime thread state is "+"[" + prime.getState() +"]");
									Thread.sleep(3000L);
									System.err.println("	lock's synchronized block code end ");
								}
								catch (InterruptedException e)
								{
									e.printStackTrace();
								}
							}
						}
					}).start();
					
					
					Thread.sleep(500L);
					System.err.println("	prime thread attempt enter lock's synchronized block!");
					synchronized(lock)
					{
						System.err.println("	prime thread enter lock's synchronized block!");
					}
					
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * @throws InterruptedException
	 */
	private static void oneSimpleLifeCycle(Runnable run) throws InterruptedException
	{
		System.err.println("\n ================");
		MyThread myThread = new MyThread(run);
		
		
		System.err.println("***before start prime thread's state is " + "[" + myThread.getState() +"]");
		myThread.start();
		System.err.println("***after start prime thread's state is " + "[" + myThread.getState() +"]");
		
		Thread.sleep(1000L);
		System.err.println("***before interrupt prime thread's  state is " + "[" + myThread.getState() +"]");
		myThread.interrupt();
		
		Thread.sleep(1000L);
		System.err.println("***some time after interrupt, prime thread's state is " +  "[" + myThread.getState() +"]");
		
	}
	
	
}
