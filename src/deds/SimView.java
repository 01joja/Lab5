package deds;
import java.util.Observable;
import java.util.Observer;
public class SimView implements Observer  {
	//Klassen implenterar en observer som används för att
	//kunna observera klassen StorView
	
	public SimView(SimState simState){
		simState.addObserver(this);
	}
	
	public void update(Observable arg0, Object arg1) {
		
	}
}
