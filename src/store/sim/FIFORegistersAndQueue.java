package store.sim;

import java.util.ArrayList;
import store.events.Pay;
import store.sim.StoreState;

public class FIFORegistersAndQueue {
	
	private boolean hasQueue = false;
	private ArrayList<Pay> queue = new ArrayList<Pay>();
	private StoreState storeState;
	private final int REGISTERS;
	private int registerWhithCustomers = 0;
	private double totalTimeInQueue = 0;
	
	int totalQueued = 0;
	
	FIFORegistersAndQueue(StoreState storeState){
		this.storeState = storeState;
		this.REGISTERS = this.storeState.getRegisters();
	}
	
	/**
	 * 
	 * @param pay Skickar med typen Pay med namnet pay.
	 * @return Om det finns en kö så läggs kunde dit och returnerar false
	 * och om ingen kassa är ledig så ställer sig kunden i kö och returnerar
	 * false. Om det inte finns en kö och kassa är ledig så ökas antalet kassor med kunder med 1. 
	 */
	public boolean tryToPay(Pay pay){
		if (hasQueue()){
			this.addToQueue(pay);
			return false;
		} else if (isRegisterFull()){
			this.addToQueue(pay);
			return false;
		}
		this.registerWhithCustomers++;
		return true;
	}
	
	/**
	 * @return returnerar true om det finns en kö, annars false.
	 */
	public boolean hasPaid(){
		if (hasQueue()){
			return true;
		}
		return false;
	}
	
	public boolean isRegisterFull(){
		if (this.REGISTERS <= this.registerWhithCustomers){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return returnerar false om det inte finns någon kö.
	 */
	public boolean hasQueue(){
		if (queue.size() == 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param pay Skickar med pay som parameter och lägger till
	 * en kund som köat.
	 */
	public void addToQueue(Pay pay){
		this.totalQueued++;
		queue.add(pay);
	}
	
	
	/**
	 * 
	 * @return returnerar första kunden i kön och tar bort den.
	 */
	public Pay getFirstQueue(){
		Pay temp = queue.get(0);
		queue.remove(0);
		return temp;
	}

	/**
	 * 
	 * @return 
	 */
	public Pay[] getQueue() {
		Pay[] temp = new Pay[queue.size()];
		for (int i = 0; i < this.queue.size(); i++){
			temp[i] = queue.get(i);
		}
		return temp;
	}

	public int getSize() {
		return queue.size();
	}

	public void removeOneInRegister() {
		this.registerWhithCustomers--;
	}
	
	public int getRegisterWhithCoustomers(){
		return registerWhithCustomers;
	}
}