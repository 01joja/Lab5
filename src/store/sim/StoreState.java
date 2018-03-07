package store.sim;

import deds.EventQueue;
import deds.Event;
import deds.SimState;
import store.events.*;
import store.sim.*;
import java.util.ArrayList;


public class StoreState extends SimState {
	
	private final double LAMBDA = 4;
	private final double P_MIN = 0.6;
	private final double P_MAX = 0.9;
	private final double K_MIN = 0.35;
	private final double K_MAX = 0.6;
	private final double START = 0;
	
	private final int MAXCOSTUMER;
	private final int REGISTERS;
	private double queuedTime = 0;
	private double timeRegistersNotUsed = 0;
	private int paid = 0;
	private int sad = 0;
	private int currentlyQueuing = 0;
	private int customersQueued = 0;
	private int registerQueue = 0;
	private int emptyRegisters = 0;
	private int customersInStore = 0;
	private ArrayList<Integer> queue = new ArrayList<Integer>();
	private String currentEvnet;
	private int currentCustomer;
	private boolean storeIsOpen = false;
	
	private FIFO fifo;
	private ExponentialRandomStream arrivalRandom;

	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen) { 
		super.eventQueue = new EventQueue();
		fifo = new FIFO();
		new Open(this.START, timeStoreIsOpen, 999, this);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
		arrivalRandom = new ExponentialRandomStream(LAMBDA);
		new StoreView(this);
		new Arrivals(this, arrivalRandom, 0);
	}
	
	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen, long seed) { 
		super.eventQueue = new EventQueue();
		fifo = new FIFO();
		new Open(this.START, timeStoreIsOpen, 999, this);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
		arrivalRandom = new ExponentialRandomStream(LAMBDA, seed);
		new StoreView(this);
		new Arrivals(this, arrivalRandom, 0);
	}
	
	public void updateStore(Event e){
		this.currentEvnet = e.getNameOfEvent();
		setChanged();
		notifyObservers();
	}
	
	public void updateStore(Event e , Customer c){
		this.currentEvnet = e.getNameOfEvent();
		this.currentCustomer = c.getCustomerID();
		setChanged();
		notifyObservers();
	}
	
	public String getCurrentEvent(){
		return this.currentEvnet;
	}
	
	public int getCurrentCustomer(){
		return this.currentCustomer;
	}
	
	public EventQueue getEventQueue(){
		return super.eventQueue;
	}
	
	public void addPay(){
		paid++;
	}
	
	public int getPaid(){
		return paid;
	}
	
	public int customersInStore() {
		return this.customersInStore;
	}
	
	public int getMaxCustomers(){
		return this.MAXCOSTUMER;
	}
	
	public int getRegisters(){
		return this.REGISTERS;
	}
	
	public double getTimeRegistersNotUsed(){
		return this.timeRegistersNotUsed;
	}
	
	public int getSad(){
		return this.sad;
	}
	
	public int getCustumersQueued(){
		return this.customersQueued;
	}
	
	public int getCurrentlyQueuing(){
		return this.currentlyQueuing;
	}
	
	public int[] getQueue(){
		int[] temp = new int[0];
		return temp;
	}
	
	public double getStart(){
		return this.START;
	}
	
	public int emptyRegisters(){
		return this.emptyRegisters;
	}
	
	public boolean isRegisterEmpty(){
		if (this.emptyRegisters == 0){
			return false;
		}else{
			emptyRegisters--;
			return true;
		}
		
	}
		
	public double getQueueTime() {
		if (fifo.isEmpty() == true) {
			return 0;
		}
		return 0.5;
	}
	
	public boolean isStoreFull(){
		if (this.customersInStore == this.MAXCOSTUMER){
			this.sad++;
			return true;
		}else{
			this.customersInStore++;
			return false;
		}
	}
	
	public void openStore() {
		storeIsOpen = true;
	}
	
	public void closeStore() {
		storeIsOpen = false;
	}
	
	public boolean isStoreOpen(){
		return storeIsOpen;
	}
	
	public FIFO getFIFO(){
		return fifo;
	}
}
