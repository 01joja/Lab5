/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

package deds;

import deds.SimState;
import deds.EventQueue;

public class EventStop extends Event {
	
	SimState simState;
	
	/**
	 * 
	 * @param stopSim Är det som triggar att simulationen tar slut.
	 * @param simState Den som håller igång simulationen.
	 * Klassen som stoppar hela simulationen.
	 */
	public EventStop(double stopSim, SimState simState){
		this.setNameOfEvent("STOP");
		setTime(stopSim);
		this.simState = simState;
		simState.getEventQueue().addStopEvent(this);
	}
    
	/**
	 * Stoppar hela simulationen.
	 */
	public void perform() {
		this.simState.setTime(getEventFinishTime());
		this.simState.simEnd();
	}
}
