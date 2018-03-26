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
import store.sim.Customer;
import store.sim.FIFORegistersAndQueue;
import store.sim.StoreState;

public class Pay extends Event {
	
	private FIFORegistersAndQueue payQueue;
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
	private double timeTaken;
	
	/**
	 * 
	 * @param customer Skickas med som skapades under Arrival
	 * @param storeState Skickar värden till StoreState som håller i allt.
	 * Lägger till eventet i eventQueue, sätter namnet på eventet till pay.
	 */
	Pay(Customer customer, StoreState storeState) {
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
		timeTaken = ((double)this.storeState.getPayRandom().next());
//		System.out.println(timeTaken);
		this.setTime(this.storeState.getTime() + timeTaken);
		this.customer = customer;
		super.setNameOfEvent("Pay      ");
		this.payQueue = this.storeState.getFIFO();
		this.eventQueue.addEvent(this);
	}
	
	/**
	 * Sätter en sluttid, kund som skapades i arrival följer med hit, om det är kö så ställs den i kö genom fifo
	 * när det är kundens tid så tas den bort från kön och flyttas till kassorna där den skannar varor.
	 * När det har betalt så blir en kassa ledig och personen lämnar affären.
	 */
	public void perform() {
		
			this.storeState.setTime(getEventFinishTime());
			this.storeState.updateStore(this, customer);
			if (payQueue.hasPaid()){
				new Pay(this.payQueue.getFirstQueue(), storeState);
			}else{
				payQueue.removeOneInRegister();
			}
			this.storeState.removeCustomer();
			this.storeState.addPay();
		
	}
}

