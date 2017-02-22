package spotSystem;
/*
 * 邻接表元素的相邻节点信息
 * 包括：
 * 	邻接节点下标、相邻的距离、指向下个邻接节点的指针
 */
public class EdgeNode {
	private int adjvex;//该邻接节点的下标
	private int weight;//边的权重
	private EdgeNode edgeNode;//下一个相邻节点的引用
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

	//将新添加的节点不断交给子节点去完成
	public void addAjcNode(EdgeNode edgeNode) {
		// TODO 自动生成的方法存根
		if(this.edgeNode == null){
			this.edgeNode = edgeNode;
		}else{
			this.edgeNode.addAjcNode(edgeNode);
		}
	}

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
