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
		//Ger Storestate 4 parametrar med värden för Antalet kunder som ryms
		// Antalet kassor,
<<<<<<< HEAD
		StoreState storeState = new StoreState(7, 2, 8.0, 13);
		
=======
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
<<<<<<< HEAD:src/store/MainSim.java
>>>>>>> 384e45bc3636138250b431b5e24d66f95f425adf
=======
		new StoreView(storeState);
>>>>>>> 493d137edc1e0e87faba623c4836778becd4c54a:src/store/RunSim.java
		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();
	}
}
