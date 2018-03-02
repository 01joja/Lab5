package deds;

public abstract class Event {
	
	private double startTime;
	private double finishTime;
	private double time;
	private int SIMSTART = 0;
	private int ARRIVES = 1;
	private int PICKGOODS = 2;
	private int PAYING = 3;
	private int SIMSTOP = 4;
	
	public void perform() {
		
	}
	

	public double[] getTime() {
		double[] time = {startTime, finishTime};
		return time;

	}
	public void setTime(double startTime, double finishTime) {
		
	}

}
