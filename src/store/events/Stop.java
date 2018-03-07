package store.events;

import deds.EventStop;
import deds.SimState;

public class Stop extends EventStop {

	public Stop(double stopSim, SimState simState) {
		super(stopSim, simState);
	}

}
