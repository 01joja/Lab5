package deds;

import deds.Event;

public class EventStart extends Event {
	
	
	
	public EventStart(double startTime, double finishTime){
		super.setNameOfEvent("Start");
		super.setTime(startTime, finishTime);
	}
	
}
