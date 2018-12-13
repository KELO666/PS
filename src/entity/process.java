package entity;

public class process implements Comparable<process>{
	String name;
	int arriveTime;//到达时间
	int serverTime;//被服务时间
	int enterTime;//开始执行的时间
	int neededTime;//需要的服务时间
	int waitTime ;////等待时间=开始执行时间-到达时间
	String status;//状态  Wait-等待  Run-执行  Finish-完成
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(int arriveTime) {
		this.arriveTime = arriveTime;
	}
	public int getServerTime() {
		return serverTime;
	}
	public void setServerTime(int serverTime) {
		this.serverTime = serverTime;
	}
	public int getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}
	public int getNeededTime() {
		return neededTime;
	}
	public void setNeededTime(int neededTime) {
		this.neededTime = neededTime;
	}
	public int getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "process [name=" + name + ", arriveTime=" + arriveTime + ", serverTime=" + serverTime + ", enterTime="
				+ enterTime + ", neededTime=" + neededTime + ", status=" + status + "]";
	}
	@Override
	public int compareTo(process p) {
	//自定义比较方法，如果认为此实体本身大则返回1，否则返回-1
		if(this.arriveTime < p.arriveTime){
			return -1;
		}else if(this.arriveTime > p.arriveTime){
			return 1;
		}else{
			return 0;
		}
			
			
	}
	
}
