package minSpanTree;
/*
 * ʵ����С��������һ���� 
 */
import java.util.Stack;

import spotSystem.Graph;
import spotSystem.ShortestPath;

public class MiniSpanTree {
	
	private Stack<EdgeInfo> minSpanTree;//����Ѿ��ҵ���·��
	private int[][] matrix;//ͨ��������ʵ����С������
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
			System.out.println("��"+tailName+"��"+headName+"��һ��·");
		}
	}
	
	private void prim(){//prim�㷨
		this.minSpanTree = new Stack<EdgeInfo>();
		int numOfV = this.graph.getVNum();//��ĸ���
		int [] lowCost = new int[numOfV];//��С��Ȩ��
		int [] nearV = new int[numOfV];
		
		//��ʼ��
		for(int i = 1;i<numOfV;i++){
			lowCost[i] = matrix[0][i];
			nearV[i] = 0;
		}
		nearV[0] = -1;//��ʾ��0���ڵ��Ѿ����ʹ�
		EdgeInfo edge ;
		for(int i = 1;i<numOfV;i++){
			int min = ShortestPath.MAXMUM;
			int v = 0;//��0�Žڵ㿪ʼ
			
			//�ҳ���v������Ǹ��㣬�������±겢������Ȩ��
			for(int j = 0;j<numOfV;j++){
				if(nearV[j]!=-1&&lowCost[j]<min){
					v = j;
					min = lowCost[j];
				}
			}
			//������ʵ��µĽڵ���ѹջ
			if(v!=0){
				edge = new EdgeInfo();
				edge.setTail(nearV[v]);
				edge.setHead(v);
				edge.setCost(lowCost[v]);
				minSpanTree.push(edge);
				nearV[v] = -1;//���Ѿ��ҵ��ĵ���б��
				
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
