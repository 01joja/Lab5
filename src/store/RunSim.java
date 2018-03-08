package store;
import java.util.Random;

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
//		System.out.print("hej");
//		System.out.print("Minsta anta kassor " + metod2());
		System.out.print("Optimala antalet kassor " + metod3(9654));
	}
	
	private static StoreState metod1(){
		StoreState storeState = new StoreState(5, 2, 10.0, 1234);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
	}
	
	private static StoreState metod1(int antalKassor){
		
		StoreState storeState = new StoreState(100, antalKassor, 20.0, 42);
		Simulator storSimulator = new Simulator(storeState);
		storSimulator.mainLoop();
		return storeState;
		
	}
	
	private static StoreState metod1(int antalKassor, long random){
		
		StoreState storeState = new StoreState(100, antalKassor, 20.0, random);
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
			}
			nextSeed = random.nextLong();
		}
		
		return optimeradeKassor;
	}
}
