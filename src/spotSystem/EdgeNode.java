package spotSystem;
/*
 * �ڽӱ�Ԫ�ص����ڽڵ���Ϣ
 * ������
 * 	�ڽӽڵ��±ꡢ���ڵľ��롢ָ���¸��ڽӽڵ��ָ��
 */
public class EdgeNode {
	private int adjvex;//���ڽӽڵ���±�
	private int weight;//�ߵ�Ȩ��
	private EdgeNode edgeNode;//��һ�����ڽڵ������
	private String name;
	
	public boolean hasNextNode() {
		return (edgeNode!=null);
	}
	
	public EdgeNode(int adjvex,int weight,String name){
		this.adjvex = adjvex;
		this.weight = weight;
		edgeNode = null;
		this.name = name;
	}

	
	public String getName() {
		return name;
	}
	
	public int getAdjvex() {
		return adjvex;
	}

	public int getWeight() {
		return weight;
	}

	public EdgeNode getEdgeNode() {
		return edgeNode;
	}
	public void setEdgeNode(EdgeNode edgeNode) {
		this.edgeNode = edgeNode;
	}

	//������ӵĽڵ㲻�Ͻ����ӽڵ�ȥ���
	public void addAjcNode(EdgeNode edgeNode) {
		// TODO �Զ����ɵķ������
		if(this.edgeNode == null){
			this.edgeNode = edgeNode;
		}else{
			this.edgeNode.addAjcNode(edgeNode);
		}
	}

	public EdgeNode getChildNode(int j) {
		// TODO �Զ����ɵķ������
		if(edgeNode.getAdjvex()==j){
			return edgeNode;
		}
		//��ǰ�ӽڵ��index�����ϴ�����һ���ӽڵ�
		if(edgeNode.hasNextNode()){
			return edgeNode.getChildNode(j);
		}
		return null;
	}
}
