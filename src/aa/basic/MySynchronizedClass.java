package aa.basic;

public class  MySynchronizedClass implements Cloneable
{
	
	static
	{
		System.out.println("this is from MySynchronizedClass's static chunk ");
	}
	
	public int property1 = 1;
	public transient String property2 = "sdaf";
	public volatile String[] name = {"name1","name2","name3"};
	
	public char[] cs = {'a','b','c'};
	
	public MySynchronizedClass(int property1,String property2)
	{
		this.property1 = property1;
		this.property2 = property2;
		System.out.println("enter  contain parameters constructor ");
	}
	
	public MySynchronizedClass()
	{
		System.out.println("enter no parameter constructor ");
	}
	

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	public synchronized void synchronizedFunction(String msg,boolean notifyOrWait)
	{
		System.out.println("enter synchronizedFunction !" + msg);
		
		if(notifyOrWait == false)
		{
			try
			{
				System.out.println("wait " + msg);
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("notify " + msg);
			this.notify();
		}
		
		
		System.out.println("execute the function body"+ msg);
		for(int i = 0 ;i <= 5 ;i ++)
		{
			
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
			}
			System.out.println(i + "come from synchronizedFunction"+ msg);
		}
		
	}
	
	
	public void functionConatinSynchronizedSentences(String msg)
	{
		synchronized(this)
		{
			for(int i = 0 ;i <= 5 ;i ++)
			{
				try
				{
					Thread.sleep(200);
				}
				catch (InterruptedException e)
				{
				}
				System.out.println(i + "come from functionContainSynchronizedSentences" + msg);
			}
		}
		
	}

	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("MySynchronizedClass finalizing ...property1 :" + property1 + "---property2" + property2);
		super.finalize();
	}
	
	
	
	
	
	
}
