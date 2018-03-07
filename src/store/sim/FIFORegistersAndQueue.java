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
	
	FIFORegistersAndQueue(StoreState storeState){
		this.storeState = storeState;
		this.REGISTERS = this.storeState.getRegisters();
	}
	
	public boolean goAndPay(Pay pay, double time){
		
		if (this.registerWhithCustomers == this.REGISTERS){
			this.addToQueue(pay);
			return false;
		}else{
			this.registerWhithCustomers++;
			this.storeState.emptyRegisters--;
		}
		return true;
	}
	
	public void addToQueue(Pay newPay){
		if (queue.size() == 0){
			queue.add(newPay);
			this.hasQueue = true;
		}else{
			queue.add(queue.size()-1, newPay);
		}
	}
	
	public Pay[] getQueue(){
		Pay[] temp = (Pay[]) queue.toArray();
		return temp;
	}
	
	public int getSize(){
		return queue.size();
	}
	
	public boolean hasQueue(){
		return this.hasQueue;
	}
	
	public Pay getNextInQueue(){
		Pay pay = queue.get(0);
		queue.remove(0);
		pay.setNewPayTime(this.storeState.getTime());
		if (queue.size() == 0){
			this.hasQueue = false;
		}
		return pay;
	}

	public void oneFreeRegister() {
		
		if (this.registerWhithCustomers != 0){
			this.registerWhithCustomers--;
			this.storeState.emptyRegisters++;
		}
	}
}