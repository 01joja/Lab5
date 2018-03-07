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
		//sätter namnet på eventet till stop
		this.setNameOfEvent("STOP");
		//Sätter hur länge det tog att utföra eventet
		setTime(stopSim);
		//sätter värdet på objectet simstate
		this.simState = simState;
		//Stoppar in det stoppade eventet längst back i eventQueue
		simState.eventQueue.addStopEvent(this);
	}
    
	public void perform() {
		//gör så att simulatorn avslutas
		this.simState.simEnd();
	}
}
