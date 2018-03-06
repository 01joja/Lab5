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
		
	public Arrivals() {
		setTime;
		super.setNameOfEvent("Arrivals");
		Customer customer = new Customer();
		EventQueue.getEventQueue(Arrivals);
	}
	
	public void perform (StoreState s) {
		s.update;
		s.isStoreFull();
		PickGoods pickgoods = new PickGoods();
		Arrivals arrivals = new Arrivals();
		}
}
