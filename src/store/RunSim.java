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
		//StoreState storeState = new StoreState(5, 2, 10.0, 1234);
//		StoreState storeState = new StoreState(7, 2, 8.0, 13);
//		new StoreView(storeState);
//		Simulator StorSimulator = new Simulator(storeState);
//		StorSimulator.mainLoop();
		System.out.print("hej");
		System.out.print(metod2());
	}
	
	private static StoreState metod1(){
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
	}
	
	private static StoreState metod1(int antalKassor){
		StoreState storeState = new StoreState(5, antalKassor, 10.0, 1234);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
	}
	
	private static int metod2(){
		StoreState storeState = metod1(0);
		int maxKunder = storeState.getMaxCustomers();
		int[][] list = new int[maxKunder][2];
		
		for(int i = 0; 1 < maxKunder; i++){
			list [i][0] = storeState.getSad(); 
			list [i][1] = storeState.getRegisters();
		}
		
		return storeState.getSad();
	}
}
