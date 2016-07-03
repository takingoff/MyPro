package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class Test
{

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception
	{
			
		int[] obj = new int[30000000];
		
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		
//		WeakReference<Object> ref = new WeakReference<Object>(obj,queue);
//		SoftReference<Object> ref = new SoftReference<Object>(obj,queue);
		PhantomReference<Object> ref = new PhantomReference<Object>(obj,queue);
		obj = null; // must set null or never recycle!!
		
		System.out.println(ref.get() + " ; queuePoll : " + queue.poll());
		System.gc();
		System.out.println(ref.get() + " ; queuePoll : " + queue.poll());
		
		int[] obj2 = new int[30000000];
		System.out.println(ref.get() + " ; queuePoll : " + queue.poll());
		
		
	}

}
