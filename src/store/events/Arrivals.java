package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.StoreState;


public class Arrivals extends Event{
	
	private double startTime;
	private double finishTime;
	private Event Arrivals;
		
	Arrivals(EventQueue e) {
		setname
		Customer customer = new Customer();
		e.addEvent(Arrivals);
	}
	
	public void perform (StoreState s, StoreAdmin a, Customer c) {
		Customer customer = new Customer();
		customer.isStoreFull();
		
		}
		
		
			
		
	
	
	public double[] getTime() {
		double[] time = {startTime, finishTime};
		return time;
	}
	
	public void setTime(double startTime, double finishTime) {
		
	}


}