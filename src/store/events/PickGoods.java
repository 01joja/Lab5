/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

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
	public void perform () {
		storeState.setTime(getEventFinishTime());
		storeState.updateStore(this, customer);
		FIFORegistersAndQueue fifo = storeState.getFIFO();
		if (fifo.tryToPay(customer)){
			new Pay(customer, storeState);
		}
		}
}
