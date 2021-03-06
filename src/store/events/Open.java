/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

package store.events;

import deds.EventStart;
import deds.EventQueue;
import store.sim.*;
import store.events.*;

/**
 * Innehåller en konstruktor som öppnar butiken
 * Ger en öppnings tid, en stängings tid
 * och själva simulatorns stängningstid
 *
 */
public class Open extends EventStart {
	
	private double closeTime;
	private StoreState storeState;
	private EventQueue eventQueue;

	/**
	 * 
	 * @param openTime Tiden som affären är öppen.
	 * @param closeTime Tidenpunkten då affären stänger.
	 * @param simStopTime Tidpunkten där simulationen avslutas.
	 * @param storeState Skickar till SimState som håller igång simulationen.
	 * Klassen som håller koll på när affären är öppen.
	 */
	public Open(double openTime, double closeTime, double simStopTime, StoreState storeState){
		super(simStopTime, storeState);
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
		this.setTime(openTime);
		this.setNameOfEvent("Open    ");
		this.closeTime = closeTime;
		this.eventQueue.addEvent(this);
	}
	
	/**
	 * Öppnar affären, uppdaterar läget i affären och sätter en stängningstid för affären.
	 */
	public void perform(){
		this.storeState.openStore();
		this.storeState.updateStore(this);
		new Close(closeTime, storeState);
	}
}

