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
		
	//När ett nytt Arrivalobjekt skapas så får den en tid, läggs till i EvenQueue, döps till Arrival och lägger till en ny kund.
	public Arrivals(StoreState s, ExponentialRandomStream getTime, double time) {
		this.storeState=s;
		this.exponentialRandomStream = getTime;
		this.setTime(this.exponentialRandomStream.next() + storeState.getTime());
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("Arrivals");
		this.customer = new Customer();
		eventQueue.addEvent(this);
	}
	
	//Uppdaterar storestate, tittar om affären är full, sätter en tid och planerar en ny Arrival när exprandomstream tycker att det är dags.
	public void perform () {
		storeState.updateStore(this, customer);
		storeState.isStoreFull();
		storeState.setTime(this.getEventFinishTime());
//		new PickGoods(storeState, customer);
		new Arrivals(storeState,exponentialRandomStream, this.getEventFinishTime());
		}
}
