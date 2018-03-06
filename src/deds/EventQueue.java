package deds;

import java.util.ArrayList;
import deds.Event;

/*
 * This class keeps track of the queue for the events
 */
public class EventQueue<object> {
	ArrayList<Event> eventQueue = new ArrayList<Event>();

	/*
	 * Adds event to queue
	 * 
	 * @param event
	 */
	public void addEvent(Event event) {
		double runTime = event.getEventFinishTime();
		if (eventQueue.size() == 0){
			eventQueue.add(event);
		}else{
			for (int i = 0; i < eventQueue.size(); i++){
				if (eventQueue.get(i).getEventFinishTime() > runTime){
					eventQueue.add(event);
				}
			}
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
