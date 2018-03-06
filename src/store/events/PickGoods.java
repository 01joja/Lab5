package store.events;

import deds.Event;

	public class PickGoods extends Event {	
		private Event PickGoods;
		public  PickGoods() {
		setTime;
		super.setNameOfEvent("PickGoods");
		Arrivals arrival = new Arrivals();
		EventQueue.getEventQueue(PickGoods);
	}

	public void perform (StoreState s) {
		s.update;
		s.isStoreFull();
		Pay pay = new Pay();
		PickGoods pickgoods = new PickGoods();
		}
	}


