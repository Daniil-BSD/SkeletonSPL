package main;

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
    public void LogicRequest(Car car);

}