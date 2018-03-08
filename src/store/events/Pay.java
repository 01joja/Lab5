package store.events;

import deds.Event;
import deds.EventQueue;
import store.sim.Customer;
import store.sim.FIFORegistersAndQueue;
import store.sim.StoreState;

public class Pay extends Event {
	
	private FIFORegistersAndQueue payQueue;
	private EventQueue eventQueue;
	private StoreState storeState;
	private Customer customer;
	private double timeTaken;
	
	/**
	 * 
	 * @param customer Skickas med som skapades under Arrival
	 * @param storeState Skickar värden till StoreState som håller i allt.
	 * Lägger till eventet i eventQueue, sätter namnet på eventet till pay.
	 */
	Pay(Customer customer, StoreState storeState) {
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
		timeTaken = ((double)this.storeState.getPayRandom().next());
//		System.out.print(timeTaken);
		this.setTime(timeTaken + this.storeState.getTime());
//		System.out.print(timeTaken);
		this.customer = customer;
		super.setNameOfEvent("Pay      ");
		this.payQueue = this.storeState.getFIFO();
		if (payQueue.tryToPay(this)){
			this.eventQueue.addEvent(this);
		}
	}
	
	public void perform() {
		
			this.storeState.setTime(getEventFinishTime());
			this.storeState.updateStore(this, customer);
			if (payQueue.hasPaid()){
				Pay tempPay = this.payQueue.getFirstQueue();
				tempPay.setNewPayTime(storeState.getTime());
				this.eventQueue.addEvent(tempPay);
				this.storeState.removeCustomer();
			}else{
				payQueue.removeOneInRegister();
				this.storeState.removeCustomer();
			}
			this.storeState.addPay();
		
	}
	
	public void setNewPayTime(double time){
		this.setTime(time + this.timeTaken);
	}
	
	public int getCustomer(){
		return this.customer.getCustomerID();
	}
}

