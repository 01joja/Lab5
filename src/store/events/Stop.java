package store.events;

import deds.EventStop;
import deds.SimState;

public class Stop extends EventStop {
    //Klassens top stänger av simulatorn efter en viss tid har gått 
	public Stop(double stopSim, SimState simState) {
		super(stopSim, simState);
	}

}
