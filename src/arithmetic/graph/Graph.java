/**
 *	2015年3月24日 上午9:18:54
 *	TangLi
 */
package arithmetic.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLi
 * 2015年3月24日上午9:18:54
 */
public class Graph
{
	
	public int vnum = 10;
	public List<Vertex<Integer>> vertexs;
	public Edge[][] edges;
	static class Vertex<T>
	{
		T data;
		public Vertex(T data)
		{
			super();
			this.data = data;
		}
		
	}	
	static class Edge
	{
		int weight ;
	}
	
	
	/**
	 * @param vnum
	 */
	public Graph(int vnum)
	{
		this.vnum = vnum;
		this.vertexs = new ArrayList<Vertex<Integer>>(vnum);
		this.edges = new Edge[vnum][vnum];
		initial();
	}
	
	protected void initial()
	{
//		int[] vertexData = Analyze.getNoRepeateable(vnum, vnum*3);
//		int[] edgeData = Analyze.getNoRepeateable(vnum, vnum*3);
//		
//		for(int i = 0 ;i < vnum ;i ++)
//		{
//			this.vertexs.add(new Vertex<Integer>(vertexData[i]));
//			
//		}
	}



	public static void main(String[] args)
	{

	}

}
