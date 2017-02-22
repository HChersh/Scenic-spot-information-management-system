package spotSystem;
/*
 * 测试类，实验要求的信息
 */
public class DemoGraph {
	
	public Graph createAGraph(){
		Graph graph = new Graph(17, 12,true);
		graph.addNode(new VertexNode("北门"));
		graph.addNode(new VertexNode("狮子山"));
		graph.addNode(new VertexNode("仙云石"));
		graph.addNode(new VertexNode("仙武湖"));
		graph.addNode(new VertexNode("一线天"));
		graph.addNode(new VertexNode("飞流瀑"));
		graph.addNode(new VertexNode("观云台"));
		graph.addNode(new VertexNode("花卉园"));
		graph.addNode(new VertexNode("碧水潭"));
		graph.addNode(new VertexNode("朝日峰"));
		graph.addNode(new VertexNode("九曲桥"));
		graph.addNode(new VertexNode("红叶亭"));
		
		graph.getNode("北门").setPopularity(70);
		graph.getNode("狮子山").setPopularity(80);
		graph.getNode("仙云石").setPopularity(75);
		graph.getNode("一线天").setPopularity(86);
		graph.getNode("飞流瀑").setPopularity(60);
		graph.getNode("仙武湖").setPopularity(95);
		graph.getNode("九曲桥").setPopularity(84);
		graph.getNode("观云台").setPopularity(99);
		graph.getNode("朝日峰").setPopularity(90);
		graph.getNode("花卉园").setPopularity(73);
		graph.getNode("碧水潭").setPopularity(64);
		graph.getNode("红叶亭").setPopularity(81);
		
		graph.insertEdge("北门——狮子山——9");
		graph.insertEdge("北门——仙云石——8");
		graph.insertEdge("狮子山——一线天——7");
		graph.insertEdge("狮子山——飞流瀑——6");
		graph.insertEdge("仙云石——仙武湖——4");
		graph.insertEdge("仙云石——九曲桥——5");
		graph.insertEdge("仙武湖——九曲桥——7");
		graph.insertEdge("仙武湖——碧水潭——20");
		graph.insertEdge("一线天——观云台——11");
		graph.insertEdge("一线天——花卉园——10");
		graph.insertEdge("飞流瀑——观云台——3");
		graph.insertEdge("观云台——红叶亭——15");
		graph.insertEdge("观云台——碧水潭——16");
		graph.insertEdge("花卉园——红叶亭——9");
		graph.insertEdge("朝日峰——碧水潭——17");
		graph.insertEdge("朝日峰——红叶亭——10");
		graph.insertEdge("九曲桥——朝日峰——20");
		
		graph.getNode("北门").
		setScription("景区入口处");
		graph.getNode("狮子山").
		setScription("非常非常好看的山");
		graph.getNode("仙云石").
		setScription("一块特别特别特别大的石头");
		graph.getNode("一线天").
		setScription("一线缝隙见云天,光阴冉冉穿指间");
		graph.getNode("飞流瀑").
		setScription("飞流直下三千尺，疑是银河落九天");
		graph.getNode("仙武湖").
		setScription("紫金山松柏苍翠,仙武湖波光荡漾");
		graph.getNode("九曲桥").
		setScription("烟气笼青阁,流文荡画桥");
		graph.getNode("观云台").
		setScription("观云台古称:覆釜山,因山岳高峻,山间常年云雾缭绕,故又名观云台");
		graph.getNode("朝日峰").
		setScription( "日出江花红胜火 ,春来江水绿如蓝");
		graph.getNode("花卉园").
		setScription("好多好多花");
		graph.getNode("碧水潭").
		setScription("满天星斗映入潭中,恰似潭底又有天空");
		graph.getNode("红叶亭").
		setScription("停车坐爱枫林晚 霜叶红于二月花");
		
		return graph;
	}
	
}
