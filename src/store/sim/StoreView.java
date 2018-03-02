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
		System.out.println(String.format("Registerss: ",theStateAdmin.registers()));
		System.out.println(String.format("Max costumers: ",	theStateAdmin.maxCustomers()));
		System.out.println(String.format("addign costumer:", theStateStore.customersInStore() ));
	}
}
