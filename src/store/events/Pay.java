package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.Customer;
import store.sim.StoreState;

<<<<<<< HEAD
public class Pay extends Event {
	
	private Event Pay;
	private EventQueue eventQueue;
	private StoreState s;
	private Arrivals arrival;
	private Customer customer;
	
	Pay(Customer customer, StoreState s) {
//		setTime;
		this.s=s;
		this.eventQueue = s.getEventQueue();
		eventQueue.addEvent(this);
		super.setNameOfEvent("Pay");
		this.eventQueue.addEvent(this);
		
	}
	
	public void perform() {
		StoreState.
	}
}
=======
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
>>>>>>> 044deca5007869b50c541d2f585544ab21f65f5d
