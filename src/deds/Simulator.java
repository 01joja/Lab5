package deds;
import deds.SimState;
import store.sim.StoreView;

public class Simulator {
	
	SimState theSimulator;
	
	public Simulator(SimState theSimulator){
		this.theSimulator = theSimulator;
	}
	
	public void mainLoop(){
		int i = 0;
		while(this.theSimulator.getRunSim()){
			i++;
		}
		System.out.println(i);
	}
}
