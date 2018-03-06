package store.sim;

import java.util.Observable;
import deds.SimView;
import store.sim.StoreAdmin;

public class StoreView extends SimView {
       private  StoreState theStateStore;
       private Customer theCustomer;
       public StoreView(StoreState theStateStore) {
    	   stateOfStore(theStateStore);
   		System.out.println("PARAMETRAR");
   		System.out.println("==========");
   		System.out.println(String.format("Antal kassor, N..........: ",theStateStore.getRegisters()));
   		System.out.println(String.format("Max som ryms, M..........: ",	theStateStore.getMaxCustomers()));
   		System.out.println(String.format("Plocktider, [P_min..Pmax]:", theStateStore.customersInStore() ));
   		System.out.println(String.format("Betaltider, [K_min..Kmax]:", theStateStore.customersInStore() ));
   		System.out.println(String.format("Frö, f...................:", theStateStore.customersInStore() ));
   		System.out.println("FÃ–RLOPP");
   		System.out.println("=======");
   		System.out.println("Tid Händelse  Kund  ?  led    ledT    I     $    :-(   köat    kö   köar  [Kassakö..]");
   		System.out.println("0,00 Start");
   		
   		//System.out.println(String.format("costumers in store:", theStateStore.queuedTime() ));
       }

	public void stateOfStore(StoreState theStateStore) {
		this.theStateStore = theStateStore;
	}
    
	public void update(Observable o, Object arg) {

		
	}
	public void getvariables() {
		int tempCust = theCustomer.getCustomerID();
		Boolean StoreOpen = theStateStore.isStoreOpen();
		int led = theStateStore.emptyRegisters();
		double ledT = theStateStore.getTimeRegistersNotUsed();
		int i = theStateStore.customersInStore();
		int customersPayed = theStateStore.getPaid();
		int sad = theStateStore.getSad();
		int k�at = theStateStore.getCustomersQueued();
		double k�T = theStateStore.getQueuedTime();
		int k�ar = theStateStore.getCurrentlyQueuing();
		
		
	}
	public void printCurrent() 
	{
	}
}
