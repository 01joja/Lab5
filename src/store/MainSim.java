package store;
import deds.Simulator;
import store.sim.StoreState;
/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson 
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */
public class MainSim {
    /**
     * 
     * @param args
     */
	public static void main(String[] args) {
		//Ger Storestate 4 parametrar med värden för Antalet kunder som ryms
		// Antalet kassor,
		StoreState storeState = new StoreState(7, 2, 8.0, 13);
		
		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();
	}
}
