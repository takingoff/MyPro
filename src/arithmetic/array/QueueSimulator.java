/**
 *	2015年3月9日 上午9:07:25
 *	TangLi
 */
package arithmetic.array;

/**
 * @author TangLi
 * 2015年3月9日上午9:07:25
 */
public class QueueSimulator<T>
{

	private T[] datas;
	private int rear;
	private int front;
	
	public int currentNum;
	public int maxLen;

	@SuppressWarnings("unchecked")
	public QueueSimulator(int maxLen)
	{
		this.maxLen = maxLen;
		this.rear = 0 ;
		this.front = 0 ;
		this.currentNum = 0 ;
		this.datas = (T[]) new Object[maxLen];
	}
	
	/**
	 * @param data
	 * @return	返回总数，如果失败返回-1
	 */
	public int insert(T data)
	{
		if(currentNum == maxLen)
			return -1;
		datas[rear] = data;
		rear = (rear +1)%maxLen;
		return ++currentNum;
		
	}
	
	/**
	 * @return 返回队列前端元素，没有元素则返回null
	 */
	public T remove()
	{
		if(currentNum == 0)
			return null;
		
		T result = datas[front];
		front = (front+1)%maxLen;
		currentNum --;
		return result;
		
	}
	
	/**
	 * @param ar
	 */
	public static void main(String[] ar)
	{
		QueueSimulator<Integer> queue = new QueueSimulator<Integer>(5);
		queue.insert(12);
		queue.insert(14);
		queue.insert(15);
		queue.insert(18);
		queue.insert(20);
		queue.insert(20);
		queue.insert(20);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
	}
	
	
	
	
	
}
