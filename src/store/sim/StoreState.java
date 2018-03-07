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
	private long seed;
	
	private FIFO fifo;
	private ExponentialRandomStream arrivalRandom;
	
	
	/**
	 * @param maxCustomers Antalet kunder som max får vara i butiken samtidigt.
	 * @param registers Antalet öppna kassor
	 * @param timeStoreIsOpen Tiden affären är öppen.
	 */
	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen) { 
		arrivalRandom = new ExponentialRandomStream(LAMBDA);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
		startSequens(maxCustomers, registers, timeStoreIsOpen);
	}
	
	/**
	 * 
	 * @param maxCustomers Antalet kunder som max får vara i butiken samtidigt.
	 * @param registers Antalet öppna kassor.
	 * @param timeStoreIsOpen Tiden affären är öppen.
	 * @param seed Är tiden hur ofta kunder kommer till affären.
	 */
	public StoreState(int maxCustomers, int registers, double timeStoreIsOpen, long seed) { 
		arrivalRandom = new ExponentialRandomStream(LAMBDA, seed);
		this.REGISTERS = registers;
		this.MAXCOSTUMER = maxCustomers;
		startSequens(maxCustomers, registers, timeStoreIsOpen);
	}
	/**
	 * 
	 * @param maxCustomers Antalet kunder som max får vara i butiken samtidigt.
	 * @param registers Antalet öppna kassor.
	 * @param timeStoreIsOpen Hur länge affären är öppen.
	 */
	private void startSequens(int maxCustomers, int registers, double timeStoreIsOpen){
		super.eventQueue = new EventQueue();
		fifo = new FIFO();
		new Open(this.START, timeStoreIsOpen, 99, this);
		new StoreView(this);
		new Arrivals(this, arrivalRandom, 0);
	}
	
	/**
	 * 
	 * @param e Skickar med Event klassen för att uppdatera affären.
	 */
	public void updateStore(Event e){
		this.currentEvnet = e.getNameOfEvent();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * 
	 * @param e Skickar med Event klassen för att uppdatera affären.
	 * @param c Skickar med Customer klassen för att uppdatera affären.
	 */
	public void updateStore(Event e , Customer c){
		this.currentEvnet = e.getNameOfEvent();
		this.currentCustomer = c.getCustomerID();
		setChanged();
		notifyObservers();
	}
	
	//Skickar tillbaka det som specificeras.
	public String getCurrentEvent(){
		return this.currentEvnet;
	}
	
	//Skickar tillbaka det som specificeras.
	public int getCurrentCustomer(){
		return this.currentCustomer;
	}
	
	//Skickar tillbaka det som specificeras.
	public EventQueue getEventQueue(){
		return super.eventQueue;
	}
	
	//Ökar kunder som betalt med 1.
	public void addPay(){
		paid++;
	}
	
	//Skickar tillbaka det som specificeras.
	public int getPaid(){
		return paid;
	}
	
	//Retunerar hur många kunder som är i affären.
	public int customersInStore() {
		return this.customersInStore;
	}
	
	//Skickar tillbaka det som specificeras.
	public int getMaxCustomers(){
		return this.MAXCOSTUMER;
	}
	
	//Skickar tillbaka det som specificeras.
	public int getRegisters(){
		return this.REGISTERS;
	}
	
	//Skickar tillbaka det som specificeras.
	public double getTimeRegistersNotUsed(){
		return this.timeRegistersNotUsed;
	}
	
	//Skickar tillbaka det som specificeras.
	public int getSad(){
		return this.sad;
	}
	
	//Skickar tillbaka det som specificeras.
	public int getCustumersQueued(){
		return this.customersQueued;
	}
	
	//Skickar tillbaka det som specificeras.
	public int getCurrentlyQueuing(){
		return this.currentlyQueuing;
	}
	
	//Skickar tillbaka det som specificeras.
	public int[] getQueue(){
		int[] temp = new int[0];
		return temp;
	}
	
	//Skickar tillbaka det som specificeras.
	public double getStart(){
		return this.START;
	}
	
	//Returnerar hur många kassor som är lediga.
	public int emptyRegisters(){
		return this.emptyRegisters;
	}
	
	//Om det inte finns någon ledig kassa returnerar den false, annars true.
	public boolean isRegisterEmpty(){
		if (this.emptyRegisters == 0){
			return false;
		}else{
			emptyRegisters--;
			return true;
		}
		
	}
		
	//Skickar tillbaka det som specificeras.
	public double getQueueTime() {
		if (fifo.isEmpty() == true) {
			return 0;
		}
		return 0.5;
	}
	
	//Om affären är full så ökar antalet ledsna kunder, annars läggs det till en kund i affären.
	public boolean isStoreFull(){
		if (this.customersInStore == this.MAXCOSTUMER){
			this.sad++;
			return true;
		}else{
			this.customersInStore++;
			return false;
		}
	}
	
	//Öppnar affären.
	public void openStore() {
		storeIsOpen = true;
	}
	
	//Stänger affären.
	public void closeStore() {
		storeIsOpen = false;
	}
	
	//Tittar om affären är öppen.
	public boolean getOpenState() {
		return this.storeIsOpen;
	}
	
	//Om affären är öppen returnerar den Ö annars S.
	public String isStoreOpenString(){
		if (this.storeIsOpen) {
			return "Ö";
		}
		return "S";
	}
	
	//Skickar tillbaka det som specificeras.
	public FIFO getFIFO(){
		return fifo;
	}
	
	//Skickar tillbaka det som specificeras.
	public double getP_MIN() {
		return this.P_MIN;
	}
	
	//Skickar tillbaka det som specificeras.
	public double getP_MAX() {
		return this.P_MAX;
	}
	
	//Skickar tillbaka det som specificeras.
	public double getK_MIN() {
		return this.K_MIN;
	}
	
	//Skickar tillbaka det som specificeras.
	public double getK_MAX() {
		return this.K_MAX;
	}
	public long getSeed() {
		
		return this.seed;
	}
}
