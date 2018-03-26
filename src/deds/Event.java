package deds;

import deds.SimState;
// Classen Event sätter ger värden på variablerna finishTime och
// nameOfEvent finishTIme ger tiden det tar på ett event
//och nameOfEvent ger varje event ett namn

public class Event {
	
	private double finishTime;
	private String nameOfEvent;
	
	/**
	 * Ärvs av andra eventklasser.
	 */
	public void perform() {	
	}
	
	/**
	 * 
	 * @return returnerar finishTIme
	 */
	public double getEventFinishTime(){
		return finishTime;
	}
	
	/**
	 * 
	 * @param finishTime ger finishTime ett värde
	 */
	protected void setTime(double finishTime) {
		this.finishTime = finishTime;
		
	}
	
	/**
	 * 
	 * @param name ger eventet ett namn, t.ex arrival.
	 */
	protected void setNameOfEvent(String name){
		this.nameOfEvent = name;
	}
	
	/**
	 * 
	 * @return returnerar namnet på eventet.
	 */
	public String getNameOfEvent(){
		return nameOfEvent;
	}

}
