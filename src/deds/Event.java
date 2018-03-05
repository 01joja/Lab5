package deds;

public abstract class Event {
	
	private double startTime;
	private double finishTime;
	private double time;
	
	
	public void perform() {
		
	}
	

	public double[] getTime() {
		double[] time = {startTime, finishTime};
		return time;

	}
	public void setTime(double startTime, double finishTime) {
		
	}

}
