/**
 *	2015年10月22日 下午10:04:05
 *	tangli
 */
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import aaaautil.KeyValue;

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
		List<String> result = Collections.unmodifiableList(list);
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
	
	@Test
	public void testValAsArray()
	{
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("1");
		alist.add("2");
		
		Object[] array = alist.toArray();
		array[0] = "xxxx";
		Assert.assertNotEquals(array[0], list.get(0));
	}
	
	@Test
	public void testRefAsArray()
	{
		ArrayList<KeyValue> alist = new ArrayList<KeyValue>();
		alist.add(new KeyValue("key","value"));
		Object[] array =  alist.toArray();
		
		alist.get(0).key = "tangli";
		
		Assert.assertEquals(array[0], alist.get(0));
	}
	

}
