package store.sim;

import deds.SimState;

public class StoreState extends SimState {
	
	private double queuedTime = 0;
	private int paid = 0;
	private int angry = 0;
	private int queued = 0;
	private int currentlyQueuing = 0;
	private int registerQueue = 0;
	private int emptyRegisters = 0;
	private static int customersInStore = 0;
	
	public static int customersInStore() {
		return customersInStore;
	}

}
