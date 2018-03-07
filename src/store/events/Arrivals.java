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
		
<<<<<<< HEAD
	public Arrivals(StoreState s) {
		this.s=s;
//		setTime;
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("Arrivals");
		this.customer = new Customer();
		this.eventQueue.addEvent(this);
	}
	
	public void perform () {
		s.updateStore(this, customer);
		s.isStoreFull();
		PickGoods pickgoods = new PickGoods(customer, s);

//		PickGoods pickgoods = new PickGoods();

		Arrivals arrivals = new Arrivals(s);
=======
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
>>>>>>> 044deca5007869b50c541d2f585544ab21f65f5d
		}
}
