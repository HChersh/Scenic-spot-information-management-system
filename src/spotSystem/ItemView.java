package spotSystem;
/*
 * @author ����201444810
 *	�������ϵͳ
 */
import java.util.Scanner;

import parkingLot.Parking;
import minSpanTree.MiniSpanTree;
import sortAlgorithm.BubbleSort;
import sortAlgorithm.InsertSort;
import sortAlgorithm.QuickSort;
import sortAlgorithm.SelectSort;
import sortAlgorithm.SortInterface;

public class ItemView {
	
	public static Scanner scanner = new Scanner(System.in);
	
	private Graph graph;
	
	public static void main(String[] args) {		
		ItemView it = new ItemView();
		it.graph = new DemoGraph().createAGraph();
		while(true){
			it.viewBuider();//����ϵͳ��ͼ
			System.out.println("������ѡ�");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				//���������ͼ
				it.graph = it.createGraph(it.graph);
				break;
			case 2:
				//�鿴ͼ�ľ�����ڽӱ�
				it.display();
				break;
			case 3:
				//ͼ����ȱ���
				new Traversal(it.graph).graphTraversal();
				break;
			case 4:
				//ͼ�Ļ�·�ж�
//				it.graph.printCircle();
				break;
			case 5:
				//�Ͻ�˹���������·��
				new ShortestPath(it.graph).printPath();
				break;
			case 6:
				//��С������
				new MiniSpanTree(it.graph).printMinSpanTree();
				break;
			case 7:
				//ͣ��������
				it.parking();
				break;
			case 8:
				it.spotInfo();
				break;	
			case 0:
				System.out.println("��ӭ�ٴ�ʹ�ã�");
				return;

			default:
				System.out.println("������0-9���ڵ�ѡ�");
				break;
			}
		}
	}
	






	private void parking() {		
		boolean flag = true;
		// TODO �Զ����ɵķ������
		Parking parking = new Parking(2,5);
		System.out.println("            **ͣ�����������**                   ");
		System.out.println("============================================");
		System.out.println("**========================================**");
		System.out.println("**A---����������===B---�Զ�ģ��======D---����������**");
		System.out.println("**============E--�˳�����====================**");
		System.out.println("**========================================**");
		System.out.println("============================================");
		while(flag  ){
			System.out.print("��ѡ��:");
			String choice = scanner.next();
			switch (choice.toUpperCase() ) {
			case "A":
				parking.carEnter();
				break;
			case "D":
				parking.carExit();
				break;
			case "E":
				flag = false;
				break;

			default:
				System.out.println("��������ȷ��ѡ�");
				break;
			}
		}
	}







	private void spotInfo() {
		// TODO �Զ����ɵķ������
		boolean flag = true;
		// TODO �Զ����ɵķ������
		while(flag  ){
			System.out.println("1���ؼ��ֲ�ѯ����");
			System.out.println("2����������");
			System.out.println("0������");
			System.out.println("������ѡ��");
			int choice = scanner.nextInt();
			switch (choice ) {
			case 1:
				System.out.println("������ؼ��֣��������ƻ���ؼ��֣�:");
				String keyword = scanner.next();
				System.out.println(graph.findSpotByKeyword(keyword));
				break;
			case 2:
				SortInterface si = new BubbleSort();
				si.sort(graph.getSpotArray());
				si = new InsertSort();
				si.sort(graph.getSpotArray());
				si = new QuickSort();
				si.sort(graph.getSpotArray());
				si = new SelectSort();
				si.sort(graph.getSpotArray());
				break;
			case 0:
				flag = false;
				break;

			default:
				System.out.println("��������ȷ��ѡ�");
				break;
			}
		}
	}




	private void display() {
		boolean flag = true;
		// TODO �Զ����ɵķ������
		while(flag  ){
			System.out.println("1���鿴�ڽӱ�");
			System.out.println("2���鿴�ڽӾ���");
			System.out.println("0������");
			System.out.println("������ѡ��");
			int choice = scanner.nextInt();
			switch (choice ) {
			case 1:
				graph.printList();
				break;
			case 2:
				graph.printMatrix();
				break;
			case 0:
				flag = false;
				break;

			default:
				System.out.println("��������ȷ��ѡ�");
				break;
			}
		}
	}




	public Graph createGraph(Graph graph) {
		// TODO �Զ����ɵķ������	

		boolean flag = true;
		while(flag ){
			System.out.println("1����������ͼ");
			System.out.println("2��Ϊ���������Ϣ");
			System.out.println("0������");
			System.out.println("������ѡ��");
			int choice = scanner.nextInt();
			switch (choice ) {
			case 1:
				System.out.println("�����뾰�������");
				int VNum = scanner.nextInt();
				System.out.println("������ߵĸ�����");
				int Enum = scanner.nextInt();
				graph = new Graph(Enum, VNum,false);
				break;
			case 2:
				System.out.println("�����뾰�����ƣ�");
				String name = scanner.next();
				graph.addSpotInfo(name);
				System.out.println("�����ϣ�");
				break;
			case 0:
				return graph;

			default:
				System.out.println("��������ȷ��ѡ�");
				break;
			}
		}
		return graph;
	
	}





	public void viewBuider(){
		System.out.println("=========================");
		System.out.println("	  ��ӭʹ�þ�����Ϣ����ϵͳ	 ");
		System.out.println("	  ***��ѡ��˵�***		 ");
		System.out.println("=========================");
		System.out.println("1��������������ֲ�ͼ");
		System.out.println("2�������������ֲ�ͼ");
		System.out.println("3�����������·ͼ");
		System.out.println("4�����������·ͼ�еĻ�·");
		System.out.println("5����������������̾�������·��");
		System.out.println("6�������·�޽��滮ͼ");
		System.out.println("7��ͣ��������������Ϣ");
		System.out.println("8��������Ϣ��ѯ");
		System.out.println("0���˳�ϵͳ");
	}
	
}
