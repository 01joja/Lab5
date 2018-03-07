package store.events;

import deds.Event;
import deds.EventQueue;
import deds.SimState;
import store.sim.Customer;
import store.sim.StoreState;

	public class PickGoods extends Event {
		private EventQueue eventQueue;
		private StoreState s;
		private Customer customer;
		
		PickGoods(customer customer, storestate s) {
		//setTime;
		this.s=s;
		this.eventQueue = s.getEventQueue();
		super.setNameOfEvent("PickGoods");
		this.eventQueue.addEvent(this);
	}

	public void perform () {
<<<<<<< HEAD
		s.updateStore(this, customer);
		Pay pay = new Pay(customer, s);
=======
		s.updateStore(this,customer);
//		Pay pay = new Pay();
		PickGoods pickgoods = new PickGoods(s);
>>>>>>> 044deca5007869b50c541d2f585544ab21f65f5d
		}
	}
