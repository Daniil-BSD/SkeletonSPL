package gameLogic;

import java.util.*;

/**
 * This class implements the locomotive's behavior. Locomotive is the engine of
 * a train, the number of locomotives corresponds to the number of the trains on
 * the level.
 */
class Locomotive extends Car {

	/**
	 * Constructor that calls the superclass Car's constructor which then sets the
	 * given cell as the one that the locomotive is currently at.
	 */
	public Locomotive(Cell cell) {
		super(cell);
	}
	
	/**
	 * This method checks if this car is a locomotive. Always returns true.
	 */
	@Override
	public boolean IsLocomotive() {
		System.out.print("\t>IsLocomotive(): check if the car is a locomotive.\n");

		System.out.print("\t<IsLocomotive(): true if it is a locomotive. \n");
		return true;
	}

}