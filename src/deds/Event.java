package deds;

public class Event {
	
	private double startTime;
	private double finishTime;
	private String nameOfEvent;
	
	
	public void perform() {
		
	}
	

	public double[] getTime() {
		double[] time = {startTime, finishTime};
		return time;
	}
	
	public double getEventFinishTime(){
		return finishTime;
	}
	
	public void setTime(double startTime, double finishTime) {
		this.startTime = startTime;
		this.finishTime = finishTime;
		
	}
	
	public void setNameOfEvent(String name){
		this.nameOfEvent = name;
	}
	
	public String getNameOfEvent(){
		return nameOfEvent;
	}

}
