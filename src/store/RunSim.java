package store;
import deds.Simulator;
import store.sim.StoreState;
import store.sim.StoreView;

/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson 
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */
public class RunSim {
    /**
     * 
     * @param args
     */
	public static void main(String[] args) {
//		StoreState storeState = new StoreState(5, 2, 10.0, 1234);

		StoreState storeState = new StoreState(7, 2, 8.0, 13);
		
		new StoreView(storeState);

		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();


	}
}
