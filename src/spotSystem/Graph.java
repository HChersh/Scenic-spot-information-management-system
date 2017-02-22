package spotSystem;

import java.util.ArrayList;

/*
 * 图的类：
 * 	其中的方法包括图的创建、遍历、邻接表及邻接矩阵的实现、最小生成树的实现
 */
public class Graph {
	
	private ArrayList<VertexNode> spotArray;//邻接表的存放
	private int ENum;//边的个数
	private int VNum;//点的个数
	private int[][] matrix;//邻接矩阵
	
	public int[][] getMatrix(){
		return this.matrix;
	}
	
	

	/*
	 * 图的构造方法需要传入一个Boolean变量
	 * 来决定是否调用已经写好的图
	 */
	public Graph(int Enum,int VNum,boolean importGraph){
		this.ENum = Enum;
		this.VNum = VNum;
		this.spotArray = new ArrayList<VertexNode>();
		
		if(!importGraph){
			createGraph();
		}	
	}
	
	//添加一个新的节点
	public void addNode(VertexNode vertexNode){
		spotArray.add(vertexNode);
	}

	public ArrayList<VertexNode> getSpotArray(){
		return spotArray;
	}
	
	
	//通过index来得到相应节点
	public VertexNode getNode(int i){
		return spotArray.get(i);
	}
	
	
	//通过name来得到相应节点
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
	
	//通过name得到某节点的index
	public int getIndexOfNode(String name){
		for(int i = 0;i<VNum;i++){
			if(name.equals(spotArray.get(i).getName())){
				return i;
			}
		}
		return -1;
	}
	
	//创建一个邻接表
	public void createGraph(){
		int i;
		//将景点名字保存到邻接表中
		for(i = 0 ;i<VNum;i++){
			System.out.println("请输入第个"+(i+1)+"景点的名字");
			
			//输入首节点的名字
			String vertexName = ItemView.scanner.next();
			spotArray.add(new VertexNode(vertexName));
			spotArray.get(i).setEdgeNode(null);//将其内部的引用初始化
		}
		
		for(i = 0;i<ENum;i++){
			System.out.println("请输入第"+(i+1)+"条边的信息(格式为: spot,spot,weight):");
			String edgeInfo = ItemView.scanner.next();
			
			//这里讲边的信息进行切分，切分成左节点、右节点及权重
			
			String lSpot = edgeInfo.split(",")[0];//left spot
			String rSpot = edgeInfo.split(",")[1];//right spot
			String weight = edgeInfo.split(",")[2];
			
			/*
			 * 	这里对插入的边信息的格式进行一下判断
			 * 如果输入的信息有问题，则让i--,重新输入一遍
			 */
			i=insertEdge(i,lSpot,rSpot,Integer.parseInt(weight));
		}
		
	}
	
	
	/*
	 * 	这个方法是我为了方便添加实验信息所写的
	 * 与实验本身无关，具体使用情况看DemoGraph这个类
	 */
	public void insertEdge(String edgeInfo) {
		
		String lSpot = edgeInfo.split("——")[0];
		String rSpot = edgeInfo.split("——")[1];
		int weight = Integer.parseInt(edgeInfo.split("——")[2]);
		int i = 0;
		int indexOfL=-1;//左节点的下标
		int indexOfR=-1;//右节点的下标
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
	
	//添加边的信息，包括边的两端的节点以及权重
	private int insertEdge(int flag,String lSpot, String rSpot, int weight) {
		// TODO 自动生成的方法存根
		int i = 0;
		int indexOfL=-1;//左节点的下标
		int indexOfR=-1;//右节点的下标
		for(;i<spotArray.size();i++){
			/*
			 * 用户传进来的时候不知道哪个是左哪个是右
			 * 因此需要进行两次比较
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
		 * 因为是无向图，所以插入一条边的时候
		 * 需要在两个节点上分别加上相应信息
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
			System.out.println("输入的信息有误，请重新输入！");
			return flag--;//有误的话就让i--,重新再输入一遍
		}
	}

	//为指定节点添加信息
	public void addSpotInfo(String name) {
		// TODO 自动生成的方法存根
		VertexNode ver = null;
		for(VertexNode v:spotArray){
			if(v.getName().equals(name))
				ver = v;
		}
		
		
		if(ver == null){
			System.out.println("您输入的景点不存在！");//对输入的信息进行校验
			return;
		}else{
			boolean flag = true;
			while(flag ){
				
				System.out.println("请输入简介：");
				ver.setScription(ItemView.scanner.next());
				
				//添加欢迎度
				System.out.println("请输入欢迎度(1-100)：");
				boolean isOutOfBounder = true;
				while(isOutOfBounder ){
					int popularity = ItemView.scanner.nextInt();
					if(popularity>1&&popularity<=100){//越界判断
						ver.setPopularity(popularity);
						isOutOfBounder =false;
					}else{					
						System.out.println("您输入的格式有误，请重新输入！");
					}
				}	
				
				//添加公厕
				System.out.println("请输入是否有公厕(Y/N)：");
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
						System.out.println("您输入的格式有误，请重新输入！");
					}						
				}
				
				//添加休息区
				System.out.println("请输入是否有休息区(Y/N)：");
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
						System.out.println("您输入的格式有误，请重新输入！");
					}
				}				
					flag = false;
			}
			
			
		}
	}

	//遍历邻接表
	public void printList() {
		// TODO 自动生成的方法存根

		for(VertexNode v:spotArray){
			String vInfo = v.getName();
			boolean flag = true;
			if(v.hasNextNode()){
				EdgeNode e = v.getEdgeNode();
				vInfo += "-->("+e.getName()+","
						+e.getWeight()+")";
				/*
				 * 对头结点的链表进行遍历
				 * 如果子节点非空，则继续添加信息
				 * 结点的信息格式为：
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

	//创建邻接矩阵
	public void createMatrix(){
		matrix = new int[VNum][VNum];
		for(int i = 0;i<VNum;i++){//遍历邻接表
			matrix[i][i] = 0;//自己到自己的距离为0
			for(int j=i+1;j<VNum;j++){
				EdgeNode e = spotArray.get(i).getChildNode(j);
				if(e!=null){
					//将邻接表数组中每一个元素的邻接节点进行存储
					matrix[i][j] = matrix[j][i] = e.getWeight();
				}else{
					//如果不存在了，那么就不是邻接节点，设为Max
					matrix[i][j] = matrix[j][i] = 32767;
				}
				
			}				
		}
	}
	
	//打印邻接矩阵
	public void printMatrix() {
		// TODO 自动生成的方法存根
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


	//模糊查询相关景点
	public String findSpotByKeyword(String keyword) {
		// TODO 自动生成的方法存根
		String spotInfo="";
		for(VertexNode v:spotArray){
			if(v.getName().equals(keyword)||
					//这里调用了String中的contains方法
					//来判断是否含有相关的子字符串
					v.getScription().contains(keyword)){
				spotInfo +=v.getName()+":"+v.getScription()+"\n";
			}
		}
		if(!spotInfo.equals("")){
			return spotInfo;
		}
			
		return "您输入的关键字不存在，没有相关查询结果！";
	}

	
}
