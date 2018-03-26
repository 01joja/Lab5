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

public class optimiser {
	
	static int maxCustomers = 1400; 
	static int registers = 2; 
	static double timeStoreIsOpen = 20.0; 
	static double lambda = 2000.0; 
	static double p_min = 0.45; 
	static double p_max = 0.65; 
	static double k_min = 0.2; 
	static double k_max = 0.3; 
	static double start = 0.0; 
	static long seed = 42;
	static int stopTime = 999;
	
	/**
     * 
     * @param args skicka inte med något!
     */
	public static void main(String[] args) {
		//Ger Storestate 4 parametrar med värden för Antalet kunder som ryms
		// Antalet kassor,
//		StoreState storeState = new StoreState(maxCustomers, registers, timeStoreIsOpen, lambda, p_min, p_max, k_min, k_max, start, seed);
//		StoreState storeState = new StoreState(7, 2, 8.0, 13);
//		new StoreView(storeState);
//		Simulator StorSimulator = new Simulator(storeState);
//		StorSimulator.mainLoop();
//		System.out.print("hej");
//		System.out.print("Minsta antal kassor " + metod2());
		System.out.print("Optimala antalet kassor " + metod2());
	}

	private static StoreState metod1(){
		StoreState storeState = new StoreState(maxCustomers, registers, timeStoreIsOpen, lambda, p_min, p_max, k_min, k_max, start, seed, stopTime);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
	}
	
	private static StoreState metod1(int antalKassor){
		
		StoreState storeState = new StoreState(maxCustomers, antalKassor, timeStoreIsOpen, lambda, p_min, p_max, k_min, k_max, start, seed, stopTime);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
		
	}
	
	private static StoreState metod1(int antalKassor, long random){
		
		StoreState storeState = new StoreState(maxCustomers, antalKassor, timeStoreIsOpen, lambda, p_min, p_max, k_min, k_max, start, random, stopTime);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
		
	}
	
	private static int metod2(){
		
		int missadeKunder = Integer.MAX_VALUE;
		int kassor = Integer.MAX_VALUE;
		
		StoreState storeState = metod1(0);
		
		int maxKunder = storeState.getMaxCustomers();
		int[][] list = new int[maxKunder][2];
		for(int i = 0; i < maxKunder; i++){
			
			list [i][0] = metod1(i).getSad();
			list [i][1] = metod1(i).getRegisters();
		}
		
		for(int i = 0; i < maxKunder; i++){
			if (missadeKunder > list[i][0]){
				missadeKunder = list [i][0];
				kassor = list [i][1];
			}
		}
		
		return kassor;
	}
	
	private static int metod2(long random){
		
		int missadeKunder = Integer.MAX_VALUE;
		int kassor = Integer.MAX_VALUE;
		
		StoreState storeState = metod1(0,random);
		
		int maxKunder = storeState.getMaxCustomers();
		int[][] list = new int[maxKunder][2];
		for(int i = 0; i < maxKunder; i++){
			StoreState temp = (StoreState) metod1(i,random);
			list [i][0] = temp.getSad();
			list [i][1] = temp.getRegisters();
		}
		
		for(int i = 0; i < maxKunder; i++){
			if (missadeKunder > list[i][0]){
				missadeKunder = list [i][0];
				kassor = list [i][1];
			}
		}
		return kassor;
	}
	
	public static int metod3(long seed){
		Random random = new Random(seed);
		long nextSeed = random.nextLong();
		int optimeradeKassor = 0;
		int kassor = 0;
		
		for (int i = 0; i < 100; i++){
			kassor = metod2(nextSeed);
			if ( optimeradeKassor < kassor){
				optimeradeKassor = kassor;
				i = 0;
				System.out.println("Antalet det stannade på: " + i + " Optimala nu: " + kassor);
			}
			nextSeed = random.nextLong();
		}
		return optimeradeKassor;
	}
}
