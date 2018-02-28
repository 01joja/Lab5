package deds;
import storeSim;

public class Event {
	
	private double startTime;
	private double finishTime;
//	private double time;
	public void perform() {
		if (SimState.simTime == startTime) {
			
		}
	}
	

	public double[] getTime() {
		double[] time = {startTime, finishTime};
		return time;

	}
//	public int getTime() {
//		time = 6;
//		return time;

//	}
	
	public void setTime(double startTime, double finishTime) {
		
	}

}
