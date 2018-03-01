package store.events;

import deds.Event;
import deds.SimState;

public class Start extends Event{
	
	private double time = 0;
	
	public void perform() {
		if(getTime() == 0) {
			
		}
	}
	
	public double getTime() {
		return time;
	}

	public void setTime() {
		time = 0;
	}
}
