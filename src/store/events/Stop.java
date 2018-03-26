/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

package store.events;

import deds.EventStop;
import deds.SimState;

public class Stop extends EventStop {
	
	/**
	 * Klassen stop stänger av simulatorn efter en viss tid har gått 
	 * @param stopSim tiden då simulatorn ska stanna
	 * @param simState den storstate som eventet ska påverka
	 */
	public Stop(double stopSim, SimState simState) {
		super(stopSim, simState);
	}

}
