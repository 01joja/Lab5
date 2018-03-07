package deds;

import deds.Event;
import deds.EventStop;

public class EventStart extends Event {
	
	Event eventStop;
	//Classen innehåller en constructor som startar ett event
	public EventStart(double simStopTime, SimState simState){
		eventStop = new EventStop(simStopTime, simState);
	}
}
