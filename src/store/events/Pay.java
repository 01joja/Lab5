package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.Customer;
import store.sim.FIFORegistersAndQueue;
import store.sim.StoreState;

public class Pay extends Event {
	
	private Pay nextPay;
	private FIFORegistersAndQueue payQueue;
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
	private double timeTaken;
	
	/**
	 * 
	 * @param customer Skickas med som skapades under Arrival
	 * @param storeState Skickar värden till StoreState som håller i allt.
	 * Lägger till eventet i eventQueue, sätter namnet på eventet till pay.
	 */
	Pay(Customer customer, StoreState storeState) {
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
		this.timeTaken = this.storeState.getPayRandom().next();
		this.setTime(timeTaken + this.storeState.getTime());
		eventQueue.addEvent(this);
		this.customer = customer;
		super.setNameOfEvent("Pay      ");
		this.payQueue = this.storeState.getFIFO();
		if (this.payQueue.goAndPay(this, this.getEventFinishTime())){
			this.eventQueue.addEvent(this);
		}
	}
	
	public void perform() {
		
		this.storeState.updateStore(this, customer);
		if (this.payQueue.hasQueue()){
			this.eventQueue.addEvent(this.payQueue.getNextInQueue());
		}else{
			this.payQueue.oneFreeRegister();
		}
		this.storeState.addPay();
		this.storeState.setTime(getEventFinishTime());
		this.storeState.removeCustomer();
		
	}
	
	public void setNewPayTime(double simTime){
		this.setTime(simTime + this.timeTaken);
	}
	
	public int getCustomer(){
		return this.customer.getCustomerID();
	}
}

