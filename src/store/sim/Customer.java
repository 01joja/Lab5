package store.sim;

public class Customer {
	
	private int customerID = 0;
	private static int numberOfCustomers;
	
	/**
	 * När en ny kund skapas får den ett kundnummer.
	 */
<<<<<<< HEAD
=======
	// visar antalet kunder i butiken ifall en ny kund anländer
	// får den helt enkelt det ID som är i den ordningen
	// kunden gick in i butiken.
>>>>>>> fd273b2782f489386fdfb2cd466a7889b9b8a28f
	public Customer() {
		customerID = numberOfCustomers;
		numberOfCustomers += 1;
	}
	//ger varje kund ett ID
	public int getCustomerID() {
		return this.customerID;
	}

}
