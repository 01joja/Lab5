package store.events;

import deds.Event;
import deds.SimState;

public class Start extends Event{
	
	private double time = 0;
	
	public void perform() {
		perform.Start;
		
	}
	
	public double getTime() {
		return time;
	}

	public void setTime() {
		time = 0;
	}
}
