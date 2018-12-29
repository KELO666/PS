package Algorithm;

import java.util.Collections;
import java.util.List;

import entity.process;

/**
 * 时间片轮转
 * @author kelo
 *
 */
public class rr {
	public static void rr(List<process> list_W,List<process> list_R,int nowTime) {
		if(list_W.size()!=0&&list_R.size()==0){//目前没有进程在执行
			Collections.sort(list_W);//先来先服务
			list_R.add(list_W.get(0));
			list_W.remove(0);
			run(list_R.get(0),nowTime);
		}
		
		if(list_R.size()!=0&&list_R.get(0).getStatus().equals("Run")){
			if(list_W.size()!=0){
				list_W.add(list_R.get(0));//从执行队列加入到就绪队列末端
				list_W.get(list_W.size()-1).setStatus("Wait");//从Run设置为Wait
				list_R.remove(0);//从执行队列移除
				list_R.add(list_W.get(0));
				list_W.remove(0);
				run(list_R.get(0),nowTime);
			}else{
				run(list_R.get(0),nowTime);
			}
			
		}	
		
	}
	
	/**
	 * 进程执行
	 * @param p
	 */
	public static void run(process p,int nowTime) {
		int waitTime = 0;
		if(p.getServerTime() == 0&&p.getStatus().equals("Wait")) {//未执行的进程设置开始执行时间
			p.setEnterTime(nowTime);
		}
		p.setStatus("Run");
		int serverTime = p.getServerTime();
		serverTime++;
		p.setServerTime(serverTime);//服务时间+1
		if(p.getServerTime() == p.getNeededTime()){
			p.setStatus("Finish");
			waitTime = nowTime-p.getArriveTime()-p.getNeededTime();
			p.setWaitTime(waitTime);
			p.setFinishTime(nowTime);
			p.setWtTime((p.getFinishTime()-p.getArriveTime())/serverTime);
		}		
	}
}
