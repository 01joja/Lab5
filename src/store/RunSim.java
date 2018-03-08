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

//		StoreState storeState = new StoreState(7, 2, 8.0, 13);
		

		StoreState storeState = new StoreState(5, 2, 10.0, 1234);

		new StoreView(storeState);

		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();
=======
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
		new StoreView(storeState);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
	}
	
	private StoreState metod1(){
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
		new StoreView(storeState);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
>>>>>>> 62cbbe414fada79d581a8f4c7a9af05e40b6eaac
	}
}
