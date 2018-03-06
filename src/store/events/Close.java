package store.events;

import deds.Event;
import store.sim.StoreState;

public class Close extends Event {
	
	StoreState storeState;
	
	Close(double timeToClose, StoreState storeState){
		super.setTime(timeToClose);
		this.storeState = storeState;
	}
	
	void preform(){
		this.storeState.closeStore();
	}
	
	
}
