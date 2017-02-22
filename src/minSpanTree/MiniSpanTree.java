package minSpanTree;
/*
 * 实现最小生成树的一个类 
 */
import java.util.Stack;

import spotSystem.Graph;
import spotSystem.ShortestPath;

public class MiniSpanTree {
	
	private Stack<EdgeInfo> minSpanTree;//存放已经找到的路径
	private int[][] matrix;//通过矩阵来实现最小生成树
	private Graph graph;
	
	public MiniSpanTree(Graph graph){
		this.graph = graph;
		graph.createMatrix();
		this.matrix = graph.getMatrix();
	}
	
	public void printMinSpanTree(){
		prim();
		while(!minSpanTree.isEmpty()){
			EdgeInfo edgeInfo = minSpanTree.pop();
			String tailName = graph.getNode(edgeInfo.getTail()).getName();
			String headName = graph.getNode(edgeInfo.getHead()).getName();
			System.out.println("从"+tailName+"到"+headName+"修一条路");
		}
	}
	
	private void prim(){//prim算法
		this.minSpanTree = new Stack<EdgeInfo>();
		int numOfV = this.graph.getVNum();//点的个数
		int [] lowCost = new int[numOfV];//最小的权重
		int [] nearV = new int[numOfV];
		
		//初始化
		for(int i = 1;i<numOfV;i++){
			lowCost[i] = matrix[0][i];
			nearV[i] = 0;
		}
		nearV[0] = -1;//表示第0个节点已经访问过
		EdgeInfo edge ;
		for(int i = 1;i<numOfV;i++){
			int min = ShortestPath.MAXMUM;
			int v = 0;//从0号节点开始
			
			//找出离v最近的那个点，记下其下标并记下其权重
			for(int j = 0;j<numOfV;j++){
				if(nearV[j]!=-1&&lowCost[j]<min){
					v = j;
					min = lowCost[j];
				}
			}
			//如果访问到新的节点则压栈
			if(v!=0){
				edge = new EdgeInfo();
				edge.setTail(nearV[v]);
				edge.setHead(v);
				edge.setCost(lowCost[v]);
				minSpanTree.push(edge);
				nearV[v] = -1;//给已经找到的点进行标记
				
				for(int j = 1;j<numOfV;j++){
					if(nearV[j]!=-1&&matrix[v][j]<lowCost[j]){
						lowCost[j] = matrix[v][j];
						nearV[j] = v;
					}
				}
			}
			
		}
		
		
		
	}
	
}
