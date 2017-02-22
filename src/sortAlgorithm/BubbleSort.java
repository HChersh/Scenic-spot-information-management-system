package sortAlgorithm;

import java.util.ArrayList;

import spotSystem.VertexNode;
/*
 * ð�����򣨻�ӭ�ȣ�
 */
public class BubbleSort implements SortInterface {

	@Override
	public void sort(ArrayList<VertexNode> spotArray) {
		// TODO �Զ����ɵķ������
		String[] spotName = new String[spotArray.size()];
		int[] popularity = new int[spotArray.size()];
		
		for(int i = 0 ;i<spotArray.size();i ++){
			spotName[i] = spotArray.get(i).getName();
			popularity[i] = spotArray.get(i).getPopularity();
		}
		
		for(int i=1;i<spotArray.size();i++)
			for(int j = 0;j<spotArray.size()-i;j++){
				if(popularity[j]<popularity[j+1]){
					
					int temp = popularity[j];
					popularity[j] = popularity[j+1];
					popularity[j+1] = temp;
					String s = spotName[j];
					spotName[j] = spotName[j+1];
					spotName[j+1] = s;
				}
			}
		System.out.println("���ջ�ӭ���������£�ð�ݣ���");
		for(int i =0;i<spotArray.size();i++){
			System.out.print(spotName[i]+"("+popularity[i]+")"+" ");
		}
		System.out.println();
	}

}
