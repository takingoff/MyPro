/**
 *	2015年3月6日 下午4:17:13
 *	TangLi
 */
package arithmetic.array;


/**
 * @author TangLi
 * 2015年3月6日下午4:17:13
 */
public class StackSimulator<T>
{
	
	private int stackLen;
	private T[] stacks;
	public int current;
	
	/**
	 * @param stackLen
	 * @param stacks
	 * @param current
	 */
	@SuppressWarnings("unchecked")
	public StackSimulator(int stackLen)
	{
		this.stackLen = stackLen;
//		this.stacks = (T[])Array.newInstance(Object.class,stackLen);;
		this.stacks = (T[])new Object[stackLen];
		this.current = -1;
	} 
	
	
	public int push(T data)
	{
		if(current < stackLen -1)
			this.stacks[++current] = data;
		return current;
	}
	
	public T pop()
	{
		return current == -1 ? null : stacks[current--];
	}
	
	
	public static void main(String[] ar)
	{
		StackSimulator<Integer> mystack = new StackSimulator<Integer>(5);
		
		mystack.push(12);
		mystack.push(1431);
		mystack.push(11);
		mystack.push(13);
		mystack.push(113);
		mystack.push(22);
		
		
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		
		
	}
	
	
}
