package deds;

public class SimState {
	private int simTime = 0;
	private boolean runSim = true;
	
	void simEnd() {
		runSim = false;
	}
	
	boolean getRunSim(){
		return runSim;
	}
}