/**
 *	2015年10月18日 下午7:56:17
 *	tangli
 */
package arithmetic.array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import arithmetic.math.Analyze;

/**
 * @author tangli
 * 2015年10月18日下午7:56:17
 */
public class ArraySortTest
{

	public static final int dataLen = 159;///一百万是内存瓶颈
	
	int[] datas;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		datas = Analyze.getNoRepeateable(dataLen, dataLen*3);
		System.out.println("\n\n");
		Analyze.printdata(datas);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		Analyze.printdata(datas);
		Assert.assertTrue(Analyze.checkDataSort(datas));
		datas = null;
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#bubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort()
	{
		ArraySort.bubbleSort(datas);
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#selectSort(int[])}.
	 */
	@Test
	public void testSelectSort()
	{
		ArraySort.selectSort(datas);
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#insertSort(int[])}.
	 */
	@Test
	public void testInsertSort()
	{
		ArraySort.insertSort(datas);
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#hillSort(int[])}.
	 */
	@Test
	public void testHillSort()
	{
		ArraySort.hillSort(datas);
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#mergeRecursiveSort(int[])}.
	 */
	@Test
	public void testMergeRecursiveSort()
	{
		datas = ArraySort.mergeRecursiveSort(datas);
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#quickSort(int[])}.
	 */
	@Test
	public void testQuickSort()
	{
		ArraySort.quickSort(datas);
	}


}
