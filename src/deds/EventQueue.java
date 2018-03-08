package deds;

import java.util.ArrayList;
import deds.Event;

/*
 * This class keeps track of the queue for the events
 */
public class EventQueue {
	
	ArrayList<Event> eventQueue = new ArrayList<Event>();
	double lowesTime = 0;
	
	void addStopEvent(Event e){
		eventQueue.add(e);
	}

	/*
	 * Adds event to queue
	 * 
	 * @param event
	 */
	public void addEvent(Event event) {
		for (int i = 0; i < eventQueue.size(); i++){
			if (eventQueue.get(i).getEventFinishTime() > event.getEventFinishTime()){
				eventQueue.add(i, event);
//				this.errorFunktion();
				return;
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
	
	/*
	 * Felsökningsmetod.
	 */
	private void errorFunktion(){
		System.out.println("---------------");
		for (int j = 0; j < eventQueue.size(); j++){
			System.out.println(this.eventQueue.get(j).getNameOfEvent() + " " + this.eventQueue.get(j).getEventFinishTime());
		}
		System.out.println("---------------");
	}
	
}
