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
		this.setNameOfEvent("Close   ");
		this.eventQueue.addEvent(this);
	}
	
	/*
	 *Den sätter en tid, uppdaterar lget i affären och stänger affären. 
	 */
	public void perform(){
		this.storeState.setTime(this.getEventFinishTime());
		this.storeState.updateStore(this);
		this.storeState.closeStore();


		
	}
}
