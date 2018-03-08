package store.sim;

public class Customer {
	
	private int customerID = 0;
	private static int numberOfCustomers;
	
	/**
	 * När en ny kund skapas får den ett kundnummer.
	 */
<<<<<<< HEAD

	// visar antalet kunder i butiken ifall en ny kund anländer
	// får den helt enkelt det ID som är i den ordningen
	// kunden gick in i butiken.

=======
	// visar antalet kunder i butiken ifall en ny kund anländer
	// får den helt enkelt det ID som är i den ordningen
	// kunden gick in i butiken.
>>>>>>> 8f11cd903859c7f64df0902f86c8ece9ae31092c
	public Customer() {
		customerID = numberOfCustomers;
		numberOfCustomers += 1;
	}
	//ger varje kund ett ID
	public int getCustomerID() {
		return this.customerID;
	}

}
