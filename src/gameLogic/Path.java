package gameLogic;

import java.util.*;

/**
 * The path is a sequence of cells along which the train moves 
 * which is implemented by this class.
 */
public class Path {

	protected Cell[] cells;
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
    	System.out.print("NextCell(Cell cell): Asks Path for the cell after the given one.\n");
        // TODO implement here
    	System.out.print("NextCell(Cell cell): Passes the next cell.  (null if the passed cell was the last one in the path)\n");
    	return cells[0]; //need to finish this!!!
    }
    
    public Cell GetStart() {
    	return cells[0]; 
    	
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