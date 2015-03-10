/**
 *	2015年3月10日 下午2:17:58
 *	TangLi
 */
package arithmetic.tree;

/**
 * @author TangLi
 * 2015年3月10日下午2:17:58
 */
public class BinaryTree
{
	public static interface T 
	{
		
		/**
		 * @param t
		 * @return 等于返回0 小于返回-1，大于返回1
		 */
		public int compareTo(T t);
		
		public Object getValue();
	}
	
	public static class Ttest implements T
	{
		private int weight ;
		
		public Ttest(int weight)
		{
			super();
			this.weight = weight;
		}

		@Override
		public int compareTo(T t)
		{
			Ttest target = (Ttest)t;
			if(target.weight > this.weight)
				return -1;
			else if(target.weight < this.weight)
				return 1;
			else
				return 0;
		}

		@Override
		public Object getValue()
		{
			return this.weight;
		}
	}
	
	public static class Node
	{
		public T obj;
		public Node right;
		public Node left;
		public Node(T value, Node right, Node left)
		{
			super();
			this.obj = value;
			this.right = right;
			this.left = left;
		}
	}
	
	
	public Node root; 
	
	public static interface TraverseHandler
	{
		public void doSomething(Node parent ,Node index);
	}
	public void traverse(Node parent, Node index, int type, TraverseHandler handler)
	{
		if(index == null )
			return;
		if (type == 1)
		{
			handler.doSomething(parent,index);
			traverse(index, index.left, type, handler);
			traverse(index, index.right, type, handler);
		}
		else if (type == 2)
		{
			traverse(index, index.left, type, handler);
			handler.doSomething(parent,index);
			traverse(index, index.right, type, handler);
		}
		else
		{
			traverse(index, index.left, type, handler);
			traverse(index, index.right, type, handler);
			handler.doSomething(parent,index);
		}
	
	}
	
	
	public void del(Node node)
	{
		traverse(null, root, 1, new TraverseHandler()
		{
			@Override
			public void doSomething(Node parent, Node index)
			{
				Node parentPoint;
				if(index.left ==  null || index.right == null)
					parentPoint = index.left == null ? index.right :index.left;
				else
				{
					Node most = index.right;
					while(most.left != null)
						most = most.left;
					
					parentPoint = most;
					most.left = index.left;
					
					while(most.right != null)
						most = most.right;
					
					most.right = index.right;
				}
				
				
				if (parent.obj.compareTo(index.obj) == 1)
					parent.left =  parentPoint;
				else
					parent.right =  parentPoint;
					
			}
		});
	}
	
	public void add(Node node)
	{
		if (root == null)
		{
			root = node;
			return;
		}

		Node index = root;
		while (true)
		{
			if (index.obj.compareTo(node.obj) == 1)		//小于root的在左边，大于等于在右边。
			{
				if (index.left == null)
				{
					index.left = node;
					return;
				}
				else
					index = index.left;
			}
			else
			{
				if (index.right == null)
				{
					index.right = node;
					return;
				}
				else
					index = index.right;
			}
		}
	}
	
	public void showAll(int type)
	{
		String msg ;
		if (type == 1)
			msg = "先序遍历";
		else if (type == 2)
			msg = "中序遍历";
		else
			msg = "后序遍历";
		traverse(null,root, type, new TraverseHandler()
		{
			@Override
			public void doSomething(Node parent, Node index)
			{
				System.out.print(index.obj.getValue()+",");
			}
		});
		System.out.println("::"+msg);
	}
	
	
	public static void main(String[] ar)
	{
		BinaryTree tree = new BinaryTree();
		tree.add(new Node(new Ttest(10),null,null));
		tree.add(new Node(new Ttest(12),null,null));
		tree.add(new Node(new Ttest(8),null,null));
		tree.add(new Node(new Ttest(7),null,null));
		tree.add(new Node(new Ttest(22),null,null));
		tree.add(new Node(new Ttest(14),null,null));
		tree.add(new Node(new Ttest(6),null,null));
		tree.add(new Node(new Ttest(19),null,null));
		tree.add(new Node(new Ttest(9),null,null));
		
		tree.showAll(1);
		tree.showAll(2);
		tree.showAll(3);
		
	}
	
	
}
