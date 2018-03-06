package store.sim;

import java.util.Observable;
import deds.SimView;
import store.sim.StoreAdmin;

public class StoreView extends SimView {
       private  StoreState theStateStore;
       private Customer theCustomer;
       private int tempCust = theCustomer.getCustomerID();
       
       
		private int led = theStateStore.emptyRegisters();
		private double ledT = theStateStore.getTimeRegistersNotUsed();
		private int i = theStateStore.customersInStore();
		private int customersPayed = theStateStore.getPaid();
		private int sad = theStateStore.getSad();
		private int köat = theStateStore.getCustumersQueued();
		private double köT = theStateStore.getQueueTime();
		private int köar = theStateStore.getCurrentlyQueuing();
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
		System.out.println(tempCust  + "\t" + led + "\t"+ ledT + "\t" + "\t" + i + "\t" + customersPayed + "\t" +sad + "\t" +köat +"\t" + köT + "\t" +köar);

		
	}
	
	
}
