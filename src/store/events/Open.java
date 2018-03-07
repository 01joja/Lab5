package store.events;

import deds.EventStart;
import deds.SimState;

public class Open extends EventStart {
	
	private double closeTime;
	
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
		this.setTime(openTime);
		this.setNameOfEvent("Open");
		this.closeTime = closeTime;
	}
	
	void preform(){
		
	}
}

