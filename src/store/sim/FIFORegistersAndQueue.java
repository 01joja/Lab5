/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

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
	
	/**
	 * 
	 * @param customer den kund som ska försöka att betala.
	 * @return Om det finns en kö så läggs kunde dit och returnerar false
	 * och om ingen kassa är ledig så ställer sig kunden i kö och returnerar
	 * false. Om det inte finns en kö och kassa är ledig så ökas antalet kassor med kunder med 1. 
	 */
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
	 * @param customer den kund som ska läggas till i kön
	 */

	public void addToQueue(Customer customer){
		storeState.addCustumersQueued();
		storeState.setCurrentlyQueuing(queue.size());
		queue.add(customer);
	}
	

	
	/**
	 * 
	 * @return returnerar första kunden i kön och tar bort den.
	 */
	public Customer getFirstQueue(){
		Customer temp = queue.get(0);
		queue.remove(0);
		storeState.setCurrentlyQueuing(queue.size());
		return temp;
	}

	/**
	 * 
	 * @return en array utav kön
	 */
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