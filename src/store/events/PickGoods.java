package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.StoreState;

public class PickGoods extends Event {
	private EventQueue eventQueue;
	private StoreState s;
	private Customer customer;

	PickGoods(Customer customer, StoreState storeState) {
		//setTime;
		// 
		this.s=s;
		//Tar emot the föregående eventet (Arrivals)
		this.eventQueue = s.getEventQueue();
		//ändrar namnet på det nuvarande eventet
		super.setNameOfEvent("PickGoods");
		//Sätter ID på kunden som går in i PickGoods eventet
		this.customer = new Customer();
		//Adderar eventet till classen EventQueue
		this.eventQueue.addEvent(this);;
	}


	public void perform () {
		s.updateStore(this, customer);
		Pay pay = new Pay(customer, s);
		s.updateStore(this,customer);
//		Pay pay = new Pay();
		//PickGoods pickgoods = new PickGoods(s);
		}
}
