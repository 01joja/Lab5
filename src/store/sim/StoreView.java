package store.sim;

import java.util.Observable;
import deds.SimView;
import java.util.Arrays;

public class StoreView extends SimView {
	private StoreState theStateStore;
	private double ledT = 0;
	private double queuedTime = 0;
/**
 * printar ut mallen fï¿½r simulationen 
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
		System.out.println("Plocktider, [P_min..Pmax]: " + "[" + theStateStore.getP_MIN() +".." +  theStateStore.getP_MAX() + "]");
		System.out.println("Betaltider, [K_min..Kmax]: " + "[" + theStateStore.getK_MIN() +".." +  theStateStore.getK_MAX() + "]");
		System.out.println("Frï¿½t, f..................: " + this.theStateStore.getSeed());
		System.out.println("Fï¿½RLOPP");
		System.out.println("=======");
<<<<<<< HEAD
		System.out.println("Tid\tHï¿½ndelse\tKund\t?\tled\tledT\tKunder\t$\t:-(\tkï¿½at\tkï¿½T\tkï¿½ar\t[Kassakï¿½..]");
		System.out.println("0,00\tStart\n");
=======
		System.out.println("Tid\tHändelse\tKund\t?\tled\tledT\tKunder\t$\t:-(\tköat\tköT\tköar\t[Kassakö..]\n");
		//System.out.println("0,00\tStart\n");
>>>>>>> 32b7f0ec38fbfc5d2a572d673313db896447c545

	}

	public void stateOfStore(StoreState theStateStore) {
		this.theStateStore = theStateStore;
	}

	public void update(Observable o, Object arg) {
		double starttid = theStateStore.getTime();

		String event = theStateStore.getCurrentEvent();
		String customerID = Integer.toString(theStateStore.getCurrentCustomer());
<<<<<<< HEAD
		if (theStateStore.isStoreOpenString().equals("Close")) {
			customerID = "---";
=======
		if (event.equals("Close")) {
			customerID = "-";
		}else if (event.equals("Open")) {
			customerID = "-";
>>>>>>> 32b7f0ec38fbfc5d2a572d673313db896447c545
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
		//String currentCashiersQueue = Arrays.toString(cashiersQueue);
		System.out.printf("%3.2f", starttid);
		System.out.print("\t" + event + "\t" + customerID + "\t"+ openOrNot + "\t" + led + "\t" + ledT + "\t" + i + "\t"
				+ customersPayed + "\t" + sad + "\t" + customerQueued + "\t" + +currentlyQueueing + "\t" + queuedTime
				+ " \t " + cashiersQueue + "\n");

	}

	public void results() {
		double averageCashiertime = ledT / 2;
		double averageQueueTime = queuedTime / theStateStore.getCustumersQueued()  ;
		double percentOpenTime = theStateStore.getOpenTime() / averageQueueTime;
		System.out.print("\nRESULTAT\n========\n\n");
		System.out.print("1) Av "+ theStateStore.getMaxCustomers() + " kunder handlade " + theStateStore.getPaid() +" medan " + theStateStore.getSad() + " missades.\n\n");
		System.out.print("2) Total tid 2 kassor har varit lediga: " );
		System.out.printf("%3.2f", ledT);
		System.out.print(" te.\n   Genomsnittlig ledig kassatid: " + averageCashiertime + " te (dvs ");
		System.out.printf("%3.2f", percentOpenTime);
		System.out.print(" % av tiden frï¿½n ï¿½ppning tills sista kunden betalat\n\n" );
		System.out.print("3) Total tid "+ theStateStore.getCustumersQueued() +" kunder tvingats kï¿½a: " + queuedTime +" te.\n   Genomsnittlig kï¿½tid: ");
		
		System.out.printf("%3.2f",averageQueueTime);
		System.out.print(" te." );
		
	}

}
