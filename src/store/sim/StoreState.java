package store.sim;

import deds.SimState;
import store.events.*;
import store.sim.*;


public class StoreState extends SimState {
	
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
	private double lambda = 2;
	private long seed = 1234;
	private ExponentialRandomStream eRandomStream;
	
<<<<<<< HEAD
	public StoreState(int maxCustomers, int registers, double openTime) { 
		Open simStart = new Open(0, 999);
		
		admin = new StoreAdmin(registers, maxCustomers);

=======
	public void ExponentialArrivalTime(double lambda, long seed) {
		this.lambda = lambda;
		this.seed = seed;
		eRandomStream = new ExponentialRandomStream(lambda, seed);
>>>>>>> c16baa05d09de3c8c0ed738ddf5fa318886f31e8
	}

	
	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen) { 
		new Open(0, timeStoreIsOpen, 999, this);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
	}

	public int customersInStore() {
		return this.customersInStore;
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
