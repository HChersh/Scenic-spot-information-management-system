package spotSystem;

import java.util.ArrayList;

/*
 * ͼ�ı�����
 */
public class Traversal {
	private int VNum;
	private ArrayList<VertexNode> spotArray;
	
	public Traversal(Graph graph) {
		// TODO �Զ����ɵĹ��캯�����
		this.spotArray = graph.getSpotArray();
		this.VNum = graph.getVNum();
	}
	
	private int getFirstNeighbor(int spot){
		if(spot>=0&&spot<VNum)
		return spotArray.get(spot).getEdgeNode().getAdjvex();
		return -1;
	}
	
	//ͼ�ı���
	public void graphTraversal() {
		// TODO �Զ����ɵķ������
		System.out.println("������������ƣ�");
		String name = ItemView.scanner.next();
		int firstNode = -1;
		for(int i = 0;i<VNum;i++){
			if(name.equals(spotArray.get(i).getName())){
				firstNode = i;
				i = VNum;//����鵽��ֱ��ֹͣ����
			}				
		}
		
		boolean flag = true;
		while(flag ){
			if(firstNode==-1){
				System.out.println("������ľ��㲻���ڣ����������룡");
				name = ItemView.scanner.next();
				for(int i = 0;i<VNum;i++){
					if(name.equals(spotArray.get(i).getName())){
						firstNode = i;
						i = VNum;//����鵽��ֱ��ֹͣ����
					}				
				}
			}else
				flag = false;
		}
		
		int[] visited = new int[VNum];//��¼�ڵ��Ƿ񱻷��ʹ�
		for(int i = 0;i<VNum;i++)
			visited[i] = 0;
		
		depthTraversal(firstNode,visited);
		
	}


	private void depthTraversal(int firstNode, int[] visited) {
		// TODO �Զ����ɵķ������
		System.out.print(spotArray.get(firstNode).getName());
		
		visited[firstNode] = 1;//����ǰ�ڵ���Ϊ�Ѿ�������
		int nextNode = getFirstNeighbor(firstNode);//ȡ���һ�����ڽڵ�
		
		String returnOutput = "";//����ʱ��������
		while(nextNode!=-1){
			if(visited[nextNode]!=1){
				//���ýڵ�δ���ʹ���ݹ����
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
		// TODO �Զ����ɵķ������
		EdgeNode en = spotArray.get(firstNode).getChildNode(nextNode);
		if(en!=null&&en.getEdgeNode()!=null)
		return en.getEdgeNode().getAdjvex();
		return -1;
	}


}
