/**
 *	2015年3月18日 下午2:22:46
 *	TangLi
 */
package synchronize;

/**
 * @author TangLi
 * 2015年3月18日下午2:22:46
 */
public class TThreadLocal
{

	 ThreadLocal<Integer> local = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue()	///该函数在线程首次调用get时调用，将返回值进行set。如果在线程中事先执行了set该函数将不会调用。
		{
			return 200;
		}
		
	} ;
	
	public TThreadLocal()
	{
		local.set(200);
	}
	public void addLocal()
	{
		local.set(local.get().intValue()+1);
	}
	
	static class Access extends Thread
	{
		TThreadLocal tlocal;
		@Override
		public void run()
		{
			for(int i = 0 ;i < 2; i ++)
				tlocal.addLocal();
			
			System.out.println(tlocal.local.get().intValue());
		}
		public Access(TThreadLocal tlocal)
		{
			super();
			this.tlocal = tlocal;
		}
		
	}

	static public void main(String[] ar)
	{
		TThreadLocal tlocal = new TThreadLocal();
		for(int i = 0 ;i < 3;i ++)
		{
			Thread thread = new Thread(new Access(tlocal));
			thread.start();
		}
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(tlocal.local.get().intValue());
		
		
		
	}
	
}
