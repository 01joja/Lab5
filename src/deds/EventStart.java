package deds;

import deds.Event;
import deds.EventStop;

public class EventStart extends Event {
	
	Event eventStop;
	
	/**
	 * 
	 * @param simStopTime Tiden som stoppar hela simulationen.
	 * @param simState Skickar med en tid för att slutföra simulationen.
	 * Startar igång hela simulationen.
	 */
	public EventStart(double simStopTime, SimState simState){
		eventStop = new EventStop(simStopTime, simState);
	}
}
