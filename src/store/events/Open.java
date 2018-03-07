package store.events;

import deds.EventStart;
import deds.EventQueue;
import store.sim.*;
import store.events.*;

public class Open extends EventStart {
	
	private double closeTime;
	private StoreState storeState;
	private EventQueue eventQueue;
	
	public Open(double openTime, double closeTime, double simStopTime, StoreState storeState){
		super(simStopTime, storeState);
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
		this.setTime(openTime);
		this.setNameOfEvent("Open");
		this.closeTime = closeTime;
		this.eventQueue.addEvent(this);
	}
	
	public void perform(){
		this.storeState.openStore();
		this.storeState.updateStore(this);
		new Close(closeTime, storeState);
	}
}

