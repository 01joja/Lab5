package store.sim;

import deds.Event;
import deds.SimState;
import store.events.Open;
import deds.EventStart;

public class StoreState extends SimState {
	
	private double queuedTime = 0;
	private double timeRegistersNotUsed = 0;
	private int paid = 0;
	private int angry = 0;
	private int currentlyQueuing = 0;
	private int registerQueue = 0;
	private int emptyRegisters = 0;
	private int customersInStore = 0;
	private int customersQueued = 0;
	private int customersInLine[];
	private StoreAdmin admin;

	
	private StoreState(Customer c, Event e, int maxCustomers, int registers, int openTime) { 
		Open simStart = new Open(0, 999);
		admin = new StoreAdmin(registers, maxCustomers, openTime);
		c.customerID();
		e.getTime();
	}

	public int customersInStore() {
		return this.customersInStore;
	}
		
	public double queuedTime(FIFO f) {
		if (f.isEmpty() == true) {
			return 0;
		}
		
	}
	

}
