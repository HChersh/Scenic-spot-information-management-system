package spotSystem;

import java.util.ArrayList;

/*
 * 图的遍历类
 */
public class Traversal {
	private int VNum;
	private ArrayList<VertexNode> spotArray;
	
	public Traversal(Graph graph) {
		// TODO 自动生成的构造函数存根
		this.spotArray = graph.getSpotArray();
		this.VNum = graph.getVNum();
	}
	
	private int getFirstNeighbor(int spot){
		if(spot>=0&&spot<VNum)
		return spotArray.get(spot).getEdgeNode().getAdjvex();
		return -1;
	}
	
	//图的遍历
	public void graphTraversal() {
		// TODO 自动生成的方法存根
		System.out.println("请输入起点名称：");
		String name = ItemView.scanner.next();
		int firstNode = -1;
		for(int i = 0;i<VNum;i++){
			if(name.equals(spotArray.get(i).getName())){
				firstNode = i;
				i = VNum;//如果查到，直接停止遍历
			}				
		}
		
		boolean flag = true;
		while(flag ){
			if(firstNode==-1){
				System.out.println("您输入的景点不存在，请重新输入！");
				name = ItemView.scanner.next();
				for(int i = 0;i<VNum;i++){
					if(name.equals(spotArray.get(i).getName())){
						firstNode = i;
						i = VNum;//如果查到，直接停止遍历
					}				
				}
			}else
				flag = false;
		}
		
		int[] visited = new int[VNum];//记录节点是否被访问过
		for(int i = 0;i<VNum;i++)
			visited[i] = 0;
		
		depthTraversal(firstNode,visited);
		
	}


	private void depthTraversal(int firstNode, int[] visited) {
		// TODO 自动生成的方法存根
		System.out.print(spotArray.get(firstNode).getName());
		
		visited[firstNode] = 1;//将当前节点设为已经遍历过
		int nextNode = getFirstNeighbor(firstNode);//取其第一个相邻节点
		
		String returnOutput = "";//返回时的输出结果
		while(nextNode!=-1){
			if(visited[nextNode]!=1){
				//若该节点未访问过则递归访问
				returnOutput="-->";
				System.out.print(returnOutput);
				depthTraversal(nextNode, visited);
				boolean flag = false;
				for(int i=0;i<VNum;i++)					
					if(visited[i]!=1)
						flag  = true;
				if(flag)
				System.out.print("-->"+spotArray.get(firstNode).getName());
			}
			nextNode = getNextNeighbor(firstNode,nextNode);
		}
		
	}
	

	private int getNextNeighbor(int firstNode, int nextNode) {
		// TODO 自动生成的方法存根
		EdgeNode en = spotArray.get(firstNode).getChildNode(nextNode);
		if(en!=null&&en.getEdgeNode()!=null)
		return en.getEdgeNode().getAdjvex();
		return -1;
	}


}
