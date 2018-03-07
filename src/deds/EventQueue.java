package deds;

import java.util.ArrayList;
import deds.Event;

/*
 * This class keeps track of the queue for the events
 */
public class EventQueue {
	
	void addStopEvent(Event e){
		eventQueue.add(e);
	}
	
	ArrayList<Event> eventQueue = new ArrayList<Event>();

	/*
	 * Adds event to queue
	 * 
	 * @param event
	 */
	public void addEvent(Event event) {
		if (("STOP".equals(eventQueue.get(0).getNameOfEvent()))
				&& (event.getEventFinishTime() < eventQueue.get(0).getEventFinishTime())){
			eventQueue.add(0, event);
		}else{
		}
	}

	/*
	 * Size of queue
	 * @returns the size of the queue
	 */
	public int queueSize() {
		return eventQueue.size();
	}
	
	
	/*
	 * Return the first event in the queue
	 */
	public Event getFirst() {
		Event FirstElement = eventQueue.get(0);
		eventQueue.remove(0);
		return FirstElement;
	}
}
