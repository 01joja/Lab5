package store.sim;

public class Customer {
	
	private int customerID = 0;
	private static int numberOfCustomers;
<<<<<<< HEAD
	
	/**
	 * När en ny kund skapas får den ett kundnummer.
	 */
=======
	// visar antalet kunder i butiken ifall en ny kund anländer
	// får den helt enkelt det ID som är i den ordningen
	// kunden gick in i butiken.
>>>>>>> f8d2bd0ad9e1d40a28a036a737548ee589818460
	public Customer() {
		customerID = numberOfCustomers;
		numberOfCustomers += 1;
	}
	//ger varje kund ett ID
	public int getCustomerID() {
		return this.customerID;
	}

}
