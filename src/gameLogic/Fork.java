package gameLogic;

import java.util.*;

/**
 * This class is responsible for directing the train along 
 * the different paths that go out of the fork depending on 
 * the player¡¦s choice.
 */
public class Fork extends Segment{

    /**
     * Default constructor
     */
    public Fork() {
    }
    
    public Fork(String id) {
    	this.id = id;
    	
    }

    /**
     * 
     */
    private SelectorPath selectorPath;

    /**
     * This attribute stores one of the fork¡¦s exits.
     */
    private Path path20;

    /**
     * This attribute stores another exit.
     */
    private Path path02;


    /**
     * This method returns true or false respectively if 
     * the cell out of the fork is occupied by a car or not
     */
    public boolean IsEmpty() {
        System.out.println("IsEmpty(): Checks if the first cell of the path selected is occupied.");
    	for(Cell cell : this.cells) {
    		if(cell.IsOccupied()) {
    			System.out.println("IsEmpty(): If the cell is not occupied, returns true.");
    			return false;
    		}
    	}
    	System.out.println("IsEmpty(): If the cell is not occupied, returns true.");
    	return true;
    }

    /**
     *  This method chooses the path for the train on the fork. 
     *  The first cell of the path should be empty which is checked by 
     *  this method. It is called by the controller which is controlled by 
     *  the player.
     */
    public void Select() {
        // TODO implement here
    	if(IsEmpty()) {
    		selectorPath.SelectNextExit();
    		
    	}
    }
}