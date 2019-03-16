package finshed;

import java.util.*;

import Unfinished.Car;
import Unfinished.Cell;
import Unfinished.CellLogic;

/**
 * This class makes it so that upon reaching the end of the segment, 
 * the train always goes along another path from another segment. 
 */
public class PathEnd implements CellLogic {

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
     * @param int endID
     * This method returns true if the cell referred to by its ID is free, 
     * that is, if it does not know what cell is next.
     */
    public void HasConnection(void int endID) {
        // TODO implement here
    }

    /**
     * @param car
     *  This method uses the logic of cell connections to connect to 
     *  link two cells in different segments.
     */
    public void LogicRequest(Car car) {
        // TODO implement here
    }

}