package spotSystem;
/*
 * �����࣬ʵ��Ҫ�����Ϣ
 */
public class DemoGraph {
	
	public Graph createAGraph(){
		Graph graph = new Graph(17, 12,true);
		graph.addNode(new VertexNode("����"));
		graph.addNode(new VertexNode("ʨ��ɽ"));
		graph.addNode(new VertexNode("����ʯ"));
		graph.addNode(new VertexNode("�����"));
		graph.addNode(new VertexNode("һ����"));
		graph.addNode(new VertexNode("������"));
		graph.addNode(new VertexNode("����̨"));
		graph.addNode(new VertexNode("����԰"));
		graph.addNode(new VertexNode("��ˮ̶"));
		graph.addNode(new VertexNode("���շ�"));
		graph.addNode(new VertexNode("������"));
		graph.addNode(new VertexNode("��Ҷͤ"));
		
		graph.getNode("����").setPopularity(70);
		graph.getNode("ʨ��ɽ").setPopularity(80);
		graph.getNode("����ʯ").setPopularity(75);
		graph.getNode("һ����").setPopularity(86);
		graph.getNode("������").setPopularity(60);
		graph.getNode("�����").setPopularity(95);
		graph.getNode("������").setPopularity(84);
		graph.getNode("����̨").setPopularity(99);
		graph.getNode("���շ�").setPopularity(90);
		graph.getNode("����԰").setPopularity(73);
		graph.getNode("��ˮ̶").setPopularity(64);
		graph.getNode("��Ҷͤ").setPopularity(81);
		
		graph.insertEdge("���š���ʨ��ɽ����9");
		graph.insertEdge("���š�������ʯ����8");
		graph.insertEdge("ʨ��ɽ����һ���졪��7");
		graph.insertEdge("ʨ��ɽ���������١���6");
		graph.insertEdge("����ʯ�������������4");
		graph.insertEdge("����ʯ���������š���5");
		graph.insertEdge("��������������š���7");
		graph.insertEdge("�����������ˮ̶����20");
		graph.insertEdge("һ���졪������̨����11");
		graph.insertEdge("һ���졪������԰����10");
		graph.insertEdge("�����١�������̨����3");
		graph.insertEdge("����̨������Ҷͤ����15");
		graph.insertEdge("����̨������ˮ̶����16");
		graph.insertEdge("����԰������Ҷͤ����9");
		graph.insertEdge("���շ塪����ˮ̶����17");
		graph.insertEdge("���շ塪����Ҷͤ����10");
		graph.insertEdge("�����š������շ塪��20");
		
		graph.getNode("����").
		setScription("������ڴ�");
		graph.getNode("ʨ��ɽ").
		setScription("�ǳ��ǳ��ÿ���ɽ");
		graph.getNode("����ʯ").
		setScription("һ���ر��ر��ر���ʯͷ");
		graph.getNode("һ����").
		setScription("һ�߷�϶������,����ȽȽ��ָ��");
		graph.getNode("������").
		setScription("����ֱ����ǧ�ߣ��������������");
		graph.getNode("�����").
		setScription("�Ͻ�ɽ�ɰزԴ�,��������⵴��");
		graph.getNode("������").
		setScription("���������,���ĵ�����");
		graph.getNode("����̨").
		setScription("����̨�ų�:����ɽ,��ɽ���߾�,ɽ�䳣����������,����������̨");
		graph.getNode("���շ�").
		setScription( "�ճ�������ʤ�� ,������ˮ������");
		graph.getNode("����԰").
		setScription("�ö�ö໨");
		graph.getNode("��ˮ̶").
		setScription("�����Ƕ�ӳ��̶��,ǡ��̶���������");
		graph.getNode("��Ҷͤ").
		setScription("ͣ������������ ˪Ҷ���ڶ��»�");
		
		return graph;
	}
	
}
