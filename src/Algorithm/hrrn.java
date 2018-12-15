package Algorithm;

import java.util.ArrayList;
import java.util.List;

import entity.process;

/**
 * 高响应比优先
 * @author kelo
 *
 */
public class hrrn {

	/**
	 * 返回排序好的队列
	 * @param list
	 * @return list_W
	 */
	public static List<process> HRRN(List<process> list) {
		List<process> list_W = new ArrayList<process>();
		float[] pri = new float[list.size()];
		float[] pri_b = new float[list.size()];
		pri = priority(list);
		pri_b = bubbleSort(pri);
		int k ;
		for (int i = 0; i < pri_b.length; i++) {
			k = contain(pri_b[i], pri);
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
	public static int contain(float priority,float[] pri){
		int i;
		for (i = 0; i < pri.length; i++) {
			if(priority == pri[i]){
				return i;
			}
		}
		return i;		
	}
	
	/**
	 * 冒泡排序
	 * @param pri
	 */
	public static float[] bubbleSort(float[] pri)
    {
		float temp = 0;
        int size = pri.length;
        for(int i = 0 ; i < size-1; i ++)
        {
        for(int j = 0 ;j < size-1-i ; j++)
        {
            if(pri[j] > pri[j+1])  //交换两数位置
            {
	            temp = pri[j];
	            pri[j] = pri[j+1];
	            pri[j+1] = temp;
            }
        }
        }
		return pri;
    }
	
	/**
	 * 计算优先权
	 * @param list
	 */
	public static float[] priority(List<process> list){
		int waitTime = 0;
		float[] pri = new float[list.size()];
		for (int i = 0; i < list.size(); i++) {
			if(i==0){
				list.get(0).setWaitTime(0);
				pri[0] = 1;
			}else{
				waitTime = list.get(i).getEnterTime()-list.get(i).getArriveTime();//等待时间=开始执行时间-到达时间
				list.get(i).setWaitTime(waitTime);
				pri[i] = (waitTime+list.get(i).getNeededTime())/list.get(i).getNeededTime();//优先权
			}		
		}
		return pri;
			
	}
}
