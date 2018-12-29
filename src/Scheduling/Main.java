package Scheduling;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.process;

public class Main {

	public static void main(String[] args) {
		int time = 0;
		List<process> list_n = new ArrayList<process>();//普通队列
		List<process> list_W = new ArrayList<process>();//就绪队列
		List<process> list_R = new ArrayList<process>();//执行队列
		List<process> list_F = new ArrayList<process>();//完成队列
		int k ;
		int n = 0;
		Util.init(list_n);//初始化普通序列
		System.out.println("普通序列为：");
		Util.print(list_n);
		System.out.println("----------------------------------------------------");
		System.out.println("请选择进程调度算法：");
		System.out.println("1、先来先服务");
		System.out.println("2、抢占式短作业优先");
		System.out.println("3、非抢占式短作业优先");
		System.out.println("4、高响应比优先");
		System.out.println("5、时间片轮转法");
		System.out.println("----------------------------------------------------");
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		if(k<1||k>5){
			System.out.println("输入有误！");
			main(null);
		}
		//System.out.println("6、返回上一层");
		while(true){
			Util.n_TO_W(list_n,list_W,time);
			list_W = Util.W_TO_R(list_W, list_R, k, time);
			n = Util.R_TO_F(list_R, list_F);
			System.out.println("*****************************************************");
			System.out.println("当time="+time+"时 ");
			System.out.println("就绪序列为：");
			Util.print(list_W);
			System.out.println("执行序列为：");
			Util.print(list_R);
			System.out.println("完成序列为：");
			Util.print(list_F);
			System.out.println("*****************************************************");
			time++;
			if(n==1) break;
		}
		printsum(list_F);

	}

	/**
	 * 输出最终结果
	 * @param list_F
	 */
	private static void printsum(List<process> list_F) {
		System.out.println("进程名" + "\t" + "\t完成时间" + "\t" + "\t周转时间" + "\t" + "\t带权周转时间");
		double f = 0.00d;
		for (int i = 0; i < list_F.size(); i++) {
			String name = list_F.get(i).getName();
			int finishTime = list_F.get(i).getFinishTime();
			int turnoverTime = list_F.get(i).getFinishTime() - list_F.get(i).getArriveTime();
			//float wtTime = list_F.get(i).getWtTime();
			double wtTime = list_F.get(i).getWtTime();
			String f2 = new DecimalFormat("0.00").format(wtTime);
			f += list_F.get(i).getWtTime();
			System.out.println(name + "\t" + "\t" + finishTime + "\t" + "\t" + turnoverTime + "\t" + "\t" + f2);
		}
		f = (double)(Math.round(f/5.00d*100))/100;
		System.out.print("平均带权周转时间为：");
		String f1 = new DecimalFormat("#.00").format(f);
		System.out.println(f1);
		
	}

}
