package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.StoreState;

	public class PickGoods extends Event {
		private EventQueue eventQueue;
		private StoreState s;
		private Arrivals  arrival;
		private Customer customer;
		
		public  PickGoods(StoreState s) {
		//setTime;
		this.s=s;
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("PickGoods");
		this.customer = new Customer();
		this.eventQueue.addEvent(this);;
	}

	public void perform () {
		s.updateStore(this,customer);
//		Pay pay = new Pay();
		PickGoods pickgoods = new PickGoods(s);
		}
	}
