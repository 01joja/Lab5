package store.events;

import deds.Event;
import deds.SimState;
import store.sim.StoreAdmin;
//import store.sim;


public class Arrives extends Event{
	
			
	public void perform () {
		if (store.sim.StoreState.customersInStore() == store.sim.StoreAdmin.maxCustomers()) {
			become angry.exe
		}
		
	}


}
