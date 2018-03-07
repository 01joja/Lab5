package store.events;

import deds.Event;
import store.sim.StoreState;

public class Close extends Event {
	
	StoreState storeState;
	
	Close(double timeToClose, StoreState storeState){
		//ändrar så att det är dags att stänga butiken
		super.setTime(timeToClose);
		//uppdaterar förändringar i storstate
		this.storeState = storeState;
	}
	
	void preform(){
		//stänger butiken
		this.storeState.closeStore();
	}
	
	
}
