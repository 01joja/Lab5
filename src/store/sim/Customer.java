package store.sim;

public class Customer {
	
	private int customerID = 0;
//	private int numberOfCustomers;
	private boolean hasPayed = false; 
	
	/**
	 * När en ny kund skapas får den ett kundnummer.
	 */
	public Customer(int numberOfCustomers, StoreState StoreState) {
		this.customerID = numberOfCustomers;
		StoreState.addCustomerID();
	}
	//ger varje kund ett ID
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
