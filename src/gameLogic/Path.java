package gameLogic;

import java.util.*;

/**
 * The path is a sequence of cells along which the train moves 
 * which is implemented by this class.
 */
class Path {

	private Cell[] cells;
    /**
     * Default constructor
     */
    public Path() {
    }

    /**
     * @param cell
     *  This method gets the cell, and returns the cell 
     *  which is next to it along the same path.
     */
    public Cell NextCell(Cell cell) {
        // TODO implement here
    	return cells[0]; //need to finish this!!!
    	
    }

   
    /**
     * @param int length 
     * @param Cell current
     *  This method gets the cell, which is occupied by a car and 
     *  makes the amount of cells equal to length behind the car occupied as well.
     */
    public void UpdatePresence(int length, Cell current) {
        // TODO implement here
    	//finish this!!
    }

}