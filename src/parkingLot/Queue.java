package parkingLot;
/*
 * ����Ķ��У������Ԫ��Ϊcar��
 */
public class Queue{
	
	private Car rear;//����βָ��
	private Car front;//����ͷָ��
	private int currentSize;//��ǰ���д�С
	
	
	//������
	public void enQueue(Car item){
		this.currentSize++;
		if(front == null){
			front = rear = item;
		}else{
			rear.setNext(item);
			rear = rear.getNext();
		}
	}
	
	//������
	public Car deQueue(){
		this.currentSize--;
		Car car = front;
		front = car.getNext();
		return car;
	}
	
	
    public int getSize(){
    	return this.currentSize;
    }


	public boolean isEmpty() {
		
		return front==null;
	}
	
}
