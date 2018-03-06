package store;
import deds.Simulator;
import store.sim.StoreState;

public class MainSim {

	public static void main(String[] args) {
		StoreState storeState = new StoreState(2,5,10.0);
		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();
	}
}
