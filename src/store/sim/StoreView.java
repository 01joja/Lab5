package store.sim;

import deds.SimView;

public class StoreView extends SimView {
       private  StoreState theState;
       
       public StoreView(StoreState state) {
    	   stateOfStore(theState);
       }

	public void stateOfStore(StoreState state) {
		this.theState = theState;
	}
	
}
