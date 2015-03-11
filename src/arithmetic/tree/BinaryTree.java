/**
 *	2015年3月10日 下午2:17:58
 *	TangLi
 */
package arithmetic.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TangLi 2015年3月10日下午2:17:58
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
		private int weight;

		public Ttest(int weight)
		{
			super();
			this.weight = weight;
		}

		@Override
		public int compareTo(T t)
		{
			Ttest target = (Ttest) t;
			if (target.weight > this.weight)
				return -1;
			else if (target.weight < this.weight)
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
		public void doSomething(Node index);
	}

	public void traverse(Node index, int type, TraverseHandler handler)
	{
		if (index == null)
			return;
		if (type == 1)
		{
			handler.doSomething(index);
			traverse(index.left, type, handler);
			traverse(index.right, type, handler);
		}
		else if (type == 2)
		{
			traverse(index.left, type, handler);
			handler.doSomething(index);
			traverse(index.right, type, handler);
		}
		else
		{
			traverse(index.left, type, handler);
			traverse(index.right, type, handler);
			handler.doSomething(index);
		}

	}

	public Node find(Node node)
	{
		Node index = root;
		while (true)
		{
			if (index == null)
				return null;
			else if (index.obj.compareTo(node.obj) == 0)
				return index;
			else if (index.obj.compareTo(node.obj) == -1)
				index = index.right;
			else
				index = index.left;
		}
	}
	
	public void del(Node node)

	{
		Node index = root, parent = null;
		while (true)
		{
			if (index == null)
				return;
			else if (index.obj.compareTo(node.obj) == 0)
				break;
			else if (index.obj.compareTo(node.obj) == -1)
			{
				parent = index;
				index = index.right;
			}
			else
			{
				parent = index;
				index = index.left;
			}

		}
		
		Node most;
		// 节点只有一个孩子或者没有孩子的情况。
		if (index.left == null || index.right == null)
		{
			most = index.left == null ? index.right : index.left;
		}
		// 节点有两个孩子。
		else
		{
			most = index.right;
			Node mostParent = null;
			// 右子树最小孩子
			while (most.left != null)
			{
				mostParent = most;
				most = most.left;
			}
			most.left = index.left;

			if (mostParent != null) // 如果most就是 index.right,那么这一步将省略。
			{
				mostParent.left = most.right;
				most.right = index.right;
			}
		}

		// 删除根节点
		if (parent == null)
			root = most;
		// 删除普通节点
		else if (parent.obj.compareTo(index.obj) == 1)
			parent.left = most;
		else
			parent.right = most;

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
			if (index.obj.compareTo(node.obj) == 1) // 小于root的在左边，大于等于在右边。
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

	public static  List<Node> nodes =new LinkedList<Node>();;
	public BinaryTree huffManTree()
	{
		BinaryTree tree = new BinaryTree();
		
		TraverseHandler handler = new TraverseHandler()
		{
			@Override
			public void doSomething(Node index)
			{
				BinaryTree.nodes.add(index);///list添加的是地址而不是copy。
			}
		};
		traverse(root,2,handler);
		
		
		Node newRoot = new Node(new Ttest(0),null,null);
		
		Node min1 , min2;
		
		
		return tree;
		
	}
	
	public void showAll(int type)
	{
		String msg;
		if (type == 1)
			msg = "先序遍历";
		else if (type == 2)
			msg = "中序遍历";
		else
			msg = "后序遍历";
		traverse(root, type, new TraverseHandler()
		{
			@Override
			public void doSomething(Node index)
			{
				System.out.print(index.obj.getValue() + ",");
			}
		});
		System.out.println("::" + msg);
	}

	private static void showAll(BinaryTree tree)
	{
		tree.showAll(1);
		tree.showAll(2);
		tree.showAll(3);
	}

	public static void main(String[] ar)
	{
		BinaryTree tree = new BinaryTree();
		tree.add(new Node(new Ttest(10), null, null));
		tree.add(new Node(new Ttest(12), null, null));
		tree.add(new Node(new Ttest(8), null, null));
		tree.add(new Node(new Ttest(7), null, null));
		tree.add(new Node(new Ttest(22), null, null));
		tree.add(new Node(new Ttest(14), null, null));
		tree.add(new Node(new Ttest(6), null, null));
		tree.add(new Node(new Ttest(19), null, null));
		tree.add(new Node(new Ttest(9), null, null));

		showAll(tree);
		tree.del(new Node(new Ttest(10), null, null));
		showAll(tree);
		tree.del(new Node(new Ttest(22), null, null));
		showAll(tree);
		tree.del(new Node(new Ttest(8), null, null));
		showAll(tree);
		
//		System.out.println(tree.find(new Node(new Ttest(9),null,null)).obj.getValue());;

	}

}
