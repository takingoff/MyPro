/**
 *	2015年3月18日 下午2:22:46
 *	TangLi
 */
package synchronize;

/**
 * @author TangLi
 * 2015年3月18日下午2:22:46
 */
public class ThreadLocalUtil
{

	private static ThreadLocal<Object> tl = new ThreadLocal<Object>();
	
	
	public static Object get()
	{
		return tl.get();
	}
	public static void set(Object obj)
	{
		tl.set(obj);
	}
	
	static public void main(String[] ar)
	{
		
		for(int i =0 ;i <10;i++)
		{
			createThread(i);
		}
		
	}
	
	/**
	 * @param i
	 */
	private static void createThread(int i)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				ThreadLocalUtil.set(i);
				try
				{
					Thread.sleep(3000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("thread "+ i + " get "+ ThreadLocalUtil.get());
			}
		}).start();
	}
	
}
