package store.events;

import deds.EventStart;
import deds.SimState;

public class Open extends EventStart {
	
	public Open(double OpenTime, double CloseTime, double simStopTime, SimState simState){
		super(simStopTime, simState);
	}
}

