package gameLogic;

import java.util.*;

/**
 * This interface is responsible for „decisions” or actions that must be performed at certain cells.
 */
public interface CellLogic {


    /**
     * @param car
     * This method triggers actions bound to the respective cell, and decides 
     * if the train can leave the current cell and advance to the next cell along the path.
     */
    public default boolean LogicRequest(Car car) {
    	System.out.print("LogicRequest(Car car): Decides if the train can leave the current cell and advance to the next cell along the path. \n");
    	System.out.print("LogicRequest(Car car): Permission to leave the station.\n");
    	return true;
    }

}