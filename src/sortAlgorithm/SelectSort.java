package sortAlgorithm;


import java.util.ArrayList;

import spotSystem.VertexNode;
/*
 * 选择排序（欢迎度）
 */
public class SelectSort implements SortInterface {

	@Override
	public void sort(ArrayList<VertexNode> spotArray) {
		// TODO 自动生成的方法存根
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
					k=j;//当前具有最大值得对象
				}
			}
			if(k!=i){//对换到第i个位置
				
				int temp = popularity[i];
				popularity[i] = popularity[k];
				popularity[k] = temp;
				String s = spotName[i];
				spotName[i] = spotName[k];
				spotName[k] = s;
			}
		}
	
		
		System.out.println("按照欢迎度排序如下（选择）：");
		for(int i =0;i<spotArray.size();i++){
			System.out.print(spotName[i]+"("+popularity[i]+")"+" ");
		}
		System.out.println();
	}

}
