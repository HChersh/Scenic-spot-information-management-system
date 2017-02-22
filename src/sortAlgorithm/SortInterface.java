package sortAlgorithm;

import java.util.ArrayList;

import spotSystem.VertexNode;
/*
 * 给所有排序算法定义好一个统一的接口，方便调用
 */
public interface SortInterface {

	public void sort(ArrayList<VertexNode> spotArray);

}
