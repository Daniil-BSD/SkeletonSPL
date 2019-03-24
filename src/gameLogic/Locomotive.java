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
		System.out.print("\t>IsLocomotive(): check if the car is a locomotive.\n");
		
		System.out.print("\t<IsLocomotive(): true if it is a locomotive. \n");
		return true;
	}
    
    
    
}