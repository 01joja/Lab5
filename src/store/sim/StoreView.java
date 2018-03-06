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
   		System.out.println(String.format("FrÃ¶, f...................:", theStateStore.customersInStore() ));
   		System.out.println("FÃƒâ€“RLOPP");
   		System.out.println("=======");
   		System.out.println("Tid HÃ¤ndelse  Kund  ?  led    ledT    I     $    :-(   kÃ¶at    kÃ¶   kÃ¶ar  [KassakÃ¶..]");
   		System.out.println("0,00 Start");
   		
   		//System.out.println(String.format("costumers in store:", theStateStore.queuedTime() ));
       }

	public void stateOfStore(StoreState theStateStore) {
		this.theStateStore = theStateStore;
	}
    
	public void update(Observable o, Object arg) {
		  int tempCustomer = theStateStore.getCurrentCustomer();
	       String händelse = theStateStore.getCurrentEvent();
	       
			 int led = theStateStore.emptyRegisters();
			 double ledT = theStateStore.getTimeRegistersNotUsed();
			 int i = theStateStore.customersInStore();
			 int customersPayed = theStateStore.getPaid();
			 int sad = theStateStore.getSad();
			 int köat = theStateStore.getCustumersQueued();
			 double köT = theStateStore.getQueueTime();
			 int köar = theStateStore.getCurrentlyQueuing();
		System.out.println("time" + "\t" + händelse + "\t" + tempCustomer  + "\t" + theStateStore + "\t"+ ledT + "\t" + led + "\t" + i + "\t" + customersPayed + "\t" +sad + "\t" +köat +"\t" + köT + "\t" +köar);

		
	}
	
	
}
