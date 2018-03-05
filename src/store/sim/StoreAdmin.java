package store.sim;

public class StoreAdmin {
	private int register;
	private int maxCustomers;
	private int openTime;
	
	StoreAdmin (int register, int maxCustomers, int openTime){
		this.register = register;
		this.maxCustomers = maxCustomers;
		this.openTime = openTime;
	}
	
	public int getRegisters() {
		return this.register;
	}
	
	public  int getMaxCustomers(){
		return this.maxCustomers;
	}
	
	public int getOpenTime(){
		return this.openTime;
	}
}
