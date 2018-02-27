package deds;

public class Event {
	
	private int startTime;
	private int finishTime;
	
	public void perform() {

		System.out.println("Den här ska göra saker");

		time = 5;

	}
	
<<<<<<< HEAD
	public int[] getTime() {
		return {startTime, finishTime};
=======
	public  int getTime() {
		time = 6;
		return time;
>>>>>>> ab78c84992a28c09d5771a2f9d615f7c80ebcc99
	}
	
	public void setTime(int startTime, int finishTime) {
		
	}

}
