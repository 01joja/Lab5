package store.sim;

import deds.EventQueue;
import deds.Event;
import deds.SimState;
import store.events.*;
import store.sim.*;
import java.util.ArrayList;

public class StoreState extends SimState {

	/*
	 * Olika typer av variabler som används under körningen.
	 */
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
	 * @param maxCustomers
	 *            Antalet kunder som max får vara i butiken samtidigt.
	 * @param registers
	 *            Antalet öppna kassor.
	 * @param timeStoreIsOpen
	 *            Tiden affären är öppen.
	 * @param seed
	 *            Är tiden hur ofta kunder kommer till affären.
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
	
	@Override
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
	 * @param e
	 *            Skickar med Event klassen för att uppdatera affären.
	 */
	public void updateStore(Event e) {
		this.currentEvent = e.getNameOfEvent();
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * @param e
	 *            Skickar med Event klassen för att uppdatera affären.
	 * @param c
	 *            Skickar med Customer klassen för att uppdatera affären.
	 */
	public void updateStore(Event e, Customer c) {
		this.currentEvent = e.getNameOfEvent();
		this.currentCustomer = c.getCustomerID();
		setChanged();
		notifyObservers();
	}
	
	
	/**
	 * Overrides SimState settime to make sure that the time for time queued and time registers not used are correct
	 */
	@Override
	public void setTime(double time){
		double timePassed = time - super.getTime();
		if ((this.storeIsOpen) || (fifo.getRegisterWhithCoustomers()!=0)) {
			this.emptyRegisters = this.REGISTERS-this.fifo.getRegisterWhithCoustomers();
			this.timeRegistersNotUsed = this.timeRegistersNotUsed + timePassed*this.emptyRegisters;
		}
		this.queuedTime= this.queuedTime + timePassed*fifo.getSize();
		super.setTime(time);
	}
	
	public void removeCustomer(){
		this.customersInStore--;
	}

	public UniformRandomStream getPayRandom() {
		return this.payRandom;
	}

	public UniformRandomStream getPickGoodsRandom() {
		return this.pickGoodsRandom;
	}

	// Skickar tillbaka det som specificeras.
	public String getCurrentEvent() {
		return this.currentEvent;
	}

	// Skickar tillbaka det som specificeras.
	public int getCurrentCustomer() {
		return this.currentCustomer;
	}

	// Skickar tillbaka det som specificeras.
	public EventQueue getEventQueue() {
		return super.getEventQueue();
	}

	// Ökar kunder som betalt med 1.
	public void addPay() {
		paid++;
	}

	// Skickar tillbaka det som specificeras.
	public int getPaid() {
		return paid;
	}

	// Retunerar hur många kunder som är i affären.
	public int customersInStore() {
		return this.customersInStore;
	}

	// Skickar tillbaka det som specificeras.
	public int getMaxCustomers() {
		return this.MAXCOSTUMER;
	}

	// Skickar tillbaka det som specificeras.
	public int getRegisters() {
		return this.REGISTERS;
	}

	// Skickar tillbaka det som specificeras.
	public double getTimeRegistersNotUsed() {
		return this.timeRegistersNotUsed;
	}

	// Skickar tillbaka det som specificeras.
	public int getSad() {
		return this.sad;
	}

	// Skickar tillbaka det som specificeras.
	public int getCustumersQueued() {
		return this.fifo.totalQueued;
	}

	// Skickar tillbaka det som specificeras.
	public int getCurrentlyQueuing() {
		return this.fifo.getSize();
	}

	// Skickar tillbaka det som specificeras.
	public int[] getQueue() {
		Customer[] customer = fifo.getQueue();
		int[] temp = new int[customer.length];
		for (int i = 0; i < customer.length; i++){
			temp[i] = customer[i].getCustomerID();
		}
		return temp;
	}

	// Skickar tillbaka det som specificeras.
	public double getStart() {
		return this.START;
	}

	// Returnerar hur många kassor som är lediga.
	public int emptyRegisters() {
		return this.emptyRegisters;
	}

	// Om det inte finns någon ledig kassa returnerar den false, annars true.
	public boolean isRegisterEmpty() {
		if (this.emptyRegisters == 0) {
			return false;
		} else {
			emptyRegisters--;
			return true;
		}

	}

	// Skickar tillbaka det som specificeras.
	public double getQueueTime() {
		return this.queuedTime;
	}

	public boolean isFIFOempty() {
		if (fifo.hasQueue()){
			return false;
		}else{
			return true;
		}
	}

	// Om affären är full så ökar antalet ledsna kunder, annars läggs det till
	// en kund i affären.
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

	// Öppnar affären.
	public void openStore() {
		storeIsOpen = true;
	}

	// Stänger affären.
	public void closeStore() {
		storeIsOpen = false;
	}

	// Tittar om affären är öppen.
	public boolean getOpenState() {
		return this.storeIsOpen;
	}

	// Om affären är öppen returnerar den Ö annars S.
	public String isStoreOpenString() {
		if (this.storeIsOpen) {
			return "Ö";
		}
		return "S";
	}

	// Skickar tillbaka det som specificeras.
	public FIFORegistersAndQueue getFIFO() {
		return fifo;
	}

	// Skickar tillbaka det som specificeras.
	public double getP_MIN() {
		return this.P_MIN;
	}

	// Skickar tillbaka det som specificeras.
	public double getP_MAX() {
		return this.P_MAX;
	}

	// Skickar tillbaka det som specificeras.
	public double getK_MIN() {
		return this.K_MIN;
	}

	// Skickar tillbaka det som specificeras.
	public double getK_MAX() {
		return this.K_MAX;
	}

	// Skickar tillbaka det som specificeras.
	public long getSeed() {
		return this.SEED;
	}

	/**
	 * Returnerar aff�rens �ppningstid
	 * 
	 * @return
	 */
	public double getOpenTime() {
		return this.OpenTime;
	}

	public void setOpenTime(double time) {
		this.OpenTime = time;
	}

	public double getLAMBDA() {
		return this.LAMBDA;
	}
}
