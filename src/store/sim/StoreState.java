package store.sim;

import deds.SimState;
import store.events.*;
import store.sim.*;


public class StoreState extends SimState {
	
	private final double LAMBDA = 4;
	private final double P_MIN = 0.6;
	private final double P_MAX = 0.9;
	private final double K_MIN = 0.35;
	private final double K_MAX = 0.6;
	
	private final int MAXCOSTUMER;
	private final int REGISTERS;
	private double queuedTime = 0;
	private double timeRegistersNotUsed = 0;
	private int paid = 0;
	private int angry = 0;
	private int currentlyQueuing = 0;
	private int registerQueue = 0;
	private int emptyRegisters = 0;
	private int customersInStore = 0;
	private int customersQueued = 0;
	private boolean storeIsOpen = false;
	
	private FIFO fifo;
	private ExponentialRandomStream arivalRandom;
	private 
	
	

	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen) { 
		new Open(0, timeStoreIsOpen, 999, this);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
		arivalRandom = new ExponentialRandomStream(LAMBDA);
		new Arrivals();
	}
	
	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen, long seed) { 
		new Open(0, timeStoreIsOpen, 999, this);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
		arivalRandom = new ExponentialRandomStream(LAMBDA, seed);
	}

	public int customersInStore() {
		return this.customersInStore;
	}
	
	public int getMaxCustomers(){
		return this.MAXCOSTUMER;
	}
	
	public int getRegisters(){
		return this.REGISTERS;
	}
		
	public double queuedTime() {
		if (fifo.isEmpty() == true) {
			return 0;
		}
		return 0.5;
	}
	
	public void openStore() {
		storeIsOpen = true;
	}
	
	public void closeStore() {
		storeIsOpen = false;
	}
	
	public FIFO getFIFO(){
		return fifo;
	}

}
