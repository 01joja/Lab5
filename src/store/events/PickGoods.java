package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.StoreState;

	public class PickGoods extends Event {	
		private Event PickGoods;
		private EventQueue eventQueue;
		private StoreState s;
		private Arrivals  arrival;
		private Customer customer;
		
		public  PickGoods(StoreState s) {
		setTime;
		this.s=s;
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("PickGoods");
		this.arrival = new Arrivals();
		this.customer = new Customer();
		eventQueue.addEvent(this);;
	}

	public void perform () {
		s.update;
		Pay pay = new Pay();
		PickGoods pickgoods = new PickGoods(s);
		}
	}

