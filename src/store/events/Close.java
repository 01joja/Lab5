package store.events;

import deds.Event;
import store.sim.StoreState;
import deds.EventQueue;

public class Close extends Event {
	
	StoreState storeState;
	EventQueue eventQueue;
	
	/**
	 * 
	 * @param timeToClose Tiden då affären stänger.
	 * @param storeState Skickas till StoreState då den håller i allt.
	 * Klassen som stänger affären.
	 */
	Close(double timeToClose, StoreState storeState){
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
		this.setTime(timeToClose);
<<<<<<< HEAD
		this.setNameOfEvent("Close   ");
//		System.out.print("\nClose\n");
=======
		this.setNameOfEvent("Close");
>>>>>>> 32b7f0ec38fbfc5d2a572d673313db896447c545
		this.eventQueue.addEvent(this);
	}
	
	public void perform(){
		this.storeState.setTime(this.getEventFinishTime());
		this.storeState.closeStore();
<<<<<<< HEAD
//		System.out.print("\nClose\n");
=======
>>>>>>> 32b7f0ec38fbfc5d2a572d673313db896447c545
		this.storeState.updateStore(this);
	}
}
