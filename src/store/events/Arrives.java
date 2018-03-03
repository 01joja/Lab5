package store.events;

import deds.Event;
import deds.SimState;
import store.sim.StoreAdmin;
import store.sim.StoreState;


public class Arrives extends Event{
	
	private double startTime;
	private double finishTime;
	
	StoreState s;
	
	
	
			
	public void perform (StoreState s, StoreAdmin a) {
		if ( s.customersInStore() == a.maxCustomers()) {
			s.angry();
			
		}
		s.addCustomer();
		
			
		
	}
	
	public double[] getTime() {
		double[] time = {startTime, finishTime};
		return time;
	}
	
	public void setTime(double startTime, double finishTime) {
		
	}


}
