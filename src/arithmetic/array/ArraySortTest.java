/**
 *	2015年10月18日 下午7:56:17
 *	tangli
 */
package arithmetic.array;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import arithmetic.math.Analyze;

/**
 * @author tangli
 * 2015年10月18日下午7:56:17
 */
public class ArraySortTest
{

	public static final int dataLen = 11959;///一百万是内存瓶颈
	
	static int[] backup;
	int[] datas = new int[dataLen];
	
	@BeforeClass
	public static void setUpclass()
	{
		backup = Analyze.getNoRepeateable(dataLen, dataLen*3);
		Analyze.printdata(backup);
	}
	
	@AfterClass
	public static void tearDownclass()
	{
		backup = null;
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.arraycopy(backup,0,datas,0,backup.length);
		
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
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#bubbleSort(int[])}.
	 */
	@Test(timeout=500)
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
	@Test(timeout=100)
	public void testInsertSort()
	{
		ArraySort.insertSort(datas);
	}

	/**
	 * Test method for {@link arithmetic.array.ArraySort#hillSort(int[])}.
	 */
	@Test
	@Ignore
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
	@Test(timeout=10)
	public void testQuickSort()
	{
		ArraySort.quickSort(datas);
	}


}
