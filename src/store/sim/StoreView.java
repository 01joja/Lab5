package store.sim;

import java.util.Observable;
import deds.SimView;
import store.sim.StoreAdmin;

public class StoreView extends SimView {
	private StoreState theStateStore;
	private Customer theCustomer;
	private double ledT = 0;

	public StoreView(StoreState theStateStore) {
		stateOfStore(theStateStore);
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println(String.format("Antal kassor, N..........: ", theStateStore.getRegisters()));
		System.out.println(String.format("Max som ryms, M..........: ", theStateStore.getMaxCustomers()));
		System.out.println(String.format("Plocktider, [P_min..Pmax]:", theStateStore.customersInStore()));
		System.out.println(String.format("Betaltider, [K_min..Kmax]:", theStateStore.customersInStore()));
		System.out.println(String.format("Frö, f...................:", theStateStore.customersInStore()));
		System.out.println("FÃ–RLOPP");
		System.out.println("=======");
		System.out
				.println("Tid Händelse  Kund  ?  led    ledT    I     $    :-(   köat    kö   köar  [Kassakö..]");
		System.out.println("0,00 Start\n");

	}

	public void stateOfStore(StoreState theStateStore) {
		this.theStateStore = theStateStore;
	}

	public void update(Observable o, Object arg) {
		double starttid = theStateStore.getStart();

		String h�ndelse = theStateStore.getCurrentEvent();
		String tempCustomer = Integer.toString(theStateStore.getCurrentCustomer());
		if (theStateStore.getCurrentEvent().equals("Stop")) {
			tempCustomer = "---";
		}

		int led = theStateStore.emptyRegisters();
		ledT = theStateStore.getTimeRegistersNotUsed() + ledT;
		int i = theStateStore.customersInStore();
		int customersPayed = theStateStore.getPaid();
		int sad = theStateStore.getSad();
		int k�at = theStateStore.getCustumersQueued();
		double k�T = theStateStore.getQueueTime();
		int k�ar = theStateStore.getCurrentlyQueuing();
		int[] kassak� = theStateStore.getQueue();
		System.out.println(starttid + " " + h�ndelse + "\t" + tempCustomer + "  " + theStateStore + "\t" + led + "\t"
				+ ledT + "\t" + i + "\t" + customersPayed + "\t" + sad + "\t" + k�at + "\t" + k�T + "\t" + k�ar + "  "
				+ kassak�);

	}
	public void results() {
		 System.out.print("RESULTAT\n + ========");
		 int customerNotPaying = theStateStore.getMaxCustomers() - theStateStore.getPaid();
		 
	}

}
