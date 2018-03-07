package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.*;

public class PickGoods extends Event {
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
	private UniformRandomStream randomTime;
	
	/**
	 * 	
	 * @param customer Skickar med samma kund som skapades i Arrival.
	 * @param storeState Skickar med ändringar till StoreState.
	 * Lägger till Eventet i eventQueue, sätter namnet på eventet till PickGoods, skickar med tiden kunden vart i affären.
	 */
	PickGoods(Customer customer, StoreState storeState) {
		this.storeState = storeState;
		this.customer = customer;
		this.eventQueue = this.storeState.getEventQueue();
		this.randomTime = this.storeState.getPickGoodsRandom();
		setTime(this.randomTime.next() + this.storeState.getTime());
		setNameOfEvent("PickGoods");
		this.eventQueue.addEvent(this);
	}
	
	/**
	 * Uppdaterar i storestate och sätter sluttid på eventet.
	 */
	//Uppdaterar storestate, sätter en tid och planerar en 
	// ny Ett nytt pay event  //när exprandomstream 
	//tycker att det är dags.
	public void perform () {
		storeState.setTime(getEventFinishTime());
		storeState.updateStore(this, customer);
		new Pay(customer, this.storeState);
		}
}
