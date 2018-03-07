package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.*;

public class PickGoods extends Event {
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
	private UniformRandomStream randomTime;
	
	//Skapar ett pickgood objects ger objected en tid slumpmässigt
	//läggs till i EvenQueue,döps till PickGoods och lägger till 
	PickGoods(Customer customer, StoreState storeState) {
		this.storeState = storeState;
		this.customer = customer;
		this.eventQueue = this.storeState.getEventQueue();
		this.randomTime = this.storeState.getPickGoodsRandom();
		setTime(this.randomTime.next() + this.storeState.getTime());
		setNameOfEvent("PickGoods");
		this.eventQueue.addEvent(this);
	}
	
	//Uppdaterar storestate, sätter en tid och planerar en 
	// ny Ett nytt pay event  //när exprandomstream 
	//tycker att det är dags.
	public void perform () {
		storeState.setTime(getEventFinishTime());
		storeState.updateStore(this, customer);
//		new Pay(customer, this.storeState);
		}
}
