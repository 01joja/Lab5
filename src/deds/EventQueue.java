package deds;

import java.util.ArrayList;
import deds.Event;

/*
 * This class keeps track of the queue for the events
 */
public class EventQueue<object> {
	ArrayList<Event> eventQueue = new ArrayList<Event>();
	int EventsInQueueLength = eventQueue.size();

	/*
	 * Adds event to queue
	 * 
	 * @param event
	 */
	public void AddEvent(Event event) {
		eventQueue.add(event);
	}

	/*
	 * Clears the queue
	 */
	public void ClearQueue() {
		eventQueue.clear();
		/*
		 * Size of queue
		 * @returns the size of the queue
		 */
	}
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
	public Event prepareFirst() {
			
		}
	}
}