package Algorithm;

import java.util.Collections;
import java.util.List;

import entity.process;

/**
 * 先来先服务
 * @author kelo
 *
 */
public class fcfs {

	public static void FCFS(List<process> list) {
		Collections.sort(list);//按到达时间排序
	}
}
