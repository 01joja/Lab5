package deds;

import deds.SimState;

public class EventStop extends Event {
	
	SimState simState;
	
	public EventStop(double stopSim, SimState simState){
		super.setTime(stopSim);
		this.simState = simState;
	}
	

	public void perform() {	
		this.simState.simEnd();
	}
}
