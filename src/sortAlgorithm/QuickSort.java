package sortAlgorithm;

import java.util.ArrayList;

import spotSystem.VertexNode;
/*
 * �������򣨲�·����
 */
public class QuickSort implements SortInterface {

	@Override 
	public void sort(ArrayList<VertexNode> spotArray) {
		// TODO �Զ����ɵķ������
		String[] spotName = new String[spotArray.size()];
		int[] degree = new int[spotArray.size()];
		
		for(int i = 0 ;i<spotArray.size();i ++){
			spotName[i] = spotArray.get(i).getName();
			degree[i] = spotArray.get(i).getDegree();
		}
		
		subSort(spotName,degree,0,spotArray.size()-1);
		System.out.println("���ղ�·���������£����ţ���");
		for(int i =0;i<spotArray.size();i++){
			System.out.print(spotName[i]+"("+degree[i]+")"+" ");
		}
		System.out.println();
	}

	private void subSort(String[] spotName, int[] degree, int left, int right) {
		//��left-right֮����п���
		if(left<right)
		{
			int pivotpos = partion(spotName, degree,left,right);//����
			
			//������������п���
			subSort(spotName, degree, left, pivotpos-1);
			//������������п���
			subSort(spotName, degree, pivotpos+1, right);
		}
	}

	private int partion(String[] spotName, int[] degree, int low, int high) {
		// TODO �Զ����ɵķ������
		int pivotops = low;//��׼λ��
		
		int temp = degree[low];
		degree[low] = degree[(low+high)/2];
		degree[(low+high)/2] = temp;
		String s = spotName[low];
		spotName[low] = spotName[(low+high)/2];
		spotName[(low+high)/2] = s;
		
		temp = degree[low];
		for(int i = low+1;i<=high;i++)
			if(degree[i]<temp&&++pivotops!=i)
			{
				int t = degree[i];
				degree[i] = degree[pivotops];
				degree[pivotops] = t;
				String S = spotName[i];
				spotName[i] = spotName[pivotops];
				spotName[pivotops] = S;
			}
		//С�ڻ�׼�ķŵ������ұ�
		int t = degree[low];
		degree[low] = degree[pivotops];
		degree[pivotops] = t;
		String S = spotName[low];
		spotName[low] = spotName[pivotops];
		spotName[pivotops] = S;
		return pivotops;
	}

}
