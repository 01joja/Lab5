package store;
import deds.Simulator;
import store.sim.StoreState;
/**
 * 
 * @author's 
 * Jonas Jacobsson 
 * Marcus Carlsson 
 * Tommy Andersson 
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
		StoreState storeState = new StoreState(2, 5, 10.0, 1234);
		
		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();
	}
}
