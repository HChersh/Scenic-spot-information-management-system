package spotSystem;

import java.util.ArrayList;

/*
 * ͼ���ࣺ
 * 	���еķ�������ͼ�Ĵ������������ڽӱ��ڽӾ����ʵ�֡���С��������ʵ��
 */
public class Graph {
	
	private ArrayList<VertexNode> spotArray;//�ڽӱ�Ĵ��
	private int ENum;//�ߵĸ���
	private int VNum;//��ĸ���
	private int[][] matrix;//�ڽӾ���
	
	public int[][] getMatrix(){
		return this.matrix;
	}
	
	

	/*
	 * ͼ�Ĺ��췽����Ҫ����һ��Boolean����
	 * �������Ƿ�����Ѿ�д�õ�ͼ
	 */
	public Graph(int Enum,int VNum,boolean importGraph){
		this.ENum = Enum;
		this.VNum = VNum;
		this.spotArray = new ArrayList<VertexNode>();
		
		if(!importGraph){
			createGraph();
		}	
	}
	
	//���һ���µĽڵ�
	public void addNode(VertexNode vertexNode){
		spotArray.add(vertexNode);
	}

	public ArrayList<VertexNode> getSpotArray(){
		return spotArray;
	}
	
	
	//ͨ��index���õ���Ӧ�ڵ�
	public VertexNode getNode(int i){
		return spotArray.get(i);
	}
	
	
	//ͨ��name���õ���Ӧ�ڵ�
	public VertexNode getNode(String name){
		for(VertexNode an:spotArray){
			if(an.getName().equals(name))
				return an;
		}
		return null;		
	}
	
	public int getENum(){
		return ENum;
	}
	public int getVNum(){
		return VNum;
	}
	
	//ͨ��name�õ�ĳ�ڵ��index
	public int getIndexOfNode(String name){
		for(int i = 0;i<VNum;i++){
			if(name.equals(spotArray.get(i).getName())){
				return i;
			}
		}
		return -1;
	}
	
	//����һ���ڽӱ�
	public void createGraph(){
		int i;
		//���������ֱ��浽�ڽӱ���
		for(i = 0 ;i<VNum;i++){
			System.out.println("������ڸ�"+(i+1)+"���������");
			
			//�����׽ڵ������
			String vertexName = ItemView.scanner.next();
			spotArray.add(new VertexNode(vertexName));
			spotArray.get(i).setEdgeNode(null);//�����ڲ������ó�ʼ��
		}
		
		for(i = 0;i<ENum;i++){
			System.out.println("�������"+(i+1)+"���ߵ���Ϣ(��ʽΪ: spot,spot,weight):");
			String edgeInfo = ItemView.scanner.next();
			
			//���ｲ�ߵ���Ϣ�����з֣��зֳ���ڵ㡢�ҽڵ㼰Ȩ��
			
			String lSpot = edgeInfo.split(",")[0];//left spot
			String rSpot = edgeInfo.split(",")[1];//right spot
			String weight = edgeInfo.split(",")[2];
			
			/*
			 * 	����Բ���ı���Ϣ�ĸ�ʽ����һ���ж�
			 * ����������Ϣ�����⣬����i--,��������һ��
			 */
			i=insertEdge(i,lSpot,rSpot,Integer.parseInt(weight));
		}
		
	}
	
	
	/*
	 * 	�����������Ϊ�˷������ʵ����Ϣ��д��
	 * ��ʵ�鱾���޹أ�����ʹ�������DemoGraph�����
	 */
	public void insertEdge(String edgeInfo) {
		
		String lSpot = edgeInfo.split("����")[0];
		String rSpot = edgeInfo.split("����")[1];
		int weight = Integer.parseInt(edgeInfo.split("����")[2]);
		int i = 0;
		int indexOfL=-1;//��ڵ���±�
		int indexOfR=-1;//�ҽڵ���±�
		for(;i<spotArray.size();i++){
			if(spotArray.get(i).getName().equals(lSpot)){
				indexOfL = i;
			}
			if(spotArray.get(i).getName().equals(rSpot)){
				indexOfR = i;
			}
		}
		
		String name;
		

		name = spotArray.get(indexOfR).getName();
		spotArray.get(indexOfL).
		addAjcNode(new EdgeNode(indexOfR, weight,name));
		name = spotArray.get(indexOfL).getName();
		spotArray.get(indexOfR).
		addAjcNode(new EdgeNode(indexOfL, weight,name));	

	}
	
	//��ӱߵ���Ϣ�������ߵ����˵Ľڵ��Լ�Ȩ��
	private int insertEdge(int flag,String lSpot, String rSpot, int weight) {
		// TODO �Զ����ɵķ������
		int i = 0;
		int indexOfL=-1;//��ڵ���±�
		int indexOfR=-1;//�ҽڵ���±�
		for(;i<spotArray.size();i++){
			/*
			 * �û���������ʱ��֪���ĸ������ĸ�����
			 * �����Ҫ�������αȽ�
			 */
			if(spotArray.get(i).getName().equals(lSpot)){
				indexOfL = i;
			}
			if(spotArray.get(i).getName().equals(rSpot)){
				indexOfR = i;
			}
		}
		
		String name;
		
		/*
		 * ��Ϊ������ͼ�����Բ���һ���ߵ�ʱ��
		 * ��Ҫ�������ڵ��Ϸֱ������Ӧ��Ϣ
		 */
		if(indexOfL!=-1&&indexOfR!=-1){		
			name = spotArray.get(indexOfR).getName();
			spotArray.get(indexOfL).
			addAjcNode(new EdgeNode(indexOfR, weight,name));
			name = spotArray.get(indexOfL).getName();
			spotArray.get(indexOfR).
			addAjcNode(new EdgeNode(indexOfL, weight,name));	
			return flag;
		}else{
			System.out.println("�������Ϣ�������������룡");
			return flag--;//����Ļ�����i--,����������һ��
		}
	}

	//Ϊָ���ڵ������Ϣ
	public void addSpotInfo(String name) {
		// TODO �Զ����ɵķ������
		VertexNode ver = null;
		for(VertexNode v:spotArray){
			if(v.getName().equals(name))
				ver = v;
		}
		
		
		if(ver == null){
			System.out.println("������ľ��㲻���ڣ�");//���������Ϣ����У��
			return;
		}else{
			boolean flag = true;
			while(flag ){
				
				System.out.println("�������飺");
				ver.setScription(ItemView.scanner.next());
				
				//��ӻ�ӭ��
				System.out.println("�����뻶ӭ��(1-100)��");
				boolean isOutOfBounder = true;
				while(isOutOfBounder ){
					int popularity = ItemView.scanner.nextInt();
					if(popularity>1&&popularity<=100){//Խ���ж�
						ver.setPopularity(popularity);
						isOutOfBounder =false;
					}else{					
						System.out.println("������ĸ�ʽ�������������룡");
					}
				}	
				
				//��ӹ���
				System.out.println("�������Ƿ��й���(Y/N)��");
				boolean isLegal = true;
				while(isLegal  ){					
					String existsWC = ItemView.scanner.next();
					if(existsWC.toUpperCase().equals("Y")){
						ver.setExistsWC(true);
						isLegal = false;
					}else if(existsWC.toUpperCase().equals("N")){
						ver.setExistsWC(false);
						isLegal = false;
					}else{					
						System.out.println("������ĸ�ʽ�������������룡");
					}						
				}
				
				//�����Ϣ��
				System.out.println("�������Ƿ�����Ϣ��(Y/N)��");
				isLegal = true;
				while(isLegal  ){					
					String existsRestAreas = ItemView.scanner.next();
					if(existsRestAreas.toUpperCase().equals("Y")){
						ver.setExistsRestArea(true);
						isLegal = false;
					}else if(existsRestAreas.toUpperCase().equals("N")){
						ver.setExistsRestArea(false);
						isLegal = false;
					}else{					
						System.out.println("������ĸ�ʽ�������������룡");
					}
				}				
					flag = false;
			}
			
			
		}
	}

	//�����ڽӱ�
	public void printList() {
		// TODO �Զ����ɵķ������

		for(VertexNode v:spotArray){
			String vInfo = v.getName();
			boolean flag = true;
			if(v.hasNextNode()){
				EdgeNode e = v.getEdgeNode();
				vInfo += "-->("+e.getName()+","
						+e.getWeight()+")";
				/*
				 * ��ͷ����������б���
				 * ����ӽڵ�ǿգ�����������Ϣ
				 * ������Ϣ��ʽΪ��
				 * node-->(index,weight)-->(index,weight)
				 */
				while(flag ){
					if(e.hasNextNode()){
						vInfo +="-->("+e.getEdgeNode().getName()
								+","+e.getEdgeNode().getWeight()+")";
						e = e.getEdgeNode();
					}else
						flag = false;
				}
			}
			
			System.out.println(vInfo);
		}
	}

	//�����ڽӾ���
	public void createMatrix(){
		matrix = new int[VNum][VNum];
		for(int i = 0;i<VNum;i++){//�����ڽӱ�
			matrix[i][i] = 0;//�Լ����Լ��ľ���Ϊ0
			for(int j=i+1;j<VNum;j++){
				EdgeNode e = spotArray.get(i).getChildNode(j);
				if(e!=null){
					//���ڽӱ�������ÿһ��Ԫ�ص��ڽӽڵ���д洢
					matrix[i][j] = matrix[j][i] = e.getWeight();
				}else{
					//����������ˣ���ô�Ͳ����ڽӽڵ㣬��ΪMax
					matrix[i][j] = matrix[j][i] = 32767;
				}
				
			}				
		}
	}
	
	//��ӡ�ڽӾ���
	public void printMatrix() {
		// TODO �Զ����ɵķ������
		if(matrix==null){
			createMatrix();
		}
		System.out.print("  ");
		for(int i = 0;i<VNum;i++){
			System.out.print(spotArray.get(i).getName()+" ");
		}
		System.out.println();
		for(int i = 0;i<VNum;i++){
			System.out.print(spotArray.get(i).getName()+" ");
			for(int j = 0;j<VNum;j++){            
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}


	//ģ����ѯ��ؾ���
	public String findSpotByKeyword(String keyword) {
		// TODO �Զ����ɵķ������
		String spotInfo="";
		for(VertexNode v:spotArray){
			if(v.getName().equals(keyword)||
					//���������String�е�contains����
					//���ж��Ƿ�����ص����ַ���
					v.getScription().contains(keyword)){
				spotInfo +=v.getName()+":"+v.getScription()+"\n";
			}
		}
		if(!spotInfo.equals("")){
			return spotInfo;
		}
			
		return "������Ĺؼ��ֲ����ڣ�û����ز�ѯ�����";
	}

	
}
