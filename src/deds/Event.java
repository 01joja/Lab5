package deds;

public class Event {
	
	private int startTime;
	private int finishTime;
	
	public void perform() {

		System.out.println("Den här ska göra saker");

		time = 5;

	}
	
	public int[] getTime() {
		return {startTime, finishTime};
	}
	
	public void setTime(int startTime, int finishTime) {
		
	}

}
