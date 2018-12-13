package Scheduling;

import java.util.List;

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
}
