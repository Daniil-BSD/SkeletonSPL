package gameLogic;

import java.util.*;

/**
 * This class is responsible for the final station which, 
 * upon getting a train, checks if the train is empty.
 * We lose the game if there are still passengers inside 
 * the train at that point.
 */
class FinalStation extends Station {

	
	
    /**
     * Default constructor
     */
    public FinalStation(String id, Colors[] colors) {
    	super(id, colors);
    }

    @Override
    public  boolean IsFinal() {
		return true;
	}
}