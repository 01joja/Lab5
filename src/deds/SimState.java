package deds;

public class SimState {
	private double simTime = 0;
	private boolean stopSim = false;
	
	void simEnd() {
		this.stopSim = true;
	}
	
	boolean getRunSim(){
		if (stopSim){
			return false;
		}
		return true;
	}
}