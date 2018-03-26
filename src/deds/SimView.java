package deds;

import java.util.Observable;
import java.util.Observer;

public class SimView implements Observer  {

	/**
	 * 
	 * @param simState Lägger till en observer.
	 */
	public SimView(SimState simState){
		simState.addObserver(this);
	}
	
	/**
	 * Update metod som ärvs till klassen under.
	 */
	public void update(Observable arg0, Object arg1) {
		
	}
}
