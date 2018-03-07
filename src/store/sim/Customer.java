package store.sim;

public class Customer {
	
	private int customerID = 0;
	private static int numberOfCustomers;
	
	/**
	 * När en ny kund skapas får den ett kundnummer.
	 */
	public Customer() {
		customerID = numberOfCustomers;
		numberOfCustomers += 1;
	}
	
	public int getCustomerID() {
		return this.customerID;
	}

}
