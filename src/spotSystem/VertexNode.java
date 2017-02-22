package spotSystem;

/*
 * �ڽӱ��еĽڵ�Ԫ����
 * ��������������Ϣ���Լ����ڽڵ��ָ��
 */
public class VertexNode {
	private EdgeNode edgeNode;
	private String name;
	private String scription;
	private int popularity;
	private boolean existsWC;
	private boolean existsRestArea;
	private int degree;
	
	public boolean hasNextNode() {
		return (edgeNode!=null);
	}
	
	public void addAjcNode(EdgeNode edgeNode){
		this.degree++;
		if(this.edgeNode == null){
			this.edgeNode = edgeNode;
		}else{
			this.edgeNode.addAjcNode(edgeNode);
		}
	}
	
	public int getDegree(){
		return this.degree;
	}
	
	public VertexNode(String name) {
		// TODO �Զ����ɵĹ��캯�����
		this.name = name;
		this.edgeNode = null;
		this.degree = 0;
		this.scription = "��Ϊ�þ�����ϼ����Ϣ��";
	}
	
	public EdgeNode getEdgeNode() {
		return edgeNode;
	}
	public void setEdgeNode(EdgeNode edgeNode) {
		this.edgeNode = edgeNode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScription() {
		return scription;
	}
	public void setScription(String scription) {
		this.scription = scription;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public boolean isExistsWC() {
		return existsWC;
	}
	public void setExistsWC(boolean existsWC) {
		this.existsWC = existsWC;
	}
	public boolean isExistsRestArea() {
		return existsRestArea;
	}
	public void setExistsRestArea(boolean existsRestArea) {
		this.existsRestArea = existsRestArea;
	}

	


	//ͨ���±�õ��ӽڵ�
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
