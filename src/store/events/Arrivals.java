package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.ExponentialRandomStream;
import store.sim.StoreState;
import store.events.*;

public class Arrivals extends Event{
	
	private ExponentialRandomStream exponentialRandomStream;
	private Event Arrivals;
	private Customer customer;
	private StoreState storeState;
	private EventQueue eventQueue;

	/**
	 * 
	 * @param s skickar med StoreState som parameter.
	 * @param getTime Tiden det tar för en kund att komma till affären.
	 * @parem time 
	 * När ett nytt Arrivalobjekt skapas så får den en tid, läggs till i EvenQueue, döper eventet till Arrival och lägger till en ny kund.
	 */
	
	
	//När ett nytt Arrivalobjekt skapas så får den en tid, läggs till i EvenQueue, döps till Arrival och lägger till en ny kund.
	public Arrivals(StoreState s, ExponentialRandomStream getTime) {
		this.storeState=s;
		this.exponentialRandomStream = getTime;
		this.setTime(this.exponentialRandomStream.next() + storeState.getTime());
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("Arrivals");
		this.customer = new Customer();
		eventQueue.addEvent(this);
	}
	
	/**
	 * 
	 */
	//Uppdaterar storestate, tittar om affären är full, sätter en tid och planerar en ny Arrival när exprandomstream tycker att det är dags.
	public void perform () {
		storeState.updateStore(this, customer);
		storeState.setTime(this.getEventFinishTime());
		if (this.storeState.getOpenState()){
			if (!storeState.isStoreFull()){
				new PickGoods(customer, storeState);
				}
			new Arrivals(storeState,exponentialRandomStream);
<<<<<<< HEAD
		}
	}
=======
			}
		}
>>>>>>> f8d2bd0ad9e1d40a28a036a737548ee589818460
}
