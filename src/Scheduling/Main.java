package Scheduling;

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
		System.out.println("----------------------------------------------------");
		System.out.println("请选择进程调度算法：");
		System.out.println("1、先来先服务");
		System.out.println("2、抢占式短作业优先");
		System.out.println("3、非抢占式短作业优先");
		System.out.println("4、高响应比优先");
		System.out.println("5、时间片轮转法");
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		//System.out.println("6、返回上一层");
		while(n==0){
			Util.n_TO_W(list_n,list_W,time);
			Util.W_TO_R(list_W, list_R, k, time);
			Util.R_TO_F(list_R, list_F);
			time++;
		}

	}

}
