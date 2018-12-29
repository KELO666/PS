package Scheduling;

import java.util.List;

import Algorithm.*;
import entity.process;

public class Util {

	/**
	 * 初始化
	 * @param list
	 */
	public static void init(List<process> list){
		process p = new process();
		p.setName("进程A");
		p.setArriveTime(0);
		p.setNeededTime(3);
		p.setServerTime(0);
		p.setStatus("Wait");
		p.setEnterTime(-1);//未执行
		
		process p1 = new process();
		p1.setName("进程B");
		p1.setArriveTime(2);
		p1.setNeededTime(6);
		p1.setServerTime(0);
		p1.setStatus("Wait");
		p1.setEnterTime(-1);//未执行
		
		process p2 = new process();
		p2.setName("进程C");
		p2.setArriveTime(4);
		p2.setNeededTime(4);
		p2.setServerTime(0);
		p2.setStatus("Wait");
		p2.setEnterTime(-1);//未执行
		
		process p3 = new process();
		p3.setName("进程D");
		p3.setArriveTime(6);
		p3.setNeededTime(5);
		p3.setServerTime(0);
		p3.setStatus("Wait");
		p3.setEnterTime(-1);//未执行
		
		process p4 = new process();
		p4.setName("进程E");
		p4.setArriveTime(8);
		p4.setNeededTime(2);
		p4.setServerTime(0);
		p4.setStatus("Wait");
		p4.setEnterTime(-1);//未执行
		
		list.add(p);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
	}
	
	/**
	 * 进程从普通队列进入就绪队列
	 * @param list_n
	 * @param list_W
	 * @param nowTime
	 */
	public static void n_TO_W(List<process> list_n,List<process> list_W,int nowTime){
		if(list_n.size()!=0){//普通队列不为空
			for (int i = 0; i < list_n.size(); i++) {
				if(list_n.get(i).getArriveTime() == nowTime){
					list_W.add(list_n.get(i));
					list_n.remove(i);
				}
			}
		}
		
	}
	
	/**
	 * 进程从就绪队列进入执行队列
	 * @param list_W
	 * @param list_R
	 * @param k
	 * @param nowTime
	 */
	public static List<process> W_TO_R(List<process> list_W,List<process> list_R,int k,int nowTime){
		if(list_W.size()!=0||list_R.size()!=0){//目前仍有未执行的进程或执行队列中有进程在执行
			if(k==1){
				fcfs.FCFS(list_W);//先来先服务
				if(list_R.size()==0){//目前没有进程正在执行
					list_R.add(list_W.get(0));
					list_W.remove(0);
				}		
				if(list_R.size()!=0){
					run(list_R.get(0),nowTime);
				}
			}
			if(k==2){
				list_W = sjf.SJF(list_W);//抢占式短作业优先
				if(list_R.size()!=0){//有进程正在执行
					if(list_W.size()!=0){
						if(list_W.get(0).getNeededTime()<list_R.get(0).getNeededTime()){
							list_W.add(list_R.get(0));
							list_R.remove(0);
							list_R.add(list_W.get(0));
							list_W.remove(0);
							
							for (int i = 0; i < list_W.size(); i++) {
								list_W.get(i).setStatus("Wait");
							}
							System.out.println("设置完的list_W");
						}
					}
				}else{
					list_R.add(list_W.get(0));
//					System.out.println("list_R");
//					print(list_R);
					list_W.remove(0);
//					System.out.println("list_W");
//					print(list_W);
				}
				if(list_R.size()!=0){
					run(list_R.get(0),nowTime);
				}
			}
			if(k==3){
				list_W = sjf.SJF(list_W);	//非抢占式短作业优先
				if(list_R.size()==0){//目前没有进程正在执行
					list_R.add(list_W.get(0));
					list_W.remove(0);
					//run(list_R.get(0),nowTime);
				}
				if(list_R.size()!=0){
					run(list_R.get(0),nowTime);
				}
			}
			if(k==4){
				list_W = hrrn.HRRN(list_W);//高响应比优先
				if(list_R.size()==0){//目前没有进程正在执行
					list_R.add(list_W.get(0));
					list_W.remove(0);
					//run(list_R.get(0),nowTime);
				}
				if(list_R.size()!=0){
					run(list_R.get(0),nowTime);
				}
			}
			if(k==5){
				rr.rr(list_W, list_R, nowTime);//时间片轮转法
			}
			
		}
		return list_W;
		
	}
	
	/**
	 * 进程从执行队列进入完成队列
	 * @param list_R
	 * @param list_F
	 */
	public static int R_TO_F(List<process> list_R,List<process> list_F){
		int n = 0;
		if(list_R.size()!=0){
			if(list_R.get(0).getStatus().equals("Finish")){
				list_F.add(list_R.get(0));
				list_R.remove(0);
			}
		}
		if(list_F.size()==5){
			n = 1;
		}
		return n;
	}
	
	/**
	 * 输出
	 * @param list
	 */
	public static void print(List<process> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	/**
	 * 进程执行
	 * @param p
	 */
	public static void run(process p,int nowTime) {
		if(p.getServerTime() == 0&&p.getStatus().equals("Wait")) {//未执行的进程设置开始执行时间
			p.setEnterTime(nowTime);
			p.setWaitTime((p.getEnterTime()-p.getArriveTime()));//设置等待时间
			p.setStatus("Run");
		}
		
		int serverTime = p.getServerTime();
		serverTime++;
		p.setServerTime(serverTime);//服务时间+1
		if(p.getServerTime() == p.getNeededTime()){
			p.setStatus("Finish");
		}		
	}
}
