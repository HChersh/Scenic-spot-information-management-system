package minSpanTree;

/*
 * ��¼�ߵ������Ϣ
 * ���������˽ڵ���±��Լ��ߵ�Ȩ��
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
