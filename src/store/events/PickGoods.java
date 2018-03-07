package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.*;

public class PickGoods extends Event {
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
<<<<<<< HEAD
	private UniformRandomStream randomTime;
		
	PickGoods(Customer customer, StoreState storeState) {
		this.storeState = storeState;
		this.customer = customer;
		this.eventQueue = this.storeState.getEventQueue();
		this.randomTime = this.storeState.getPickGoodsRandom();
		setTime(this.randomTime.next() + this.storeState.getTime());
		setNameOfEvent("PickGoods");
		this.eventQueue.addEvent(this);
	}

	public void perform () {
		storeState.updateStore(this, customer);
		storeState.setTime(getEventFinishTime());
//		new Pay(customer, this.storeState);
=======

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
>>>>>>> 721a80e702ba232dc33a5afbc8f07c1d9cd8d798
		}
}
