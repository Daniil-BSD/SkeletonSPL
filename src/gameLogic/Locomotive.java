package gameLogic;

import java.util.*;

/**
 * 
 */
class Locomotive extends Car {

    /**
     * Default constructor
     */
    public Locomotive(Cell cell) {
    	super(cell);
    }

	@Override
	public boolean IsLocomotive() {
		System.out.println("\t>IsLocomotive(): check if the car is a locomotive.");
		
		System.out.println("\t<IsLocomotive(): true if it is a locomotive.");
		return true;
	}
    
    
    
}