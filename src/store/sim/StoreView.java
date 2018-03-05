package store.sim;

import java.util.Observable;
import deds.SimView;
import store.sim.StoreAdmin;

public class StoreView extends SimView {
       private  StoreState theStateStore;
       private StoreAdmin theStateAdmin;
       public StoreView(StoreState theStateStore) {
    	   stateOfStore(theStateStore);
   		System.out.println("PARAMETRAR");
   		System.out.println("==========");
   		System.out.println(String.format("Antal kassor, N..........: ",theStateAdmin.getRegisters()));
   		System.out.println(String.format("Max som ryms, M..........: ",	theStateAdmin.getMaxCustomers()));
   		System.out.println(String.format("Plocktider, [P_min..Pmax]:", theStateStore.customersInStore() ));
   		System.out.println(String.format("Betaltider, [K_min..Kmax]:", theStateStore.customersInStore() ));
   		System.out.println(String.format("Frö, f...................:", theStateStore.customersInStore() ));
   		System.out.println("FÃ–RLOPP");
   		System.out.println("=======");
   		System.out.println("Tid Händelse  Kund  ?  led    ledT    I     $    :-(   köat    kö   köar  [Kassakö..]");
   		System.out.println(String.format("costumers in store:", theStateStore.queuedTime(null) ));
       }

	public void stateOfStore(StoreState theStateStore) {
		this.theStateStore = theStateStore;
	}
    public void StoreTheAdmin(StoreAdmin theStateAdmin) {
    	StoreTheAdmin(theStateAdmin);
    }


	public void stateOfStoreAdmin(StoreAdmin theStateAdmin) {
		this.theStateAdmin = theStateAdmin;
	}
	public void update(Observable o, Object arg) {

		
	}
}
