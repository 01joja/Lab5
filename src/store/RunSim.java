/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

package store;

import java.util.Random;

import deds.Simulator;
import store.sim.StoreState;
import store.sim.StoreView;

public class RunSim {
	
	static int maxCustomers = 7; 
	static int registers = 2; 
	static double timeStoreIsOpen = 8.0; 
	static double lambda = 3.0; 
	static double p_min = 0.6; 
	static double p_max = 0.9; 
	static double k_min = 0.35; 
	static double k_max = 0.6; 
	static double start = 0.0; 
	static long seed = 13;
	static int stopTime = 999;
	
    /**
     * 
     * @param args skicka inte med något!
     */
	public static void main(String[] args) {
		//Ger Storestate 4 parametrar med värden för Antalet kunder som ryms
		// Antalet kassor
		StoreState storeState = new StoreState(maxCustomers, registers, timeStoreIsOpen, lambda, p_min, p_max, k_min, k_max, start, seed, stopTime);
		new StoreView(storeState);
		Simulator StorSimulator = new Simulator(storeState);
		StorSimulator.mainLoop();
	}
}
