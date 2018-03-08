package store.sim;

import java.util.Observable;
import deds.SimView;
import java.util.Arrays;

public class StoreView extends SimView {
	private StoreState theStateStore;
	private double ledT = 0;
	private double queuedTime = 0;
	private double lastStretch = 0;

	/**
	 * printar ut mallen f�r simulationen
	 * 
	 * @param theStateStore
	 */
	public StoreView(StoreState theStateStore) {
		stateOfStore(theStateStore);
		this.theStateStore.addObserver(this);
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor, N..........: " + theStateStore.getRegisters());
		System.out.println("Max som ryms, M..........: " + theStateStore.getMaxCustomers());
		System.out.println("Ankomsthastighet, lambda..:" + theStateStore.getLAMBDA());
		System.out.println(
				"Plocktider, [P_min..Pmax]: " + "[" + theStateStore.getP_MIN() + ".." + theStateStore.getP_MAX() + "]");
		System.out.println(
				"Betaltider, [K_min..Kmax]: " + "[" + theStateStore.getK_MIN() + ".." + theStateStore.getK_MAX() + "]");
		System.out.println("Frot, f..................: " + this.theStateStore.getSeed());
		System.out.println("FORLOPP");
		System.out.println("=======");
		System.out.println("Tid\tHandelse\tKund\t?\tled\tledT\tKunder\t$\t:-(\tkoat\tkoT\tkoar\t[Kassako..]\n");

	}

	public void stateOfStore(StoreState theStateStore) {
		this.theStateStore = theStateStore;
	}

	public void update(Observable o, Object arg) {
		double starttid = theStateStore.getTime();

		String event = theStateStore.getCurrentEvent();
		String customerID = Integer.toString(theStateStore.getCurrentCustomer());
		if (event.equals("Close   ")) {
			customerID = "-";
		}
		if (theStateStore.getTime() <= 999) {
			lastStretch = theStateStore.getTime();
		}
		int led = theStateStore.emptyRegisters();
		ledT = theStateStore.getTimeRegistersNotUsed() + ledT + lastStretch;
		int i = theStateStore.customersInStore();
		String openOrNot = theStateStore.isStoreOpenString();
		int customersPayed = theStateStore.getPaid();
		int sad = theStateStore.getSad();
		int customerQueued = theStateStore.getCustumersQueued();
		queuedTime = theStateStore.getQueueTime() + queuedTime;
		int currentlyQueueing = theStateStore.getCurrentlyQueuing();
		int[] currentlyInQueue = theStateStore.getQueue();

		System.out.printf("%3.2f", starttid);
		System.out.print("\t" + event + "\t" + customerID + "\t" + openOrNot + "\t" + led + "\t");
		System.out.printf("%3.2f", ledT);
		System.out.print("\t" + i + "\t" + customersPayed + "\t" + sad + "\t" + customerQueued + "\t");
		System.out.printf("%3.2f", queuedTime);
		System.out.print("\t" + currentlyQueueing + " \t " + Arrays.toString(currentlyInQueue) + "\n");

	}

	public void results() {
		System.out.printf("%3.2f", theStateStore.getTime());
		System.out.print("\tSTOP \n");
		double averageCashiertime = ledT / 2;
		double averageQueueTime = queuedTime / theStateStore.getCustumersQueued();
		double percentOpenTime = theStateStore.getOpenTime() / averageQueueTime;
		System.out.print("\nRESULTAT\n========\n\n");
		System.out.print("1) Av " + (theStateStore.getPaid() + theStateStore.getSad()) + " kunder handlade "
				+ theStateStore.getPaid() + " medan " + theStateStore.getSad() + " missades.\n\n");
		System.out.print("2) Total tid 2 kassor har varit lediga: ");
		System.out.printf("%3.2f", ledT);
		System.out.print(" te.\n   Genomsnittlig ledig kassatid: ");
		System.out.printf("%3.2f", averageCashiertime);
		System.out.print(" te (dvs ");
		System.out.printf("%3.2f", percentOpenTime);
		System.out.print(" % av tiden fr�n �ppning tills sista kunden betalat\n\n");
		System.out.print("3) Total tid " + theStateStore.getCustumersQueued() + " kunder tvingats k�a: ");
		System.out.printf("%3.2f", queuedTime);
		System.out.print(" te.\n   Genomsnittlig k�tid: ");

		System.out.printf("%3.2f", averageQueueTime);
		System.out.print(" te.");

	}

}
