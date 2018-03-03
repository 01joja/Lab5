package store.events;

import deds.Event;
import deds.SimState;
import store.sim.StoreState;

public class Start extends Event{
	
	private double time = 0;
	private double startTime;
	private double finishTime;
	
	public void perform(StoreState s) {
		s.openOrClosed(true);
		
	}
	
	public double[] getTime() {
		double[] time = {startTime, finishTime};
		return time;
	
	}

	public void setTime() {
		startTime = 0;
		finishTime = 999;
	}
}
