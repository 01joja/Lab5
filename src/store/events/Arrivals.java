package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.ExponentialRandomStream;
import store.sim.StoreState;
import store.events.PickGoods;

public class Arrivals extends Event{
	
	private double startTime;
	private double finishTime;
	private ExponentialRandomStream exponentialRandomStream;
	private Event Arrivals;
	private Customer customer;
	private StoreState storeState;
	private EventQueue eventQueue;
		
	public Arrivals(StoreState s, ExponentialRandomStream time) {
		this.storeState=s;
		this.exponentialRandomStream = time;
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("Arrivals");
		this.customer = new Customer();
		eventQueue.addEvent(this);;
	}
	
	public void perform () {
<<<<<<< HEAD
		storeState.updateStore(this, customer);
		storeState.isStoreFull();
//		PickGoods pickgoods = new PickGoods();
		Arrivals arrivals = new Arrivals(storeState,exponentialRandomStream);
=======
<<<<<<< HEAD
=======
//		PickGoods pickgoods = new PickGoods();
>>>>>>> 38ad77fac4e7bd7a33151db88864de99ff63c777
>>>>>>> cc1e894f44f211436d72c3d6bd509ebbe3c837d3
		}
}
