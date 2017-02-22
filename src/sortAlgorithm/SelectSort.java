package sortAlgorithm;


import java.util.ArrayList;

import spotSystem.VertexNode;
/*
 * ѡ�����򣨻�ӭ�ȣ�
 */
public class SelectSort implements SortInterface {

	@Override
	public void sort(ArrayList<VertexNode> spotArray) {
		// TODO �Զ����ɵķ������
		String[] spotName = new String[spotArray.size()];
		int[] popularity = new int[spotArray.size()];
		
		for(int i = 0 ;i<spotArray.size();i ++){
			spotName[i] = spotArray.get(i).getName();
			popularity[i] = spotArray.get(i).getPopularity();
		}
		
		for(int i = 0;i<spotArray.size()-1;i++){
			int k = i;
			for(int j = i+1;j<spotArray.size();j++){
				if(popularity[j]>popularity[k]){
					k=j;//��ǰ�������ֵ�ö���
				}
			}
			if(k!=i){//�Ի�����i��λ��
				
				int temp = popularity[i];
				popularity[i] = popularity[k];
				popularity[k] = temp;
				String s = spotName[i];
				spotName[i] = spotName[k];
				spotName[k] = s;
			}
		}
	
		
		System.out.println("���ջ�ӭ���������£�ѡ�񣩣�");
		for(int i =0;i<spotArray.size();i++){
			System.out.print(spotName[i]+"("+popularity[i]+")"+" ");
		}
		System.out.println();
	}

}
