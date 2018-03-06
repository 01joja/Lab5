package deds;
import java.util.Observable;
import deds.*;

public class SimState extends Observable{
	
	private double simTime = 0;
	private boolean stopSim = false;
	protected EventQueue eventQueue;
	
	
	void simEnd() {
		this.stopSim = true;
	}
	
	boolean getRunSim(){
		if (this.stopSim == true){
			return false;
		}
		System.out.print("vill köra");
		Event event = eventQueue.getFirst();
		event.perform();
		return true;
	}
}