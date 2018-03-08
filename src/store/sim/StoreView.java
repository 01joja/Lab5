package store.sim;

import java.util.Observable;

import deds.EventQueue;
import deds.SimView;
import java.util.Arrays;

public class StoreView extends SimView {
	private StoreState theStateStore;
	EventQueue eventQueue;
	private double whenLastRealEventHappend;
	

	/**
	 * printar ut mallen f�r simulationen
	 * 
	 */
	public StoreView(StoreState theStateStore) {
		super(theStateStore);
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
	
	/**
	 * Printar ut alla händelser varje gång StoreState uppdateras.
	 */
	public void update(Observable o, Object arg) {
		double starttid = theStateStore.getTime();

		String event = theStateStore.getCurrentEvent();
		String customerID = Integer.toString(theStateStore.getCurrentCustomer());
		if (event.equals("Close   ")) {
			customerID = "-";
		}
		int led = theStateStore.emptyRegisters();
		double ledT = theStateStore.getTimeRegistersNotUsed();
		int i = theStateStore.customersInStore();
		String openOrNot = theStateStore.isStoreOpenString();
		int customersPayed = theStateStore.getPaid();
		int sad = theStateStore.getSad();
		int customerQueued = theStateStore.getCustumersQueued();
		double queuedTime = theStateStore.getQueueTime();
		int currentlyQueueing = theStateStore.getCurrentlyQueuing();
		int[] currentlyInQueue = theStateStore.getQueue();

		
		if ( this.theStateStore.getCurrentEvent().equals("STOP"))
		{
			results();
		}else {
			System.out.printf("%3.2f", starttid);
			System.out.print("\t" + event + "\t" + customerID + "\t" + openOrNot + "\t" + led + "\t");
			System.out.printf("%3.2f", ledT);
			System.out.print("\t" + i + "\t" + customersPayed + "\t" + sad + "\t" + customerQueued + "\t");
			System.out.printf("%3.2f", queuedTime);
			System.out.print("\t" + currentlyQueueing + " \t " + Arrays.toString(currentlyInQueue) + "\n");
			if (theStateStore.getCurrentEvent().equals("Pay      ")) {
				this.whenLastRealEventHappend = this.theStateStore.getTime();
			}
		}

	}
	
	/**
	 * När Stop körs så skriver den ut en sammanfattning av körningen.
	 */
	public void results() {
		System.out.printf("%3.2f", theStateStore.getTime());
		System.out.print("\tSTOP \n");
		double averageCashiertime = theStateStore.getTimeRegistersNotUsed() / this.theStateStore.getRegisters();
		double averageQueueTime = theStateStore.getQueueTime() / theStateStore.getCustumersQueued();
		double percentOpenTime = averageCashiertime / this.whenLastRealEventHappend;
		System.out.print("\nRESULTAT\n========\n\n");
		System.out.print("1) Av " + (theStateStore.getPaid() + theStateStore.getSad()) + " kunder handlade "
				+ theStateStore.getPaid() + " medan " + theStateStore.getSad() + " missades.\n\n");
		System.out.print("2) Total tid 2 kassor har varit lediga: ");
		System.out.printf("%3.2f", theStateStore.getTimeRegistersNotUsed());
		System.out.print(" te.\n   Genomsnittlig ledig kassatid: ");
		System.out.printf("%3.2f", averageCashiertime);
		System.out.print(" te (dvs ");
		System.out.printf("%3.2f", percentOpenTime*100);
		System.out.print(" % av tiden fron oppning tills sista kunden betalat\n\n");
		System.out.print("3) Total tid " + theStateStore.getCustumersQueued() + " kunder tvingats koa: ");
		System.out.printf("%3.2f", theStateStore.getQueueTime());
		System.out.print(" te.\n   Genomsnittlig kotid: ");

		System.out.printf("%3.2f", averageQueueTime);
		System.out.print(" te.");

	}

}
