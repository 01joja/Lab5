package store.sim;

import java.util.ArrayList;
import store.events.Pay;
import store.sim.*;
import store.sim.StoreState;

public class FIFORegistersAndQueue {
	
	private boolean hasQueue = false;
	private ArrayList<Customer> queue = new ArrayList<Customer>();
	private StoreState storeState;
	private final int REGISTERS;
	private int registerWhithCustomers = 0;
	private double totalTimeInQueue = 0;
	
	int totalQueued = 0;
	
	FIFORegistersAndQueue(StoreState storeState){
		this.storeState = storeState;
		this.REGISTERS = this.storeState.getRegisters();
	}
	
	public boolean tryToPay(Customer customer){
		if (hasQueue()){
			this.addToQueue(customer);
			return false;
		} else if (isRegisterFull()){
			this.addToQueue(customer);
			return false;
		}
		this.registerWhithCustomers++;
		return true;
	}
	
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
	
	public boolean hasQueue(){
		if (queue.size() == 0){
			return false;
		}
		return true;
	}
	
	public void addToQueue(Customer customer){
		this.totalQueued++;
		queue.add(customer);
	}
	
	public Customer getFirstQueue(){
		Customer temp = queue.get(0);
		queue.remove(0);
		return temp;
	}

	public Customer[] getQueue() {
		Customer[] temp = new Customer[queue.size()];
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