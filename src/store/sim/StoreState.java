/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

package store.sim;

import deds.EventQueue;
import deds.Event;
import deds.SimState;
import store.events.*;
import store.sim.*;
import java.util.ArrayList;

public class StoreState extends SimState {

	private final double LAMBDA;
	private final double P_MIN;
	private final double P_MAX;
	private final double K_MIN;
	private final double K_MAX;
	private final double START;
	private final boolean HASSEED;
	private final long SEED;

	private final int MAXCOSTUMER;
	private final int REGISTERS;
	private double queuedTime = 0;
	private double timeRegistersNotUsed = 0;
	private int paid = 0;
	private int sad = 0;
	private int currentlyQueuing = 0;
	private int customersQueued = 0;
	private int emptyRegisters = 0;
	private int customersInStore = 0;
	private int totalNumberOfCustomers = 0;
	private ArrayList<Integer> queue = new ArrayList<Integer>();
	private String currentEvent;
	private int currentCustomer;
	private boolean storeIsOpen = false;
	private double OpenTime;

	private FIFORegistersAndQueue fifo;
	private ExponentialRandomStream arrivalRandom;
	private UniformRandomStream pickGoodsRandom;
	private UniformRandomStream payRandom;

	/**
	 * 
	 * Sätter alla variabler och pekar rätt alla pointer.
	 * 
	 * @param maxCustomers Max antal kunder som får vara i butiken
	 * @param registers antal kassor som används i butiken
	 * @param timeStoreIsOpen tiden butiken är öppen
	 * @param lambda intervallet som det anländer kunder i
	 * @param p_min minsta tiden det får ta att plocka varor
	 * @param p_max längsta tiden det får ta att plocka varor
	 * @param k_min minsta tiden det tar att betala i kassan
	 * @param k_max längsta tiden det tar att betala i kassan
	 * @param start bestämmer vilken tid programmet startar
	 * @param seed bestämmer vilken seed som SimState ska utgå ifrån
	 */
	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen, double lambda, double p_min,
			double p_max, double k_min, double k_max, double start, long seed) {
		this.LAMBDA = lambda;
		this.P_MIN = p_min;
		this.P_MAX = p_max;
		this.K_MIN = k_min;
		this.K_MAX = k_max;
		this.START = start;
		this.HASSEED = true;
		this.SEED = seed;
		this.arrivalRandom = new ExponentialRandomStream(LAMBDA, this.SEED);
		this.pickGoodsRandom = new UniformRandomStream(P_MIN, P_MAX, this.SEED);
		this.payRandom = new UniformRandomStream(K_MIN, K_MAX, this.SEED);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
		super.setEventQueue(new EventQueue());
		fifo = new FIFORegistersAndQueue(this);
		new Open(this.START, timeStoreIsOpen, 999, this);
		this.OpenTime = timeStoreIsOpen;
		this.emptyRegisters = registers;
		new Arrivals(this, arrivalRandom);
	}
	
	
	/**
	 * 
	 * Om detta är sista eventet med andra ord eventet stopp så ändras namnet på currentEvent till "STOP".
	 * 
	 * @return stopflaggan.
	 */
	public boolean getRunSim(){
		boolean flag = super.getRunSim();
		if (flag == false) {
			this.currentEvent="STOP";
			setChanged();
			notifyObservers();
		}
		return flag;
	}

	/**
	 * 
	 * Uppdaterar alla som observerar detta event och ändrar vilket event som är currentEvent
	 * 
	 * @param e hämtar namnet på Event e och sätter currentEvent till det.
	 */
	public void updateStore(Event e) {
		this.currentEvent = e.getNameOfEvent();
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * Denna ska köras om eventet har en Customer. Uppdaterar alla som observerar detta event och ändrar vilket event som är currentEvent.
	 * 
	 * @param e hämtar namnet på Event e och sätter currentEvent till det.
	 * @param c hämtar CustomerID från c och currentCustomer till det.
	 */
	public void updateStore(Event e, Customer c) {
		this.currentEvent = e.getNameOfEvent();
		this.currentCustomer = c.getCustomerID();
		setChanged();
		notifyObservers();
	}
	
	
	
	@Override
	/**
	 * Override setTime för kunna spara tiden från allt köande och all tid som kassorna är tomma.
	 * 
	 * @param tar imot den tid då eventet händer
	 */
	public void setTime(double time){
		double timePassed = time - super.getTime();
		if ((this.storeIsOpen) || (fifo.getRegisterWhithCoustomers()!=0)) {
			this.emptyRegisters = this.REGISTERS-this.fifo.getRegisterWhithCoustomers();
			this.timeRegistersNotUsed = this.timeRegistersNotUsed + timePassed*this.emptyRegisters;
		}
		this.queuedTime= this.queuedTime + timePassed*fifo.getSize();
		super.setTime(time);
	}
	
	/**
	 * tar bort en costumer i butiken
	 */
	public void removeCustomer(){
		this.customersInStore--;
	}
	
	/**
	 * lägger till en Costumer i butiken.
	 */
	public void addCustomerID() {
		totalNumberOfCustomers ++;
	}
	
	/**
	 * 
	 * returnerar totala antalet Customer som har varit i affären
	 * 
	 * @return totalNumberOfCustomer
	 */
	public int getNumberOfCustomers() {
		return totalNumberOfCustomers;
	}

	/**
	 * 
	 * returnarar en tid som det ska ta att betala
	 * 
	 * @return en random tid
	 */
	public UniformRandomStream getPayRandom() {
		return this.payRandom;
	}

	/**
	 * 
	 * returnarar en tid som det ska ta att plocka varor
	 * 
	 * @return en random tid
	 */
	public UniformRandomStream getPickGoodsRandom() {
		return this.pickGoodsRandom;
	}

	/**
	 * 
	 * rerurnerar det som specificeras.
	 * 
	 * @return currentEvent
	 */
	public String getCurrentEvent() {
		return this.currentEvent;
	}

	/**
	 * 
	 * rerurnerar det som specificeras.
	 * 
	 * @return currentCustomer
	 */
	public int getCurrentCustomer() {
		return this.currentCustomer;
	}

	/**
	 *
	 * rerurnerar det som specificeras.
	 * 
	 * @returnerar nästa event i eventQueue
	 */
	public EventQueue getEventQueue() {
		return super.getEventQueue();
	}

	/**
	 * Ökar antalet som har betalt med 1
	 */
	public void addPay() {
		paid++;
	}

	/**
	 * 
	 * returnerar hur många som har betalt
	 * 
	 * @return int paid
	 */
	public int getPaid() {
		return paid;
	}

	/**
	 * 
	 * @return antalet kunder i affären
	 */
	public int customersInStore() {
		return this.customersInStore;
	}

	/**
	 * 
	 * @return Max antal kunder
	 */
	public int getMaxCustomers() {
		return this.MAXCOSTUMER;
	}

	/**
	 * 
	 * @return Max antal kassor som kan användas
	 */
	public int getRegisters() {
		return this.REGISTERS;
	}

	/**
	 * 
	 * @return tiden som kassorna inte har används
	 */
	public double getTimeRegistersNotUsed() {
		return this.timeRegistersNotUsed;
	}

	/**
	 * 
	 * @return antal kunder som inte fick gå in i butiken
	 */
	public int getSad() {
		return this.sad;
	}

	/**
	 * 
	 * @return antalet kunder som har köat
	 */
	public int getCustumersQueued() {
		return this.customersQueued;
	}
	
	/**
	 * ökar antalet som har köat med 1
	 */
	public void addCustumersQueued(){
		this.customersQueued++;
	}

	/**
	 * 
	 * @return antalet som köar
	 */
	public int getCurrentlyQueuing() {
		return this.currentlyQueuing;
	}
	
	/**
	 * 
	 * bestämmer längden på kön
	 * 
	 * @param c längden på kön
	 */
	public void setCurrentlyQueuing(int c){
		this.currentlyQueuing = c;
	}

	/**
	 * 
	 * @return en array med vilka cutomers som står i kön
	 */
	public int[] getQueue() {
		Customer[] customer = fifo.getQueue();
		int[] temp = new int[customer.length];
		for (int i = 0; i < customer.length; i++){
			temp[i] = customer[i].getCustomerID();
		}
		return temp;
	}

	/**
	 * 
	 * @return starttiden
	 */
	public double getStart() {
		return this.START;
	}

	/**
	 * 
	 * @return antalet lediga kassor
	 */
	public int emptyRegisters() {
		return this.emptyRegisters;
	}
	
	/**
	 * kollar om det finns lediga kassor. gör det det så minskas antalet lediga kassor med en eftersom en kund ska ta den.
	 * 
	 * @return true om det finns lediga kassor annars blir det false
	 */
	public boolean isRegisterEmpty() {
		if (this.emptyRegisters == 0) {
			return false;
		} else {
			emptyRegisters--;
			return true;
		}

	}

	/**
	 * 
	 * @return den tid som custumers har stått i kön sammanlagt
	 */
	public double getQueueTime() {
		return this.queuedTime;
	}

	/**
	 * 
	 * @return kollar om fifo har en kö
	 */
	public boolean isFIFOempty() {
		if (fifo.hasQueue()){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * Om affären är full så ökar antalet ledsna kunder, annars läggs det till en kund i affären.
	 * 
	 * @return true om affären är full annars returnaras false
	 */
	public boolean isStoreFull() {
		if (this.customersInStore == this.MAXCOSTUMER) {
			if (this.storeIsOpen) {
				this.sad++;
			}
			return true;
		} else {
			this.customersInStore++;
			return false;
		}
	}

	/**
	 * sätter storeIsOpen till true
	 */
	public void openStore() {
		storeIsOpen = true;
	}

	/**
	 * sätter storeIsOpen till false
	 */
	public void closeStore() {
		storeIsOpen = false;
	}

	/**
	 * 
	 * @return storeIsOpen
	 */
	public boolean getOpenState() {
		return this.storeIsOpen;
	}

	/**
	 * 
	 * @return Ö om affären är öppen annars S
	 */
	public String isStoreOpenString() {
		if (this.storeIsOpen) {
			return "Ö";
		}
		return "S";
	}

	/**
	 * 
	 * @return fifon
	 */
	public FIFORegistersAndQueue getFIFO() {
		return fifo;
	}

	
	/**
	 * 
	 * @return P_MIN
	 */
	public double getP_MIN() {
		return this.P_MIN;
	}

	/**
	 * 
	 * @return P_MAX
	 */
	public double getP_MAX() {
		return this.P_MAX;
	}

	/**
	 * 
	 * @return K_MIN
	 */
	public double getK_MIN() {
		return this.K_MIN;
	}

	/**
	 * 
	 * @return K_MAX
	 */
	public double getK_MAX() {
		return this.K_MAX;
	}

	/**
	 * 
	 * @return SEEDEN som har använts
	 */
	public long getSeed() {
		return this.SEED;
	}

	/**
	 * 
	 * @return Affärens öppettid
	 */
	public double getOpenTime() {
		return this.OpenTime;
	}

	/**
	 * 
	 * @param time sätter tiden affären är öppen
	 */
	public void setOpenTime(double time) {
		this.OpenTime = time;
	}

	/**
	 * 
	 * @return LAMBDA värdet
	 */
	public double getLAMBDA() {
		return this.LAMBDA;
	}
}
