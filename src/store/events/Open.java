package store.events;

import deds.EventStart;
import deds.SimState;

public class Open extends EventStart {
	
	private double closeTime;
	
	public Open(double openTime, double closeTime, double simStopTime, SimState simState){
		super(simStopTime, simState);
		this.setTime(openTime);
		this.setNameOfEvent("Open");
		this.closeTime = closeTime;
	}
	
	void preform(){
		
	}
}

