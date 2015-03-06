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
	
	public static final int dataLen = 30;
	
	public static int[] datas= new int[dataLen];
	static{
		Random rd = new Random(System.currentTimeMillis());
		for(int i = 0 ;i <dataLen ;i++)
			datas[i] = rd.nextInt(dataLen);
		
	}
	private static void showDatas()
	{
		for(int i = 0 ;i < dataLen ;i++)
			System.out.print(datas[i]+ ",");
		System.out.println("");
	}
	
	
	/**
	 * 冒泡排序，不停地交换。
	 * @param datas
	 */
	public static void bubbleSort(int[] datas)
	{
		for(int i = 0 ;i < datas.length- 1;i ++)
		{
			for(int j = i+1 ;j < datas.length ; j++ )
				if(datas[i] > datas[j])
					datas[i] = datas[j] + datas[i] - (datas[j] = datas[i]);
		}
	}
	
	/**
	 * 和冒泡排序相比，增加了一个字段做记录，减少了交换次数，但是比较次数依旧。
	 * @param datas
	 * 考虑比较和交换的时间开销。
	 */
	public static void selectSort(int[] datas)
	{
		for(int i = 0 ;i < datas.length- 1;i ++)
		{
			int minIndex  = i;		//自需要增加一个变量即可，不用记录min，min 可以通过 datas[minIndex]得到。
			for(int j = i+1 ;j < datas.length ; j++ )
				if(datas[minIndex] > datas[j])
					 minIndex = j;
			
			datas[i] = datas[minIndex] + datas[i] - (datas[minIndex] = datas[i]);
		}
	}
	
	
	
	/**
	 * 从第二个开始，一直到最后一个。依次抠出值。（做备份）
	 * 抠出选中值，留出空位，左边第一个比起大的向右边移，留出空位，左边第二个比起大的向右边移动，留出空位。。。。。直到数组边界，或者知道找到比其小的位置
	 * 将抠出值填入空位即可。
	 * @param datas
	 * 该算法适合数据不太乱的情况下，
	 */
	public static void insertSort(int[] datas)
	{
		for(int i = 1; i < datas.length ;i++)
		{
			int value = datas[i]; 			//抠出数据
			int j = i-1;					//左边第一个
			while(j>=0 && value<datas[j])	//直到找到一个比其小的，或者到达数组边界则停止
			{
				datas[j+1] = datas[j];		//右移	
				j--;						//继续比较左边
			}
			datas[j+1] = value;				//填补空位
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
//		quickSort(datas);
//		bubbleSort(datas);
//		selectSort(datas);
		insertSort(datas);
		showDatas();
		
	}


}
