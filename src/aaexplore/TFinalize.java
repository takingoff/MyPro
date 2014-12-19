/**
 *	2014年12月19日 下午4:11:04
 *	TangLi
 */
package aaexplore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLi
 * 2014年12月19日下午4:11:04
 */
public class TFinalize
{
	
	static List<FClass> fcs = new ArrayList<FClass>();
	static int count  = 0 ;
	
	public static void main(String[] ar)
	{
		for(int i = 0;i<10;i++)
		{
			new FClass();
		}
		
		
		while(true)
		{
			System.gc();
		}
		
	}
	
	static class FClass 
	{

		@Override
		protected void finalize() throws Throwable
		{
			System.out.println("finalize execution count :"+(++count));
			fcs.add(this);///即便对象在此重生，finalize也不会再被gc执行！
			super.finalize();
			
		}
		
	}
	
}	
