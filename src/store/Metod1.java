package store;

import deds.Simulator;
import store.sim.StoreState;
import store.sim.StoreView;

public class Metod1 {
	
	public static void main(String[] args) {
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
		new StoreView(storeState);
		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();
	}

}
