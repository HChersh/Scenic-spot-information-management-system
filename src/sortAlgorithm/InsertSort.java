package sortAlgorithm;

import java.util.ArrayList;

import spotSystem.VertexNode;
/*
 * �������򣨲�·��
 * 
 */
public class InsertSort implements SortInterface {

	@Override
	public void sort(ArrayList<VertexNode> spotArray) {
		// TODO �Զ����ɵķ������
		String[] spotName = new String[spotArray.size()];
		int[] degree = new int[spotArray.size()];
		
		for(int i = 0 ;i<spotArray.size();i ++){
			spotName[i] = spotArray.get(i).getName();
			degree[i] = spotArray.get(i).getDegree();
		}
		
		
		for(int i=1;i<spotArray.size();i++){
			int temp = degree[i];
			String name = spotName[i];
			int j = i;//����Ӻ���ǰ���бȽ�
			while(temp<degree[j-1]){
				degree[j] = degree[j-1];
				spotName[j] = spotName[j-1];
				j--;
			}
			degree[j] = temp;
			spotName[j] = name;
		}
		
		System.out.println("���ղ�·���������£����룩��");
		for(int i =0;i<spotArray.size();i++){
			System.out.print(spotName[i]+"("+degree[i]+")"+" ");
		}
		System.out.println();
	}

}
