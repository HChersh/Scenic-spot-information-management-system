package spotSystem;

/*
 * 邻接表中的节点元素类
 * 包括景点的相关信息、以及相邻节点的指针
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
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.edgeNode = null;
		this.degree = 0;
		this.scription = "请为该景点加上简介信息！";
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

	


	//通过下标得到子节点
	public EdgeNode getChildNode(int j) {
		// TODO 自动生成的方法存根
		if(edgeNode.getAdjvex()==j){
			return edgeNode;
		}
		//当前子节点的index不符合传给下一个子节点
		if(edgeNode.hasNextNode()){
			return edgeNode.getChildNode(j);
		}
		return null;
	}
}
