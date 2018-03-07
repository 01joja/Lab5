package deds;

import deds.SimState;
// Classen Event sätter ger värden på variablerna finishTime och
// nameOfEvent finishTIme ger tiden det tar på ett event
//och nameOfEvent ger varje event ett namn

public class Event {
	
	private double finishTime;
	private String nameOfEvent;
	
	
	public void perform() {	
	}
	//returnerar finishTime
	public double getEventFinishTime(){
		return finishTime;
	}
	//ger finishTime ett värde
	protected void setTime(double finishTime) {
		this.finishTime = finishTime;
		
	}
	//ger eventet ett namn
	protected void setNameOfEvent(String name){
		this.nameOfEvent = name;
	}
	//returnerar nameOfEvent.
	public String getNameOfEvent(){
		return nameOfEvent;
	}

}
