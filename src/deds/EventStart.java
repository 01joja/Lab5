package deds;

import deds.Event;
import deds.EventStop;

public class EventStart extends Event {
	
	Event eventStop;
	
	public EventStart(double simStopTime, SimState simState){
		eventStop = new EventStop(simStopTime, simState);
	}
}
