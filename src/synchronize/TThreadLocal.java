/**
 *	2015年3月18日 下午2:22:46
 *	TangLi
 */
package synchronize;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TangLi
 * 2015年3月18日下午2:22:46
 */
public class TThreadLocal
{

	HashMap<String,Integer> map = new HashMap<String, Integer>();
	 ThreadLocal<Map<String,Integer>> local = new ThreadLocal<Map<String,Integer>>(){
		@Override
		protected Map<String,Integer> initialValue()	///该函数在线程首次调用get时调用，将返回值进行set。如果在线程中事先执行了set该函数将不会调用。
		{
			return map;	///返回的是公共引用，相关线程都会共享这个数据。
		}
		
	} ;
	
	public TThreadLocal()
	{
		local.set(map);
		map.put("key", 20);
	}
	public void addLocal()
	{
		local.get().put("key", local.get().get("key")+1);
	}
	
	static class Access extends Thread
	{
		TThreadLocal tlocal;
		@Override
		public void run()
		{
			for(int i = 0 ;i < 2; i ++)
				tlocal.addLocal();
			
			System.out.println(tlocal.local.get().get("key"));
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
		System.out.println(tlocal.local.get().get("key"));
		
		
		
	}
	
}
