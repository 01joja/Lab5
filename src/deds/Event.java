/**
 * @author's 
 * Jonas Jacobsson jonjac-6
 * Marcus Carlsson marcap-7
 * Tommy Andersson anetom-6
 * Marcus Erisson amueri-6
 */

package deds;

import deds.SimState;

public class Event {
	
	private double finishTime;
	private String nameOfEvent;
	
	/**
	 * Ärvs av andra eventklasser.
	 */
	public void perform() {	
		
	}
	
	/**
	 * 
	 * @return returnerar finishTIme
	 */
	public double getEventFinishTime(){
		return finishTime;
	}
	
	/**
	 * 
	 * @param finishTime ger finishTime ett värde
	 */
	protected void setTime(double finishTime) {
		this.finishTime = finishTime;
		
	}
	
	/**
	 * 
	 * @param name ger eventet ett namn, t.ex arrival.
	 */
	protected void setNameOfEvent(String name){
		this.nameOfEvent = name;
	}
	
	/**
	 * 
	 * @return returnerar namnet på eventet.
	 */
	public String getNameOfEvent(){
		return nameOfEvent;
	}

}
