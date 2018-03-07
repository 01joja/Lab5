package deds;

import deds.Event;
import deds.EventStop;

public class EventStart extends Event {
	
	Event eventStop;
	//Classen innehåller en constructor som 
	public EventStart(double simStopTime, SimState simState){
		eventStop = new EventStop(simStopTime, simState);
	}
}
