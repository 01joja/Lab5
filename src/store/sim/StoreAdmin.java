package store.sim;

public class StoreAdmin {
	private int register;
	private int maxCustomers;
	
	StoreAdmin (int register, int maxCustomers){
		this.register = register;
		this.maxCustomers = maxCustomers;
	}
	
	public int getRegisters() {
		return this.register;
	}
	
	public  int getMaxCustomers(){
		return this.maxCustomers;
	}
}
