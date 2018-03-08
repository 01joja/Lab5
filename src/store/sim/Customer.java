package store.sim;

public class Customer {
	
	private int customerID = 0;
	private static int numberOfCustomers;
	
	/**
	 * När en ny kund skapas får den ett kundnummer.
	 */

	// visar antalet kunder i butiken ifall en ny kund anländer
	// får den helt enkelt det ID som är i den ordningen
	// kunden gick in i butiken.

	public Customer() {
		customerID = numberOfCustomers;
		numberOfCustomers += 1;
	}
	//ger varje kund ett ID
	public int getCustomerID() {
		return this.customerID;
	}

}
