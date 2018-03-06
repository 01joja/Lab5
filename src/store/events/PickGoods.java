package store.events;

import deds.Event;
import deds.EventQueue;

	public class PickGoods extends Event {	
		private Event PickGoods;
		private EventQueue eventQueue;
		public  PickGoods() {
		setTime;
		super.setNameOfEvent("PickGoods");
		Arrivals arrival = new Arrivals();
		eventQueue.getEventQueue(PickGoods);
	}

	public void perform (StoreState s) {
		s.update;
		s.isStoreFull();
		Pay pay = new Pay();
		PickGoods pickgoods = new PickGoods();
		}
	}


