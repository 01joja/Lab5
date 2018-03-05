package store.sim;

import deds.Event;
import deds.SimState;

public class StoreState extends SimState {
	
	private double queuedTime = 0;
	private double timeRegistersNotUsed = 0;
	private int paid = 0;
	private int angry = 0;
	private int queued = 0;
	private int currentlyQueuing = 0;
	private int registerQueue = 0;
	private int emptyRegisters = 0;
	private int customersInStore = 0;
	private int customersQueued = 0;
	private int customersInLine[];
	private int OPEN = 0;
	private int CLOSED = 1;
	
	private StoreState(Customer c, Event e) { 
		c.customerID();
		e.getTime();
	}
	
	public int openOrClosed(store.events.Start s) { //this method is supposed to change the state of the store top open or closed
		if (s == 1) {
			return OPEN;
		}
		return CLOSED;
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
	
	public void removeResgistersUSed() {
		registersUsed -= 1;
	}
	
	public void paid() {
		paid += 1;
	}
	
	public void queued() {
		queued += 1;
	}
	
	public double queuedTime(FIFO f) {
		if (f.isEmpty() == true) {
			return 0;
		}
		
	}
	

}
