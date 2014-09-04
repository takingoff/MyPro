package arithmetic.sort;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int a[] = {34,34,1,-1,32,45,2,4,1,5,54,67,234,56,123,34,1,32,45};
		
		sortAChunk(a,0,a.length-1);
		
		for(int i = 0 ;i < a.length ;i++ )
			System.out.print(a[i]+"-");
	}
	
	/**
	 * 快排算法
	 * @param a
	 * @param begin 0 base
	 * @param end	0 base
	 */
	public static  void sortAChunk(int a[] , int begin ,int end)
	{
		if(begin >= end)
			return;

		int index = begin;
		int value = a[begin];
		
		int left = begin;  /// left 绝对不能初始化为  begin+1（在只有两个元素的情况下时 left==right 了，不会对其排序。）
		int right = end;
		
		while(right>left)
		{
			while(a[right] >= value && right>left)
			{
				right--;
			}
			if(right > left)
			{
				a[index] = a[right];
				index = right;
			}
			
			while(a[left] <= value && right > left)
			{
				left++;
			}
			if(right > left)
			{
				a[index] = a[left];
				index = left;
			}
		}
		a[index] = value;
		
		
		sortAChunk(a,begin,index-1);
		sortAChunk(a,index+1,end);
	}
	

}
