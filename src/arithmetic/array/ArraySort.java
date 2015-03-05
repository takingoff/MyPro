/**
 *	2015年3月5日 下午7:33:22
 *	TangLi
 */
package arithmetic.array;

import java.util.Random;

/**
 * @author TangLi
 * 2015年3月5日下午7:33:22
 */
public class ArraySort
{
	
	public static final int dataLen = 20;
	
	public static int[] datas= new int[dataLen];
	static{
		Random rd = new Random();
		for(int i = 0 ;i <dataLen ;i++)
			datas[i] = rd.nextInt(dataLen);
	}
	private static void showDatas()
	{
		for(int i : datas)
			System.out.print(datas[i]+ ",");
		System.out.println("");
	}
	
	
	
	public static void bubbleSort(int[] datas)
	{
		for(int i = 0 ;i < datas.length- 1;i ++)
		{
			for(int j = i+1 ;j < datas.length ; j++ )
			{
				if(datas[i] > datas[j])
				{
					 datas[i] ^= datas[j];
					 datas[j] ^= datas[i];
					 datas[i] ^= datas[j];
//					datas[i] = datas[j] + datas[i] - (datas[j] = datas[i]);
				}
			}
			
		}
		
	}
	
	public static void aQuickSort(int begin ,int end ,int[] datas)
	{
		if(begin >= end)
			return;
		
		int l = begin;
		int h = end;
		int value = datas[h];
		
		while(l < h)
		{
			while(datas[l] <= value && l<h)
				l++;
			if(l<h)
				datas[h] = datas[l];
			
			while(datas[h] >=  value && l<h)
				h--;
			if(l<h)
				datas[l] = datas[h];
	
		}
		datas[l] = value;
		aQuickSort(begin,l-1,datas);
		aQuickSort(l+1,end,datas);
		
		
	}
	public static void quickSort(int[] datas)
	{
		aQuickSort(0,datas.length-1,datas);
	}
	
	
	
	
	public static void main(String[] ar)
	{
		showDatas();
		quickSort(datas);
//		bubbleSort(datas);
		showDatas();
		
	}


}
