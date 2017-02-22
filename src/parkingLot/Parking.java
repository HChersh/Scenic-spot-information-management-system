package parkingLot;

import spotSystem.ItemView;
/*
 * ͣ����ϵͳ������
 * �����������Ľ����Լ���ȥ
 */
public class Parking {
	
	private Stack<Car> enterStack;//��Ž��������
	private Stack<Car> exitStack;//��Żع��˳�������
	private Queue tempParking;//���
	private int costPerHour;//ÿСʱ�ļ۸񣨳���һСʱ��һСʱ�㣩
	private String timeRegix;//ʱ���������ʽ

	public Parking(int size,int costPerHour){
		this.enterStack = new Stack<Car>(size);
		this.exitStack = new Stack<Car>(size);
		this.tempParking = new Queue();
		this.costPerHour = costPerHour;
		this.timeRegix = "[0-2][0-9]+:[0-6][0-9]";
	}
	
	
	public void carEnter(){
		System.out.print("����Ϊ��");
		int num = ItemView.scanner.nextInt();
		System.out.print("����ʱ��(xx:xx)��");
		String arvTime = ItemView.scanner.next();
		while(!arvTime.matches(timeRegix)){//������ʽ�жϸ�ʽ����
			System.out.print("�밴�ո�ʽ����(xx:xx)��");
			arvTime = ItemView.scanner.next();
		}
		
		
		if(!tempParking.isEmpty()||enterStack.isFull()){
			//���������ǿյĻ���ͣ�������ˣ��������ĳ��ͷ��ڱ����
			System.out.println("ͣ��������!������ʱ�����ϵȺ�!");
			tempParking.enQueue(new Car(num,arvTime));			
		}else{
			//���ͣ����û�������ұ��ҲΪ�գ��������ĳ�ֱ�ӿ���ͣ����
			enterStack.push(new Car(num,arvTime));
			System.out.println("�ó��ѽ���ͣ������"+enterStack.getSize()+"�ų�����");
		}
	}
	
	public void carExit(){
		System.out.println("����Ϊ��");
		int num = ItemView.scanner.nextInt();
		System.out.print("����ʱ�̣�");
		String levTime = ItemView.scanner.next();
		while(!levTime.matches(timeRegix)){//�������ʱ����������� 
			System.out.print("�밴�ո�ʽ����(xx:xx)��");
			levTime = ItemView.scanner.next();
		}
		boolean flag = true;
		int size = enterStack.getSize();
		
		while(flag && !enterStack.isEmpty()){
			/*
			 * �г�Ҫ��������ôͣ����ǰ��ĳ����ν���
			 * exitStack��ֱ���ó���ȥ
			 */
			Car car = enterStack.pop();
			if(car.getNumber()==num){
				System.out.println(car.getNumber()+"���˳���");
				System.out.println("��ȡ���ã�"+cost(car.getArriveTime(), levTime));
				flag = false;
			}else{
				exitStack.push(car);
			}
		}
		while(!exitStack.isEmpty()){
			Car car = exitStack.pop();
			enterStack.push(car);
		}
		
		//ͨ�������ڳ���ǰ�������仯
		//���ж��Ƿ��ҵ�����
		if(size==enterStack.getSize()){
			System.out.println("������ĳ��Ʋ�����!");
			return;
		}
		
		//���������г���������복��
		if(!tempParking.isEmpty()){
			Car car = tempParking.deQueue();
			car.setArriveTime(levTime);
			enterStack.push(car);
			System.out.println(car.getNumber()+"�ѽ�����");
		}
		
	}
	
	public int cost(String arvTime,String levTime){
		int cost = 0;
		int arvH = Integer.parseInt(arvTime.split(":")[0]);
		int levH = Integer.parseInt(levTime.split(":")[0]);
		int arvM = Integer.parseInt(arvTime.split(":")[1]);
		int levM = Integer.parseInt(arvTime.split(":")[1]);
		if(arvH<levH){
			if(arvM<levM)
				//��1��ʾ����һ��Сʱ�İ���1Сʱ��
				cost += (levH-arvH+1)*costPerHour;
			else
				cost +=	(levH-arvH)*costPerHour;
		}else if(arvH==levH){
			/*
			 * ������ͬʱ��Ĭ���Ѿ�ͣ��һ��
			 * ��Ϊ�������ܽ�ȥһ���Ӷ���ͣ
			 */
			return 24*costPerHour;
		}else{
			if(arvM<levM)
				cost += (24-arvH+levH+1)*costPerHour;
			else
				cost +=	(24-arvH+levH)*costPerHour;
		}
		return cost;
	}
	
	
}
