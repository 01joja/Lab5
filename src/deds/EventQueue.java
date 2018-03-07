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
		
		if (event.getEventFinishTime() < this.eventQueue.get(0).getEventFinishTime()){
			this.eventQueue.add(0,event);
		}else if (event.getEventFinishTime() > this.eventQueue.get(this.eventQueue.size()-1).getEventFinishTime()){
			//Do nothing
		}else{
			for (int i = 0; i < this.eventQueue.size(); i++){
				if ((event.getEventFinishTime() > this.eventQueue.get(i).getEventFinishTime())
						&&(event.getEventFinishTime() < this.eventQueue.get(i+1).getEventFinishTime())){
					this.eventQueue.add(i+1,event);
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
