package deds;
import java.util.Observable;

public class SimState extends Observable{
	
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