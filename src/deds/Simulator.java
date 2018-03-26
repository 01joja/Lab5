package deds;
import deds.SimState;
import store.sim.StoreView;

public class Simulator {
	
	SimState theSimulator;
	EventQueue eventQueue;
	
	/**
	 * 
	 * @param theSimulator Objektet som håller igång simulationen.
	 */
	public Simulator(SimState theSimulator){
		this.theSimulator = theSimulator;
		this.eventQueue = theSimulator.getEventQueue();
	}
	
	/**
	 * loopar medans funktionen getRunSim returnerar true.
	 */
	public void mainLoop(){
		boolean run = this.theSimulator.getRunSim();
		while(run)
		{
			Event event = eventQueue.getFirst();
			event.perform();
			run = this.theSimulator.getRunSim();
		}
	}
}
