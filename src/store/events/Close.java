package store.events;

import deds.Event;
import store.sim.StoreState;

public class Close extends Event {
	
	StoreState storeState;
	
	/**
	 * 
	 * @param timeToClose Tiden då affären stänger.
	 * @param storeState Skickas till StoreState då den håller i allt.
	 * Klassen som stänger affären.
	 */
	Close(double timeToClose, StoreState storeState){
		super.setTime(timeToClose);
		this.storeState = storeState;
	}
	
	void preform(){
		this.storeState.closeStore();
	}
	
	
}
