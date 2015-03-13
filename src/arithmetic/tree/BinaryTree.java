/**
 *	2015年3月10日 下午2:17:58
 *	TangLi
 */
package arithmetic.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author TangLi 2015年3月10日下午2:17:58
 */
public class BinaryTree
{

	public static class Data
	{
		public int weight;

		public Data(int weight)
		{
			this.weight = weight;
		}
	}

	public static class Node
	{
		public Data data;
		public Node right;
		public Node left;
		/**
		 * left depth - right depth
		 */
		public int balanceFactor;

		public Node(Data value, Node left, Node right)
		{
			super();
			this.data = value;
			this.right = right;
			this.left = left;
			this.balanceFactor = 0;
		}

		public Node(Node cp)
		{
			this.data = new Data(cp.data.weight);
			this.right = cp.right;
			this.left = cp.left;
		}
	}

	public Node root;

	public static interface TraverseHandler
	{
		public void doSomething(Node index);
	}

	public int depth(Node node)
	{
		if(node== null)
			return 0;
		
		int l = depth(node.left);
		int r = depth(node.right);
		return l>r?l++:r++;
	}
	
	/**
	 * 以node 为轴 向右旋转
	 * @param node
	 * @param parent TODO
	 */
	private void rightRotate(Node node, Node parent)
	{
		Node index = node.left;
		node.left = index.right;
		index.right = node;
	}
	
	/**
	 * 以node 为轴 向左旋转
	 * @param node
	 * @param parent TODO
	 */
	private void leftRotate(Node node, Node parent)
	{
		Node index = node.right;
		node.right = index.left;
		index.left = node;
	}
	
	private void relateParent(Node node ,Node parent,boolean isleft)
	{
		if(parent == null)
			root = node;
		else
			if(isleft)
				parent.left = node;
			else
				parent.right = node;
	}
	
	/**
	 * 平衡node 的左右子树。
	 * @param node 
	 * @param parent
	 */
	public void balanceTree(Node node,Node parent)
	{
		if(node.balanceFactor>1)
		{
			switch(node.left.balanceFactor)
			{
			case 1:
				rightRotate(node, null);
				node.left.balanceFactor = 0 ;
				break;
			case -1:
				leftRotate(node.left, null);
				rightRotate(node, null);
				if(node.left.right.balanceFactor == 1 )
				{
					node.balanceFactor = -1 ;
					node.left.balanceFactor = 0;
					node.left.right.balanceFactor = 0;
				}else
				{
					node.balanceFactor = 0 ;
					node.left.balanceFactor = 1;
					node.left.right.balanceFactor = 0;
				}
				break;
				
			}
			
		}else if(node.balanceFactor <-1)
		{
			switch(node.right.balanceFactor)
			{
			case -1:
				leftRotate(node, null);
				node.left.balanceFactor = 0 ;
				break;
			case 1:
				rightRotate(node.right, null);
				leftRotate(node, null);
				if(node.right.left.balanceFactor == 1 )
				{
					node.balanceFactor = 0 ;
					node.right.balanceFactor = -1;
					node.right.left.balanceFactor = 0;
				}else
				{
					node.balanceFactor = 1 ;
					node.right.balanceFactor = 0;
					node.right.left.balanceFactor = 0;
				}
				break;
				
			}
		}
	}
	
	
	private Stack<Boolean> pathStack = new Stack<Boolean>();  //记录遍历路径。
	/**
	 * @param index
	 * @param type	1前序遍历，2中序遍历，其它后序遍历。
	 * @param handler 
	 * @param isLeft
	 */
	public void traverse(Node index, int type, TraverseHandler handler, Boolean isLeft)
	{
		if (index == null)
			return;
		
		pathStack.push(isLeft);
		if (type == 1)
		{
			handler.doSomething(index);
			traverse(index.left, type, handler, true);
			traverse(index.right, type, handler, false);
		}
		else if (type == 2)
		{
			traverse(index.left, type, handler, true);
			handler.doSomething(index);
			traverse(index.right, type, handler, false);
		}
		else
		{
			traverse(index.left, type, handler, true);
			traverse(index.right, type, handler, false);
			handler.doSomething(index);
		}
		pathStack.pop();

	}

	public Node find(Node node)
	{
		Node index = root;
		while (true)
		{
			if (index == null)
				return null;
			else if (index.data.weight== node.data.weight)
				return index;
			else if (index.data.weight<node.data.weight)
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
			else if (index.data.weight==node.data.weight)
				break;
			else if (index.data.weight < node.data.weight)
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
		else if (parent.data.weight>index.data.weight)
			parent.left = most;
		else
			parent.right = most;

	}

	public boolean add(Node node,Node parent)
	{
		if (parent == null)
		{
			return false;
		}

		////left add
		if (parent.data.weight >=node.data.weight) // 小于root的在左边，大于等于在右边。
		{
			if (parent.left != null)
			{
				if(add(node,parent.left))
				{
					switch (parent.balanceFactor)
					{
					case 0:
						parent.balanceFactor = 1;
						return true;
					case 1:
						rightRotate(parent, null);	//no break;
					case -1:
						parent.balanceFactor = 0 ;
						return false;
					}
				}
				return false;
			}
			else
			{
				parent.left = node;
				parent.balanceFactor ++;
				return parent.right == null ? true :false;
			}
			
		}
		/// right add
		else
		{
			if (parent.right != null)
			{
				if(add(node,parent.right))
				{
					switch (parent.balanceFactor)
					{
					case 0:
						parent.balanceFactor = -1;
						return true;
					case -1:
						leftRotate(parent, null);//no break;
					case 1:
						parent.balanceFactor = 0 ;
						return false;
					}
				}
				return false;
			}
			else
			{
				parent.right = node;
				parent.balanceFactor --;
				return parent.left == null ? true:false;
			}
		}
		
		
		
	}

	public static  List<Node> nodes =new LinkedList<Node>();
	
	public BinaryTree huffManTree()
	{
		TraverseHandler handler = new TraverseHandler()
		{
			@Override
			public void doSomething(Node index)
			{
				BinaryTree.nodes.add(new Node(index.data,null,null));///
			}
		};
		traverse(root,2,handler, null);
		
		Node min1 , min2;
		while(nodes.size() >1)
		{
			min1 = nodes.remove(0);
			min2 = nodes.remove(0);
			Node sum = new Node(new Data(min1.data.weight+ min2.data.weight),new Node(min1),new Node(min2));
			for(int i = 0 ;i <= nodes.size() ;i ++)
			{
				if(i== nodes.size() || sum.data.weight<=nodes.get(i).data.weight)
				{
					nodes.add(i, sum);
					break;
				}
			}
		}
		BinaryTree tree = new BinaryTree();
		tree.root = nodes.remove(0);
		return tree;
	}
	
	public void showHuffManCode()
	{
		BinaryTree tree = huffManTree();
		traverse(tree.root, 2, new TraverseHandler()
		{
			@Override
			public void doSomething(Node index)
			{
				if(index.left == null && index.right == null)
				{
					System.out.print(index.data.weight+"	---");
					for(Boolean b : pathStack)
					{
						if(b!=null)
							System.out.print(b?"0":"1");
					}
					System.out.println("");
				}
			}
		}, null);

	}
	
	public void showByType(int type)
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
				System.out.print(index.data.weight + ",");
			}
		}, null);
		System.out.println("::" + msg);
	}

	private static void showAll(BinaryTree tree)
	{
		tree.showByType(1);
		tree.showByType(2);
		tree.showByType(3);
	}

	public static void main(String[] ar)
	{
		BinaryTree tree = new BinaryTree();
		tree.add(new Node(new Data(10), null, null));
		tree.add(new Node(new Data(12), null, null));
		tree.add(new Node(new Data(8), null, null));
		tree.add(new Node(new Data(7), null, null));
		tree.add(new Node(new Data(22), null, null));
		tree.add(new Node(new Data(14), null, null));
		tree.add(new Node(new Data(6), null, null));
		tree.add(new Node(new Data(19), null, null));
		tree.add(new Node(new Data(9), null, null));

		showAll(tree);
		tree.del(new Node(new Data(10), null, null));
		showAll(tree);
		tree.del(new Node(new Data(22), null, null));
		showAll(tree);
		tree.del(new Node(new Data(8), null, null));
		showAll(tree);
		
		showAll(tree.huffManTree());
		
		tree.showHuffManCode();
		

	}

}
