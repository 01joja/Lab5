package store.sim;

import java.util.Observable;
import deds.SimView;

public class StoreView extends SimView {
	private StoreState theStateStore;
	private double ledT = 0;
	private double queuedTime = 0;

	public StoreView(StoreState theStateStore) {
		stateOfStore(theStateStore);
		this.theStateStore.addObserver(this);
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor, N..........:" + theStateStore.getRegisters());
		System.out.println("Max som ryms, M..........:" + theStateStore.getMaxCustomers());
		System.out.println("Plocktider, [P_min..Pmax]:" + "[" + theStateStore.getP_MIN() +".." +  theStateStore.getP_MAX() + "]");
		System.out.println("Betaltider, [K_min..Kmax]:" + "[" + theStateStore.getK_MIN() +".." +  theStateStore.getK_MAX() + "]");
		System.out.println("Fröt, f..................:" + theStateStore.getSeed());
		System.out.println("FÖRLOPP");
		System.out.println("=======");
		System.out.println("Tid\tHändelse\tKund\t?\tled\tledT\tI\t$\t:-(\tköat\tköT\tköar\t[Kassakö..]");
		System.out.println("0,00\tStart\n");

	}

	public void stateOfStore(StoreState theStateStore) {
		this.theStateStore = theStateStore;
	}

	public void update(Observable o, Object arg) {
		double starttid = theStateStore.getTime();

		String event = theStateStore.getCurrentEvent();
		String customerID = Integer.toString(theStateStore.getCurrentCustomer());
		if (theStateStore.getCurrentEvent().equals("STOP")) {
			customerID = "---";
		}

		int led = theStateStore.emptyRegisters();
		ledT = theStateStore.getTimeRegistersNotUsed() + ledT;
		int i = theStateStore.customersInStore();
		String openOrNot = theStateStore.isStoreOpenString();
		int customersPayed = theStateStore.getPaid();
		int sad = theStateStore.getSad();
		int customerQueued = theStateStore.getCustumersQueued();
		queuedTime = theStateStore.getQueueTime() + queuedTime;
		int currentlyQueueing = theStateStore.getCurrentlyQueuing();
		int[] cashiersQueue = theStateStore.getQueue();
		System.out.printf("%3.2f", starttid);
		System.out.print("\t" + event + "\t" + customerID + "\t"+ openOrNot + "\t" + led + "\t" + ledT + "\t" + i + "\t"
				+ customersPayed + "\t" + sad + "\t" + customerQueued + "\t" + +currentlyQueueing + "\t" + queuedTime
				+ " \t " + cashiersQueue + "\n");

	}

	public void results() {
		System.out.print("RESULTAT\n + ========");
		int customerNotPaying = theStateStore.getMaxCustomers() - theStateStore.getPaid();

	}

}
