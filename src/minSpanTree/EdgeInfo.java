package minSpanTree;

/*
 * 记录边的相关信息
 * 包括边两端节点的下标以及边的权重
 */
	

public class EdgeInfo {
	private int cost;
	private int tail;
	private int head;
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getTail() {
		return tail;
	}
	public void setTail(int tail) {
		this.tail = tail;
	}
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	
}
