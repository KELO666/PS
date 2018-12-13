package Algorithm;

import java.util.ArrayList;
import java.util.List;

import entity.process;

/**
 * 短作业优先
 * @author kelo
 *
 */
public class sjf {

	/**
	 * 返回排序好的队列
	 * @param list
	 * @return
	 */
	public static List<process> SJF(List<process> list) {
		List<process> list_W = new ArrayList<process>();
		int[] arr = new int[list.size()];
		int[] arr1 = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i).getNeededTime();
		}
		arr1 = bubbleSort(arr);
		int k ;
		for (int i = 0; i < arr1.length; i++) {
			k = contain(arr1[i], arr);
			process p = list.get(k);
			list_W.add(i,p);
		}
		
		return list_W;
	}
	
	/**
	 * 取出数组中对应元素的下标
	 * @param priority
	 * @param pri
	 * @return
	 */
	public static int contain(int neededTime,int[] arr){
		int i;
		for (i = 0; i < arr.length; i++) {
			if(neededTime == arr[i]){
				return i;
			}
		}
		return i;		
	}
	/**
	 * 冒泡排序
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr)
    {
		int temp = 0;
        int size = arr.length;
        for(int i = 0 ; i < size-1; i ++)
        {
		    for(int j = 0 ;j < size-1-i ; j++)
		    {
		        if(arr[j] > arr[j+1])  //交换两数位置
		        {
		            temp = arr[j];
		            arr[j] = arr[j+1];
		            arr[j+1] = temp;
		        }
		    }
        }
		return arr;
    }
}
