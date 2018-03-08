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
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
		new StoreView(storeState);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
	}
	
	private StoreState metod1(){
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
	}
	
	private StoreState metod11(int antalKassor){
		StoreState storeState = new StoreState(5, antalKassor, 10.0, 1234);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
	}
	
	private int metod2(){
		StoreState storeState = metod11(0);
		
		for(int i = 0; storeState.getSad() != 0; i++){
			storeState = metod11(i);
		}
		
		return storeState.getSad();
	}
}
