package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.Customer;
import store.sim.FIFORegistersAndQueue;
import store.sim.StoreState;

public class Pay extends Event {
	
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
		timeTaken = ((double)this.storeState.getPayRandom().next());
//		System.out.println(timeTaken);
		this.setTime(this.storeState.getTime() + timeTaken);
		this.customer = customer;
		super.setNameOfEvent("Pay      ");
		this.payQueue = this.storeState.getFIFO();
		this.eventQueue.addEvent(this);
	}
	
	public void perform() {
		
			this.storeState.setTime(getEventFinishTime());
			this.storeState.updateStore(this, customer);
			if (payQueue.hasPaid()){
				new Pay(this.payQueue.getFirstQueue(), storeState);
			}else{
				payQueue.removeOneInRegister();
			}
			this.storeState.removeCustomer();
			this.storeState.addPay();
		
	}
}

