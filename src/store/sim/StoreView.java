package store.sim;

import java.util.Observable;
import deds.SimView;
import store.sim.StoreAdmin;

public class StoreView extends SimView {
       private  StoreState theStateStore;
       private StoreAdmin theStateAdmin;
       public StoreView(StoreState theStateStore) {
    	   stateOfStore(theStateStore);
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
		System.out.println(String.format("Antal kassor, N..........: ",theStateAdmin.registers()));
		System.out.println(String.format("Max som ryms, M..........: ",	theStateAdmin.maxCustomers()));
		System.out.println(String.format("Plocktider, [P_min..Pmax]:", theStateStore.customersInStore() ));
		System.out.println(String.format("Betaltider, [K_min..Kmax]:", theStateStore.customersInStore() ));
		System.out.println(String.format("FrÃ¶, f...................:", theStateStore.customersInStore() ));
		System.out.println(String.format("costumers in store:", theStateStore.queuedTime(null) ));
		
	}
}
