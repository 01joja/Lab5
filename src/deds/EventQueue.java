package deds;

import java.util.ArrayList;
import deds.Event;

/*
 * Den här klassen håller reda på i vilken ordning eventen händer.
 */
public class EventQueue {
	
	ArrayList<Event> eventQueue = new ArrayList<Event>();
	double lowesTime = 0;
	
	void addStopEvent(Event e){
		eventQueue.add(e);
	}

	/**
	 * Lägger till eventen till listan.
	 * @param event hämtar events från event.
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

	/**
	 * 
	 * @returns returnerar storleken på listan.
	 */
	public int queueSize() {
		return eventQueue.size();
	}
	
	
	/**
	 * @returns returnerar första elementet i listan och tar bort det.
	 */
	public Event getFirst() {
		Event FirstElement = eventQueue.get(0);
		eventQueue.remove(0);
		return FirstElement;
	}
	
	/**
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
