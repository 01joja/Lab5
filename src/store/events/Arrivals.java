package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.StoreState;
import store.events.PickGoods;

public class Arrivals extends Event{
	
	private double startTime;
	private double finishTime;
	private Event Arrivals;
	private Customer customer;
	private StoreState s;
	private EventQueue eventQueue;
		
	public Arrivals(StoreState s) {
		this.s=s;
		setTime;
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("Arrivals");
		this.customer = new Customer();
		eventQueue.addEvent(this);;
	}
	
	public void perform () {
		s.updateStore(this, customer);
		s.isStoreFull();
<<<<<<< HEAD
		PickGoods pickgoods = new PickGoods(customer, s);
=======
//		PickGoods pickgoods = new PickGoods();
>>>>>>> 38ad77fac4e7bd7a33151db88864de99ff63c777
		Arrivals arrivals = new Arrivals(s);
		}
}
