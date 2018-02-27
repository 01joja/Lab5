package deds;

public class Event {
	
	private int time;
	
	public void perform() {

		System.out.println("Den här ska göra saker");

		time = 5;

	}
	
	public  int getTime() {
		time = 6;
		return time;
	}
	
	public void setTime() {
		int p = 0;
	}

}
