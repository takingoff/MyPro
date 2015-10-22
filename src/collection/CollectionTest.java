/**
 *	2015年10月22日 下午10:04:05
 *	tangli
 */
package collection;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tangli
 * 2015年10月22日下午10:04:05
 */
public class CollectionTest
{

	private List<String> list ;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testUnmodifiable()
	{
		List<String> result = java.util.Collections.unmodifiableList(list);
		result.add("x");
	}
	
	
	@Test(expected=ConcurrentModificationException.class)
	public void testConcurrentModify()
	{
		for(String s:list)
		{
			System.out.println(s);
			list.remove(0);
		}
	}
	
	@Test
	public void testIterator()
	{
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
			iterator.remove();
		}
	}
	
	

}
