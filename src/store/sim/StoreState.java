package store.sim;

import deds.Event;
import deds.SimState;

public class StoreState extends SimState {
	
	private double queuedTime = 0;
	private int paid = 0;
	private int angry = 0;
	private int queued = 0;
	private int currentlyQueuing = 0;
	private int registerQueue = 0;
	private int registersUsed = 0;
	private int customersInStore = 0;
	
	private StoreState(Customer c, Event e) {
		c.customerID();
		e.getTime();
	}
	
	public int customersInStore() {
		return this.customersInStore;
	}
	
	public void addCustomer() {
		customersInStore += 1;
	}
	
	public void removeCustomer() {
		customersInStore -= 1;
	}
	
	public void angry() {
		angry += 1;
	}
	public void addRegistersUsed() {
		registersUsed += 1;
	}
	
	

}
