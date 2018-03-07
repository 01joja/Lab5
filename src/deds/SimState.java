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
		Event event = eventQueue.getFirst();
		System.out.println(event.getEventFinishTime() + " " + event.getNameOfEvent());
		event.perform();
		return true;
	}
	
	public void setTime(double time){
		this.simTime = time;
	}
	
	public double getTime(){
		return this.simTime;
	}
	
}