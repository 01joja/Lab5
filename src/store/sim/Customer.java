/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

package store.sim;

public class Customer {
	
	private int customerID = 0;
	private boolean hasPayed = false; 
	
	
	/**
	 * När en ny kund skapas får den ett kundnummer.
	 * @param ID ID för kunden
	 * @param StoreState den StoreState som ska ändras
	 */
	public Customer(int ID, StoreState StoreState) {
		this.customerID = ID;
		StoreState.addCustomerID();
	}
	
	/**
	 * 
	 * @return returnerar ID på kunden.
	 */
	public int getCustomerID() {
		return this.customerID;
	}
	
	/*
	 * Om kunden inte har betalat så sätts det till true.
	 */
	public boolean hasPayed(){
		if (!hasPayed){
			hasPayed = true;
			return false;
		}
		return true;
	}
}
