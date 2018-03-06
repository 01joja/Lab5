package deds;
import java.util.Observable;
import deds.*;

public class SimState extends Observable{
	
	private double simTime = 0;
	private boolean stopSim = false;
	
	void simEnd() {
		this.stopSim = true;
	}
	
	boolean getRunSim(){
		if (stopSim = true){
			return false;
		}
		
		return true;
	}
}