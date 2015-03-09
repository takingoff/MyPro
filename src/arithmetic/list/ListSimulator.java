/**
 *	2015年3月9日 上午9:45:36
 *	TangLi
 */
package arithmetic.list;

/**
 * @author TangLi
 * 2015年3月9日上午9:45:36
 */
public class ListSimulator<T>
{

	public NodeSimulator<T> first=null;
	public int currentNum=0;
	
	
	private class NodeSimulator<S>
	{
		public S value;
		public NodeSimulator<S> next;
		public NodeSimulator<S> prev;
		public NodeSimulator(S value, NodeSimulator<S> next,NodeSimulator<S> prev)
		{
			super();
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		
		
	}
	
	public int addEnd(T value)
	{
		if(first == null)
			first = new NodeSimulator<T>(value,null,null);
		else
		{
			NodeSimulator<T> index = first;
			while(index.next != null)
				index = index.next;
			index.next = new NodeSimulator<T>(value,null,index);
		}
		
		return ++currentNum ;
	}
	public int addBegin(T value)
	{
		first = new NodeSimulator<T>(value,first,null);
		if(first.next != null)
			first.next.prev = first;
		
		return ++currentNum ;
	}
	
	
	/**
	 * @param pos 从0开始
	 * @return
	 */
	public T remove(int pos)
	{
		if(pos >= currentNum )
			return null;
		
		NodeSimulator<T> index = first;
		for(int i = 0 ;i <pos ;i ++){
			index = index.next;
		}
		T result = index.value;
		if(index.next != null)
			index.next.prev = index.prev;
		if(index.prev != null)
			index.prev.next = index.next;
		else	///说明是第一个，必须要改变first而不是index!!!
			first = index.next;
		currentNum --;
		
		return result;
	}
	
	/**
	 * @param pos 从0开始
	 * @return
	 */
	public int insert(int pos,T value)
	{
		if(pos >= currentNum )
			return addEnd(value);
		
		if(pos <= 0)
			return addBegin(value);
		
		NodeSimulator<T> index = first;
		for(int i = 0 ;i <pos ;i ++){
			index = index.next;
		}
		index.prev.next = new NodeSimulator<T>(value, index, index.prev);
		index.prev = index.prev.next;
		
		return ++currentNum ;
		
	}
	

	public T get(int pos)
	{
		if(pos>= currentNum)
			return null;
		
		NodeSimulator<T> index = first;
		for(int i = 0 ;i <pos ;i ++){
			index = index.next;
		}
		return index.value;
	}
	
	
	public  void showAll()
	{
		NodeSimulator<T> index = first;
		while(index != null)
		{
			System.out.print(index.value+"--");
			index = index.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] ar)
	{
		
		ListSimulator<String> list = new ListSimulator<String>();
		
		list.addEnd("12");
		list.addEnd("13");
		list.addEnd("14");
		list.addEnd("15");
		
		list.addBegin("10");
		list.addBegin("11");
		list.addEnd("19");
		list.addEnd("29");
		
		list.showAll();
		
		System.out.println(list.remove(0));;
		
		list.showAll();
		
		list.insert(3, "good");
		
		list.showAll();
		
		
		
	}
	
}


