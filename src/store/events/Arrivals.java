package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.ExponentialRandomStream;
import store.sim.StoreState;
import store.events.PickGoods;

public class Arrivals extends Event{
	
	private ExponentialRandomStream exponentialRandomStream;
	private Event Arrivals;
	private Customer customer;
	private StoreState storeState;
	private EventQueue eventQueue;
		
	public Arrivals(StoreState s, ExponentialRandomStream getTime, double time) {
		this.storeState=s;
		this.exponentialRandomStream = getTime;
		this.setTime(this.exponentialRandomStream.next() + storeState.getTime());
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("Arrivals");
		this.customer = new Customer();
		eventQueue.addEvent(this);
	}
	
	public void perform () {
		storeState.updateStore(this, customer);
		storeState.isStoreFull();
		storeState.setTime(this.getEventFinishTime());
		new Arrivals(storeState,exponentialRandomStream, this.getEventFinishTime());
		}
}
