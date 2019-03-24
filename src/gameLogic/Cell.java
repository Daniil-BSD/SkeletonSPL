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
    	System.out.println("\t>LogicRequest(Car car): Decides if the train can leave the current cell and advance to the next cell along the path. ");
    	if (logic != null) {
    		System.out.print("\t>LogicRequest(Car car): Performs actions assigned to this cell.\n");
    		System.out.println("\t\t//car gets next cell.");    		
    		Boolean messageBool = logic.LogicRequest(car);

        	System.out.print("\t<LogicRequest(Car car): Permission to leave the station.\n");
    		System.out.println("\t<LogicRequest(Car car): Permission to leave the station.");
        	return messageBool;
    	}

		System.out.println("\t<LogicRequest(Car car): Permission to leave the station.");
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
    	System.out.print("\t>IsOccupied(): Check if this cell is occupied\n");
    	
    	System.out.print("\t<IsOccupied(): Returns false if cell is not occupied\n");
    	return occupied;
    }

}