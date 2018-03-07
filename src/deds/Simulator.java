package deds;
import deds.SimState;
import store.sim.StoreView;

public class Simulator {
	
	SimState theSimulator;
	//ger objected ett värde
	public Simulator(SimState theSimulator){
		this.theSimulator = theSimulator;
	}
	//loopar medans funktionen getRunSim returnerar true.
	public void mainLoop(){
		while(this.theSimulator.getRunSim())
		{
		}
	}
}
