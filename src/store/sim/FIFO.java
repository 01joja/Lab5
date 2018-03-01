package store.sim;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO {
		
		private ArrayList<Object> objects = new ArrayList<Object>();	//Creates an array for the objects
		
		private int max = 0;
		
		public int size() {		//this method returns how big the array currently is.
			return objects.size();
			
		} public int maxSize() {	//returns the biggest size the array has every been since it was created.
			return this.max;
		}
		
		public boolean isEmpty() { 	//if the array is empty it returns true else returns false.
			if (objects.size() == 0) {
				return true;
				
			} else {
				return false;
			}
		}
		
		public Object first() {
			if (objects.size() == 0) {			//If the array is empty throws an error
				throw new NoSuchElementException(); 
				
			} else {
				return objects.get(0);	//Else it returns the first object in the array
			}
		}
		
		public boolean equals(Object f) {
//			if (this.getClass() != f.getClass()) {	//if the classes is different throw classcastexception
//				throw new ClassCastException();
//			}
			
			FIFO F = (FIFO)f; //makes F the type FIFO
			if (this.size() == F.size()) { 		//returns false if the lists isn't equally big.
				for (int i = 0; i < objects.size(); i++) {
					if (objects.get(i) != null) {	//if objects doesn't contain null goes to the next loop.
						if (!(objects.get(i).equals(F.objects.get(i)))) { //if objects and F.objects are different returns false.
							return false;
						}
					}
					if (objects.get(i) == null) {		//If objects contains null checks if null is on the same space in F.objects
						if (objects.get(i) != F.objects.get(i)) {
							return false;
						}
					}
				}
			} else {
				return false;
			}
			return true;	
		}
			
		
		public String toString() {
			String x = "";
			for (int i = 0; i < objects.size(); i++) {
				x = x + "(" + String.valueOf(objects.get(i)) + ") "; 	//returns Queue + the numbers is the array
			}
			return "Queue: " + x; 
		}
		
		public void add(Object item) {
			objects.add(item);		//add objects to the array in the last place
			if (max < objects.size()) { 
			max += 1;
		}
		}
		
		public void removeFirst() {
			if (objects.size() == 0) {
				throw new NoSuchElementException(); 
			} else {
				objects.remove(0); //removes the first object in the array
			}
		}
		
		
	}	
