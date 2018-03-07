package deds;

import deds.SimState;
import deds.EventQueue;

public class EventStop extends Event {
	
	SimState simState;
	
	public EventStop(double stopSim, SimState simState){
		//sätter namnet på eventet till stop
		this.setNameOfEvent("STOP");
		//Sätter hur länge det tog att utföra eventet
		setTime(stopSim);
		//
		this.simState = simState;
		//Stoppar in det stoppade eventet längst back i eventQueue
		simState.eventQueue.addStopEvent(this);
	}
    
	public void perform() {
		//gör så att simulatorn avslutas
		this.simState.simEnd();
	}
}
