/**
 *	2015年3月4日 下午3:25:09
 *	TangLi
 */
package arithmetic.array;

/**
 * @author TangLi 2015年3月4日下午3:25:09
 */
public class ArrayFinder
{

	public static int[] datas;// = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 18 };

	static {
		datas = new int[1000];
		for(int i = 0 ;i < 1000 ;i ++)
		{
			datas[i] = i;
		}
	}
	
	private static int binarySearch(int value, int[] datas, int begin, int end)
	{

		if (begin > end)
			return -1;

		int result = (end + begin) / 2;

		if (datas[result] == value)
			return result;
		else if (value > datas[result])
			return binarySearch(value, datas, result + 1, end);
		else
			return binarySearch(value, datas, begin, result - 1);

	}

	public static int binarySearchByRecursive(int value, int[] datas)
	{
		return binarySearch(value, datas, 0, datas.length - 1);
	}

	public static int binarySearchByWhile(int value, int[] datas)
	{
		int begin = 0;
		int end = datas.length - 1;
		int middle ;
		while (true)
		{
			if (begin > end)
				return -1;
			middle  = (begin + end)/ 2;
			
			if (value == datas[middle])
				return middle;
			else if (value > datas[middle])
				begin = middle + 1;
			else
				end = middle - 1;
		}

	}

	public static void main(String[] ar)
	{
		System.out.println("the position is" + binarySearchByRecursive(6, datas));
		System.out.println("the position is" + binarySearchByWhile(6, datas));
		
		
	}
}
