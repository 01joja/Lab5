package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.*;

public class PickGoods extends Event {
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
	private UniformRandomStream randomTime;
	
<<<<<<< HEAD
	/**
	 * 	
	 * @param customer Skickar med samma kund som skapades i Arrival.
	 * @param storeState Skickar med ändringar till StoreState.
	 * Lägger till Eventet i eventQueue, sätter namnet på eventet till PickGoods, skickar med tiden kunden vart i affären.
	 */
	//Skapar ett pickgood objects ger objected en tid slumpmässigt
	//läggs till i EvenQueue,döps till PickGoods och lägger till 
	
=======
	//Skapar ett pickgood objects ger objected en tid slumpmässigt
	//läggs till i EvenQueue,döps till PickGoods och lägger till 
>>>>>>> 32b7f0ec38fbfc5d2a572d673313db896447c545
	PickGoods(Customer customer, StoreState storeState) {
		this.storeState = storeState;
		this.customer = customer;
		this.eventQueue = this.storeState.getEventQueue();
		this.randomTime = this.storeState.getPickGoodsRandom();
		setTime(this.randomTime.next() + this.storeState.getTime());
		setNameOfEvent("PickGoods");
		this.eventQueue.addEvent(this);
	}
	
<<<<<<< HEAD
	/**
	 * Uppdaterar i storestate och sätter sluttid på eventet.
	 */
=======
>>>>>>> 32b7f0ec38fbfc5d2a572d673313db896447c545
	//Uppdaterar storestate, sätter en tid och planerar en 
	// ny Ett nytt pay event  //när exprandomstream 
	//tycker att det är dags.
	public void perform () {
		storeState.setTime(getEventFinishTime());
		storeState.updateStore(this, customer);
//		new Pay(customer, this.storeState);
		}
}
