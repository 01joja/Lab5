package deds;

import deds.SimState;

public class Event {
	
	private double finishTime;
	private String nameOfEvent;
	
	
	public void perform() {	
	}
	
	public double getEventFinishTime(){
		return finishTime;
	}
	
	public void setTime(double finishTime) {
		this.finishTime = finishTime;
		
	}
	
	public void setNameOfEvent(String name){
		this.nameOfEvent = name;
	}
	
	public String getNameOfEvent(){
		return nameOfEvent;
	}

}
