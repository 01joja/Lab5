package deds;
import java.util.Observable;
import deds.*;
import store.sim.StoreView;

public class SimState extends Observable{
	
	private double simTime = 0;
	private boolean stopSim = false;
	protected EventQueue eventQueue;
	protected StoreView storeView;
	
	//stänger av simulator när det har gått en viss tid
	void simEnd() {
		this.stopSim = true;
	}
	//kollar ifall simulatorn är igång 
	//är simulatorn igång så tar den den första instansen från
	//en kö ifrån klassen  EventQueue.
	boolean getRunSim(){
		if (this.stopSim == true){
			storeView.results();
			return false;
		}
		Event event = eventQueue.getFirst();
		event.perform();
		return true;
	}
	//sätter simulations tid
	public void setTime(double time){
		this.simTime = time;
	}
	// returnerar simTime 
	public double getTime(){
		return this.simTime;
	}
	
}