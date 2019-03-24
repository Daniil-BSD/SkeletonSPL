package gameLogic;

import java.util.*;

/**
 * This class makes it so that upon reaching the end of the segment, 
 * the train always goes along another path from another segment. 
 */
class PathEnd implements CellLogic {

    /**
     * Default constructor
     */
    public PathEnd() {
    	
    }

    /**
     * This attribute stores the next cell that comes after 
     * the last cell of the current path. 
     */
    private Cell nextCell;
    

    /**
     * This method returns true if the cell referred to by its ID is free, 
     * that is, if it does not know what cell is next.
     */
    public boolean HasConnection() {
    	return nextCell != null;
    }

    /**
     *  This method uses the logic of cell connections to connect to 
     *  link two cells in different segments.
     */
    public boolean LogicRequest(Car car) {
    	car.SetNextCell(nextCell);
    	return true;
    }

    /**
     *  This method links the end of the path to another cell of the next path.
     */
    public void Connect(Cell end) {
    	nextCell = end;
    	
    }
}