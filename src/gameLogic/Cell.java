package gameLogic;

import java.util.*;

/**
 * This class is responsible for the basic spacial units of the level, cells. 
 */
class Cell {

    /**
     * This attribute stores true if the cell is occupied by a car, false otherwise. 
     */
    private Boolean occupied;

	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

	/**
     * This attribute stores the logic which decides the next move for the car.
     */
    private CellLogic logic;
    

    /**
     * Default constructor
     */
    public Cell() {
    	occupied = false;
    }
    
    
    public boolean LogicRequest(Car car) {
    	if (logic != null) return logic.LogicRequest(car);
    	return true;
    }
    
    public CellLogic GetLogic() {
		return logic;
	}


	public void SetLogic(CellLogic logic) {
		this.logic = logic;
	}
	
	/**
     * This method returns the value depending on the occupied attribute.
     */
    public boolean IsOccupied() {
    	System.out.print("IsOccupied(): Check if this cell is occupied\n");
    	
    	System.out.print("IsOccupied(): Returns false if cell is not occupied\n");
    	return occupied;
    }

}