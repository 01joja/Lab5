package deds;

import deds.Event;
import deds.EventStop;

public class EventStart extends Event {
	
	Event eventStop;
<<<<<<< HEAD
	
	/**
	 * 
	 * @param simStopTime Tiden som stoppar hela simulationen.
	 * @param simState Skickar med en tid för att slutföra simulationen.
	 * STartar igång hela simulationen.
	 */
=======
	//Classen innehåller en constructor som startar ett event
>>>>>>> f8d2bd0ad9e1d40a28a036a737548ee589818460
	public EventStart(double simStopTime, SimState simState){
		eventStop = new EventStop(simStopTime, simState);
	}
}
