/**
 *	2015年10月18日 下午9:27:35
 *	tangli
 */
package arithmetic.array;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author tangli
 * 2015年10月18日下午9:27:35
 */
@RunWith(Parameterized. class )
public class ArrayFinderTest
{
	
	private int[] data ;
	private int target;
	private int result;
	
	/**
	 * @param data
	 * @param target
	 * @param result
	 */
	public ArrayFinderTest(int[] data, int target, int result)
	{
		super();
		this.data = data;
		this.target = target;
		this.result = result;
	}

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection data()
	{
		return Arrays.asList(new Object[][] {

		{new int[]{1,2,3,4,5,9}, 2, 1 },

		{new int[]{1,2,3,4,5,9}, 5, 4 },

		{new int[]{1,2,3,4,5,9}, 4, 2 },

		});
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link arithmetic.array.ArrayFinder#binarySearchByRecursive(int, int[])}.
	 */
	@Test
	public void testBinarySearchByRecursive()
	{
		Assert.assertEquals(result, ArrayFinder.binarySearchByRecursive(target,data));
	}

	/**
	 * Test method for {@link arithmetic.array.ArrayFinder#binarySearchByWhile(int, int[])}.
	 */
	@Test
	public void testBinarySearchByWhile()
	{
		Assert.assertEquals(result, ArrayFinder.binarySearchByWhile(target,data));
	}

}
