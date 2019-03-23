package gameLogic;

import java.util.*;

/**
 * 
 */
public class Locomotive extends Car {

    /**
     * Default constructor
     */
    public Locomotive(Cell cell) {
    	super(cell);
    }

	@Override
	public boolean IsLocomotive() {
		System.out.print("IsLocomotive(): check if the car is a locomotive.\n");
		
		System.out.print("IsLocomotive(): true if it is a locomotive. \n");
		return true;
	}
    
    
    
}