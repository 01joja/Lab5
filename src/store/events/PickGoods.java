package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.*;

public class PickGoods extends Event {
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
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
		}
}
