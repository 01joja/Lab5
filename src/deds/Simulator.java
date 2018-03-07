package deds;
import deds.SimState;
import store.sim.StoreView;

public class Simulator {
	
	SimState theSimulator;
	
	public Simulator(SimState theSimulator){
		this.theSimulator = theSimulator;
	}
	
	public void mainLoop(){
		while(this.theSimulator.getRunSim()){
		}
	}
}
