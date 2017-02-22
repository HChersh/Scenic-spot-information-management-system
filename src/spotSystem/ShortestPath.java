package spotSystem;

import java.util.Stack;
/*
 * 最短路径类，用迪杰斯特拉算法算出给出节点
 * 到其他节点的最短路径以及最短距离
 */
public class ShortestPath {
	
	private Graph graph;
	private int[] dist;//最短路径长度数组
	private int[] path;//最短路径数组-即前一节点
	private int[] s;//最短路径顶点集
	private int[][] matrix;
	private int size;//数组大小
	public final static int MAXMUM = 32767;//定义无穷大
	
	public ShortestPath(Graph garph){
		this.graph = garph;
		this.graph.createMatrix();//先创建好邻接矩阵
		this.size = this.graph.getVNum();
		this.dist = new int[size];
		this.s = new int[size];
		this.path = new int[size];
		this.matrix = this.graph.getMatrix();
	}
		

	public void printMatrix(int indexOfSourse){
		System.out.println("最短路径表如下：");
		for(int i=0;i<size;i++){
			if(i!=indexOfSourse)
			System.out.print(graph.getNode(i).getName()+"  ");
		}
		System.out.print("\n");
		//初始化所需的数据结构
		for(int i=0;i<this.graph.getVNum();i++){
			dist[i] = this.matrix[indexOfSourse][i];
			s[i] = 0;//	0表示第i个节点的最短路径还没找到
			if(i!=indexOfSourse&&dist[i]<MAXMUM)
				path[i] = indexOfSourse;
			else
				path[i] = -1;
		}
		
		s[indexOfSourse] = 1;//将起点加入s
		
		dist[indexOfSourse] = 0;
		
		for(int i=0;i<size-1;i++){//一共只用找size-1次，因为初始节点不用找
			float min = MAXMUM; 
			int nodeToBeAdded = indexOfSourse;
			for(int j = 0;j<size;j++){
				if(j!=indexOfSourse)
					System.out.print(dist[j]+" ");
				if(s[j]==0&&dist[j]<min){
					/*
					 * 这里判断第j个节点是否加入了s集合
					 * 如果没加入，并且是最短的那条边则加入s
					 * 并且更新min数据
					 */
					nodeToBeAdded = j;
					min = dist[j];
				}
			}
			s[nodeToBeAdded]=1;//将已经找到最短路径的节点标记
			System.out.println();
			for(int w = 0;w<size;w++){
				if(s[w]==0&&matrix[nodeToBeAdded][w]<MAXMUM
						&&dist[nodeToBeAdded]+matrix[nodeToBeAdded][w]<dist[w])
				{
					//更新那些没有加入s的节点与起点的距离
					dist[w] = dist[nodeToBeAdded]+matrix[nodeToBeAdded][w];
					path[w] = nodeToBeAdded;
				}
			}
		}
	}
	
	public void printPath(){
		System.out.println("请输入起点名：");
		boolean flag = true;
		int sourse = -1;
		int destination = -1;
		while(flag ){
			String name = ItemView.scanner.next();
			if((sourse=graph.getIndexOfNode(name))==-1)
				System.out.println("输入有误,请重新输入:");
			else
				flag = false;
		}
		printMatrix(sourse);
		System.out.println("请输入终点：");
		flag=true;
		while(flag ){
			String name = ItemView.scanner.next();
			if((destination=graph.getIndexOfNode(name))==-1)
				System.out.println("输入有误,请重新输入:");
			else
				flag = false;
		}
		System.out.println("最短路径如下:");
		Stack<Integer> stack = new Stack<Integer>();
		int temp = destination;
		//将起点与终点之间的节点下标压栈
		while(temp!=sourse){
			stack.push(temp);
			temp = path[temp];
		}
		System.out.print(graph.getNode(sourse).getName()+"-->");
		//因为是从终点往前压栈，所以出栈的时候顺序是从起点开始的
		while(!stack.isEmpty()){
			String placeholder="";
			int index = stack.pop();
			if(!stack.isEmpty())
				placeholder = "-->";
			System.out.print(graph.getNode(index).getName()+placeholder);
		}
		System.out.println("最短距离为："+dist[destination]);
	}
	
}
