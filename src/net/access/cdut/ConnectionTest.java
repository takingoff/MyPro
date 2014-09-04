package net.access.cdut;


public class ConnectionTest
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		

		
//		AccessFunc.analyseFileToDownloadImage("E:/mydocument/myKuaiPan/myTemp/imageDown/2013pas.txt","C:/Users/LiTang/Desktop/image");
		
		
//		AccessFunc.loopAccessCdut("201008050318",6,3);
		
		
//		
//		if(AccessFunc.accessCdutStatic("201011020216","325626"))
//			System.out.println("yes");
//		else 
//			System.out.println("no");
		
		AccessFunc.accessServletAndJsp("http://user.qzone.qq.com/431997751","utf-8");
	}
	
	
	public static void multiThreadAccess()
	{
		for(int j = 0 ;j <= 0; j++)
		{
			
			for(int k = 5;k <= 5 ;k ++)
			{
				
				for(int i = 1;i <=6; i ++)
				{
					
					Thread thread = new Thread(new ScanClassOfAll("201"+j,8,k,i,35,"c:/Users/LiTang/Desktop/商Image",false));
					thread.start();  
				}
			}
			
		}
	}
	
	
}
