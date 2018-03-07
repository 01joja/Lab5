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
	
<<<<<<< HEAD
	/**
	 * 
	 * @param openTime Tiden som affären är öppen.
	 * @param closeTime Tidenpunkten då affären stänger.
	 * @param simStopTime Tidpunkten där simulationen avslutas.
	 * @param simState Skickar till SimState som håller igång simulationen.
	 * Klassen som håller koll på när affären är öppen.
	 */
	public Open(double openTime, double closeTime, double simStopTime, SimState simState){
		super(simStopTime, simState);
=======
	public Open(double openTime, double closeTime, double simStopTime, StoreState storeState){
		super(simStopTime, storeState);
		this.storeState = storeState;
		this.eventQueue = this.storeState.getEventQueue();
>>>>>>> f8d2bd0ad9e1d40a28a036a737548ee589818460
		this.setTime(openTime);
		this.setNameOfEvent("Open");
		this.closeTime = closeTime;
		this.eventQueue.addEvent(this);
	}
	
	public void perform(){
		this.storeState.openStore();
		this.storeState.updateStore(this);
		new Close(closeTime, storeState);
	}
}

