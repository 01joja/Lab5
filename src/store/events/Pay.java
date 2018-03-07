package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.Customer;
import store.sim.StoreState;

public class Pay extends Event {
	
	private Event Pay;
	private EventQueue eventQueue;
	private StoreState s;
	private Arrivals arrival;
	private Customer customer;
	
	
	/**
	 * 
	 * @param customer Skickas med som skapades under Arrival
	 * @param s Skickar värden till StoreState som håller i allt.
	 * Lägger till eventet i eventQueue, sätter namnet på eventet till pay.
	 */
	Pay(Customer customer, StoreState s) {
//		setTime;
		this.s=s;
		this.eventQueue = s.getEventQueue();
		eventQueue.addEvent(this);
		super.setNameOfEvent("Pay");
		this.eventQueue.addEvent(this);
		
	}
	
	public void perform() {
		
	}
}

//public class Pay {
//	
//	Pay() {
//		setTime;
//		super.setNameOfEvent("Pay");
//		EventQueue.addEvent(Pay);
//		
//	}
//	
//	public void perform() {
//		StoreState.
//	}
//}

