/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

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
