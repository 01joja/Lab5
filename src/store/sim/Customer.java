package store.sim;

public class Customer {
	
	private int customerID = 0;
	
	public void customer() {
		customerID += 1;
	}
	
	public int customerID() {
		return customerID;
	}

}
