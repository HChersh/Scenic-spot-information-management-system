package spotSystem;

import java.util.Stack;
/*
 * ���·���࣬�õϽ�˹�����㷨��������ڵ�
 * �������ڵ�����·���Լ���̾���
 */
public class ShortestPath {
	
	private Graph graph;
	private int[] dist;//���·����������
	private int[] path;//���·������-��ǰһ�ڵ�
	private int[] s;//���·�����㼯
	private int[][] matrix;
	private int size;//�����С
	public final static int MAXMUM = 32767;//���������
	
	public ShortestPath(Graph garph){
		this.graph = garph;
		this.graph.createMatrix();//�ȴ������ڽӾ���
		this.size = this.graph.getVNum();
		this.dist = new int[size];
		this.s = new int[size];
		this.path = new int[size];
		this.matrix = this.graph.getMatrix();
	}
		

	public void printMatrix(int indexOfSourse){
		System.out.println("���·�������£�");
		for(int i=0;i<size;i++){
			if(i!=indexOfSourse)
			System.out.print(graph.getNode(i).getName()+"  ");
		}
		System.out.print("\n");
		//��ʼ����������ݽṹ
		for(int i=0;i<this.graph.getVNum();i++){
			dist[i] = this.matrix[indexOfSourse][i];
			s[i] = 0;//	0��ʾ��i���ڵ�����·����û�ҵ�
			if(i!=indexOfSourse&&dist[i]<MAXMUM)
				path[i] = indexOfSourse;
			else
				path[i] = -1;
		}
		
		s[indexOfSourse] = 1;//��������s
		
		dist[indexOfSourse] = 0;
		
		for(int i=0;i<size-1;i++){//һ��ֻ����size-1�Σ���Ϊ��ʼ�ڵ㲻����
			float min = MAXMUM; 
			int nodeToBeAdded = indexOfSourse;
			for(int j = 0;j<size;j++){
				if(j!=indexOfSourse)
					System.out.print(dist[j]+" ");
				if(s[j]==0&&dist[j]<min){
					/*
					 * �����жϵ�j���ڵ��Ƿ������s����
					 * ���û���룬��������̵������������s
					 * ���Ҹ���min����
					 */
					nodeToBeAdded = j;
					min = dist[j];
				}
			}
			s[nodeToBeAdded]=1;//���Ѿ��ҵ����·���Ľڵ���
			System.out.println();
			for(int w = 0;w<size;w++){
				if(s[w]==0&&matrix[nodeToBeAdded][w]<MAXMUM
						&&dist[nodeToBeAdded]+matrix[nodeToBeAdded][w]<dist[w])
				{
					//������Щû�м���s�Ľڵ������ľ���
					dist[w] = dist[nodeToBeAdded]+matrix[nodeToBeAdded][w];
					path[w] = nodeToBeAdded;
				}
			}
		}
	}
	
	public void printPath(){
		System.out.println("�������������");
		boolean flag = true;
		int sourse = -1;
		int destination = -1;
		while(flag ){
			String name = ItemView.scanner.next();
			if((sourse=graph.getIndexOfNode(name))==-1)
				System.out.println("��������,����������:");
			else
				flag = false;
		}
		printMatrix(sourse);
		System.out.println("�������յ㣺");
		flag=true;
		while(flag ){
			String name = ItemView.scanner.next();
			if((destination=graph.getIndexOfNode(name))==-1)
				System.out.println("��������,����������:");
			else
				flag = false;
		}
		System.out.println("���·������:");
		Stack<Integer> stack = new Stack<Integer>();
		int temp = destination;
		//��������յ�֮��Ľڵ��±�ѹջ
		while(temp!=sourse){
			stack.push(temp);
			temp = path[temp];
		}
		System.out.print(graph.getNode(sourse).getName()+"-->");
		//��Ϊ�Ǵ��յ���ǰѹջ�����Գ�ջ��ʱ��˳���Ǵ���㿪ʼ��
		while(!stack.isEmpty()){
			String placeholder="";
			int index = stack.pop();
			if(!stack.isEmpty())
				placeholder = "-->";
			System.out.print(graph.getNode(index).getName()+placeholder);
		}
		System.out.println("��̾���Ϊ��"+dist[destination]);
	}
	
}
