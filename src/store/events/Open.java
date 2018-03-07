package store.events;

import deds.EventStart;
import deds.SimState;
/**
 * Innehåller en konstruktor som öppnar butiken
 * Ger en öppnings tid, en stängings tid
 * och själva simulatorns stängningstid
 *
 */
public class Open extends EventStart {
	public Open(double OpenTime, double CloseTime, double simStopTime, SimState simState){
		super(simStopTime, simState);
	}
}

