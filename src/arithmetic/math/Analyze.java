/**
 *	2015年3月13日 上午9:04:37
 *	TangLi
 */
package arithmetic.math;

import java.util.HashSet;
import java.util.Random;

/**
 * @author TangLi
 * 2015年3月13日上午9:04:37
 */
public class Analyze
{
	
	
	/**
	 * @param number 生成数量
	 * @param max 上限值、
	 * @return
	 */
	public static int[] getNoRepeateable(int number,int max)
	{
		Random rand = new Random(System.currentTimeMillis());
		HashSet<Integer> set = new HashSet<Integer>();
		
		do{
			set.add(rand.nextInt(max));
		}
		while(set.size()!= number);
		
		int[] array = new int[number];
		Object[] data = set.toArray();
		for(int i = 0 ;i < data.length;i ++)
			array[i] = (int)data[i];
		return  array;
		
	}
	public static void printdata(int[] data)
	{
		for(int i  : data)
			System.out.print(i+",");
		System.out.println("");
	}
	
	public static void checkDataSort(int[] datas)
	{
		for (int i = 1; i < datas.length; i++)
			if (datas[i] < datas[i - 1])
			{
				System.out.println("xxxxxxx数据排列错误xxxxxxxxxxxx");
				return;
			}
		System.out.println("*******数据排列正确***********");
	}
	
	
	public static void main(String[] ar)
	{
		for(Object i : getNoRepeateable(10, 20))
		{
			System.out.println(i);
		}
	}
	
}
