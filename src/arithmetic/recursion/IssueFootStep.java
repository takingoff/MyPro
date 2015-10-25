/**
 *	2015年10月23日 下午9:57:41
 *	tangli
 */
package arithmetic.recursion;

import aaaautil.Util;
import aaaautil.Util.DoSome;

/**
 * 一次可以上一个台阶或者两个台阶，问一个n个台阶，一共有多少种上法？
 * <br>分析：最后一次上台阶方法只有两种一步上，两步上。所以假设上到倒数第二阶有x种方法，而上到倒数第三阶共有y种方法，那么上到最后一阶就有x+y种方式。
 * <br> 假设 函数f(n)返回上第n阶的方法数，那么 f(n) = f(n-1)  + f(n-2) ,这就算是递归了。
 * @author tangli
 * 2015年10月23日下午9:57:41
 */
public class IssueFootStep
{
	public static void main(String[] ar) throws Exception
	{
		
		//递归效率很低。
		Util.timing(new DoSome()
		{
			@Override
			public void doSome() throws Exception
			{
				System.out.println(f(44));
			}
		});
		
		//消除递归中的重复调用
		Util.timing(new DoSome()
		{
			@Override
			public void doSome() throws Exception
			{
				System.out.println(f2(44));
			}
		});
		
		// 完全消除递归。。。。
		Util.timing(new DoSome()
		{
			@Override
			public void doSome() throws Exception
			{
				System.out.println(f3(44));
			}
		});
		
		
		// int 4个字节32位，一个符号位31位数，最大。2147483648-1(2的31次方意味着31位全为0，第三十二位为1，显然达不到。) ，
		System.out.println(Integer.MAX_VALUE);
		
	}
	
	/**
	 * 这个递归并不深，但是调用频繁得可怕。。细思极恐！！！多少亿次的调用。
	 * @param n
	 * @return
	 */
	public static int f(int n)
	{
		if(n<=2 )
			return n;
		return f(n-1) + f(n-2);
	}
	
	/**
	 * 消除重复计算
	 * @param n
	 * @return
	 */
	public static int f2(int n)
	{
		fn = new int[n+1];
		return fn(n);
	}

	private static int[] fn ;
	/**
	 * @param n
	 * @return
	 */
	private static int fn(int n)
	{
		if(n<=2 )
			return n;
		
		if(fn[n]==0)
			fn[n] = fn(n-1) + fn(n-2);
		
		return fn[n];
	}
	
	public static int f3(int n)
	{
		if(n<= 2)
			return n;
		
		int first= 1;
		int second = 2;
		int third = 0;
		
		for(int i = 3;i <=n;i++)
		{
			third = first + second;
			first = second;
			second = third;
		}
		
		
		return third;
	}
	
	
	
	
	
	
}
