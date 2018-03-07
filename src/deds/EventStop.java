package deds;

import deds.SimState;
import deds.EventQueue;

public class EventStop extends Event {
	
	SimState simState;
	
	public EventStop(double stopSim, SimState simState){
		this.setNameOfEvent("STOP");
		setTime(stopSim);
		this.simState = simState;
		simState.eventQueue.addStopEvent(this);
	}

	public void perform() {
		this.simState.simEnd();
	}
}
