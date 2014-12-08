/**
 *	2014年12月5日 下午3:21:18
 *	TangLi
 */
package future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author TangLi
 * 2014年12月5日下午3:21:18
 */
public class Test
{
	public static void main(String[] ars) throws Exception
	{
		FutureTask<String> future = new FutureTask<String>(new Callable<String>()
		{
			@Override
			public String call() throws Exception
			{
				Thread.sleep(4000);
				return "this is come from callable";
			}
			
		});
		
		Thread t = new Thread(future);
		t.start();
		
		System.out.println(future.get());
		
	}
}
