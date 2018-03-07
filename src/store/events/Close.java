package store.events;

import deds.Event;
import store.sim.StoreState;
import deds.EventQueue;

public class Close extends Event {
	
	StoreState storeState;
	EventQueue eventQueue;
	
	Close(double timeToClose, StoreState storeState){
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
		this.setTime(timeToClose);
		this.setNameOfEvent("Close");
		this.eventQueue.addEvent(this);
	}
	
	public void perform(){
		this.storeState.setTime(this.getEventFinishTime());
		this.storeState.closeStore();
		this.storeState.updateStore(this);
	}
}
