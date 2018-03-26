package deds;
import java.util.Observable;
import deds.*;
import store.sim.StoreView;

public class SimState extends Observable{
	
	private double simTime = 0;
	private boolean stopSim = false;
	private EventQueue eventQueue;
	
	/**
	 * När metoden körs så ändras flaggan till true och simulationen stängs av.
	 */
	void simEnd() {
		this.stopSim = true;
	}
	
	/**
	 * @return Tittar ifall simulatorn är igång.
	 */
	public boolean getRunSim(){
		if (this.stopSim == true){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param time Sätter en tid på eventet.
	 */
	public void setTime(double time){
		this.simTime = time;
	}
	
	/**
	 *  
	 * @return returnerar tiden på simulationen.
	 */
	public double getTime(){
		return this.simTime;
	}
	
	/**
	 * 
	 * @param eventQueue Bestämmer vad EventQueue ska vara.
	 */
	public void setEventQueue(EventQueue eventQueue){
		this.eventQueue = eventQueue;
	}
	
	/**
	 * 
	 * @return returnerar eventqueuen.
	 */
	public EventQueue getEventQueue(){
		return this.eventQueue;
	}
	
}