/**
 * 
 */
package aaexplore;


/**
 * @author christopher
 * 
 */
public class MyThread extends Thread
{

	@Override
	// public void run()
	// {
	// super.run();
	// System.out.print("the thread begin!!");
	// for(int i = 0 ;i<10;i++)
	// {
	// System.out.print(i);
	// try
	// {
	// sleep(100);
	// }
	// catch (InterruptedException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// System.out.println("the thread end!!");
	// }
	public void run()
	{
		for (int i = 7; i <= 500; i++)
		{
			if ((i % 7 == 0) && (i % 3 == 0))
			{
				System.out.println(i);
			}

		}
	}

	/**
	 * @param args
	 */

	public static class test
	{
		public static void main(String[] args)
		{
			// MyThread th = new MyThread();
			// MyThread th2 = new MyThread();
			// MyThread th3 = new MyThread();
			// th.start();
			// th2.start();
			// th3.start();

			Thread t = new Thread(new Runnable()
			{
				int[] data = { 2, 9, 18, 51, 33, 37, 10, 30 };

				@Override
				public void run()
				{
					System.out.println("the thread is begin!!");
					int min = data[0];
					int max = data[0];
					for (int a : data)
					{
						if (min > a)
							min = a;
						if (max < a)
							max = a;
					}
					System.out.println("max is : " + max);
					System.out.println("min is : " + min);
				}
			});
			 t.start();

			// Scanner scan = new Scanner(System.in);
			// int[] data = new int[5];
			// for(int i = 0;i< 5;i++)
			// data[i] = scan.nextInt();
			//
			MyRun r1 = new MyRun();
			r1.flag = 0;
			MyRun r2 = new MyRun();
			r2.flag = 1;
			
			 Thread t1 = new Thread(r1);
			 Thread t2 = new Thread(r2);
			 
			 t1.start();
			 t2.start();
		}

	}

}

class MyRun implements Runnable
{

	int[] data = null;
	static Object o1 = new Object();
	static Object o2 = new Object();

	public int flag = 0;

	/* (non-Javadoc)
	 */
	@Override
	synchronized public void run()
	{
//		synchronized (obj)
//		{
//			int temp = 0;
//			int len = data.length;
//			for(int i = 0; i<len/2;i++)
//			{
//				temp = data[i];
//				data[i] = data[len-1 -i];
//				data[len -1 -i] = temp;
//				
//			}
//			for(int d:data)
//			{
//				System.out.println(d);
//			}
//		}
		if(flag == 1)
		{
			synchronized (o1)
			{
				try
				{
					Thread.sleep(550);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (o2)
				{
					System.out.println("1");
				}
			}
		}
		if(flag == 0)
		{
			synchronized (o2)
			{
				try
				{
					Thread.sleep(550);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (o1)
				{
					System.out.println("0");
				}
			}
		}
		
		
	}

	MyRun(int[] data)
	{
		this.data = data;
	}

	public MyRun()
	{
		// TODO Auto-generated constructor stub
	}

}