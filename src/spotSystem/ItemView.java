package spotSystem;
/*
 * @author 李哲201444810
 *	景点管理系统
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
			it.viewBuider();//建立系统视图
			System.out.println("请输入选项：");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				//创建景点的图
				it.graph = it.createGraph(it.graph);
				break;
			case 2:
				//查看图的矩阵和邻接表
				it.display();
				break;
			case 3:
				//图的深度遍历
				new Traversal(it.graph).graphTraversal();
				break;
			case 4:
				//图的回路判断
//				it.graph.printCircle();
				break;
			case 5:
				//迪杰斯特拉找最短路径
				new ShortestPath(it.graph).printPath();
				break;
			case 6:
				//最小生成树
				new MiniSpanTree(it.graph).printMinSpanTree();
				break;
			case 7:
				//停车场管理
				it.parking();
				break;
			case 8:
				it.spotInfo();
				break;	
			case 0:
				System.out.println("欢迎再次使用！");
				return;

			default:
				System.out.println("请输入0-9以内的选项！");
				break;
			}
		}
	}
	






	private void parking() {		
		boolean flag = true;
		// TODO 自动生成的方法存根
		Parking parking = new Parking(2,5);
		System.out.println("            **停车场管理程序**                   ");
		System.out.println("============================================");
		System.out.println("**========================================**");
		System.out.println("**A---汽车进车场===B---自动模拟======D---汽车出车场**");
		System.out.println("**============E--退出程序====================**");
		System.out.println("**========================================**");
		System.out.println("============================================");
		while(flag  ){
			System.out.print("请选择:");
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
				System.out.println("请输入正确的选项！");
				break;
			}
		}
	}







	private void spotInfo() {
		// TODO 自动生成的方法存根
		boolean flag = true;
		// TODO 自动生成的方法存根
		while(flag  ){
			System.out.println("1、关键字查询景点");
			System.out.println("2、景点推送");
			System.out.println("0、返回");
			System.out.println("请输入选项");
			int choice = scanner.nextInt();
			switch (choice ) {
			case 1:
				System.out.println("请输入关键字（景点名称或简介关键字）:");
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
				System.out.println("请输入正确的选项！");
				break;
			}
		}
	}




	private void display() {
		boolean flag = true;
		// TODO 自动生成的方法存根
		while(flag  ){
			System.out.println("1、查看邻接表");
			System.out.println("2、查看邻接矩阵");
			System.out.println("0、返回");
			System.out.println("请输入选项");
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
				System.out.println("请输入正确的选项！");
				break;
			}
		}
	}




	public Graph createGraph(Graph graph) {
		// TODO 自动生成的方法存根	

		boolean flag = true;
		while(flag ){
			System.out.println("1、创建景点图");
			System.out.println("2、为景点添加信息");
			System.out.println("0、返回");
			System.out.println("请输入选项");
			int choice = scanner.nextInt();
			switch (choice ) {
			case 1:
				System.out.println("请输入景点个数：");
				int VNum = scanner.nextInt();
				System.out.println("请输入边的个数：");
				int Enum = scanner.nextInt();
				graph = new Graph(Enum, VNum,false);
				break;
			case 2:
				System.out.println("请输入景点名称：");
				String name = scanner.next();
				graph.addSpotInfo(name);
				System.out.println("添加完毕！");
				break;
			case 0:
				return graph;

			default:
				System.out.println("请输入正确的选项！");
				break;
			}
		}
		return graph;
	
	}





	public void viewBuider(){
		System.out.println("=========================");
		System.out.println("	  欢迎使用景区信息管理系统	 ");
		System.out.println("	  ***请选择菜单***		 ");
		System.out.println("=========================");
		System.out.println("1、创建景区景点分布图");
		System.out.println("2、输出景区景点分布图");
		System.out.println("3、输出导游线路图");
		System.out.println("4、输出导游线路图中的回路");
		System.out.println("5、求两个景点间的最短距离和最短路径");
		System.out.println("6、输出道路修建规划图");
		System.out.println("7、停车场车辆进出信息");
		System.out.println("8、景点信息查询");
		System.out.println("0、退出系统");
	}
	
}
