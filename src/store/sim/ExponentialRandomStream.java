package store.sim;

import java.util.Random;

public class ExponentialRandomStream {
	
	private Random rand;
	private double lambda;
	
	/**
	 *   
	 * @param lambda
	 * @param seed
	 */
	public ExponentialRandomStream(double lambda, long seed) {
	  	rand = new Random(seed);
	  	this.lambda = lambda;
	}
	  
	public ExponentialRandomStream(double lambda) {
		rand = new Random();
	    this.lambda = lambda;
	}
	  
	public double next() {
	  	return -Math.log(rand.nextDouble())/lambda;
	}
}
