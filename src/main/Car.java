package main;

import java.util.*;

/**
 * This class is responsible for the moving objects on the level, 
 * like the locomotive and the passenger car which are derived from this class.
 */
public abstract class Car {

    /**
     * Default constructor
     */
    public Car() {
    }

    /**
     *  We store this to know which cell our car is currently at.
     */
    private Cell cell;

    /**
     * A path is stored which is a sequence of cells to have 
     * an idea of the train or its component��s future position.
     */
    private Path path;

    /**
     * We need this for the car to always know its next step and path.
     */
    private Cell nextCell;

    /**
     * This attribute is for a car to know which other cars is it attached to. 
     * A train is moved by a locomotive which is a car, so cars should be connected with 
     * each other for this to work.
     */
    private Car attachedCar;

    /**
     * This attribute is here because of the cell logic. 
     * This is needed for the train to know if he has to determine the next step or stay in one place. 
     */
    private boolean permissionToLeave;

    /**
     * When the train is at the station, this attribute is used to know whether the colors of the train 
     * and the station match so people should leave the station, or the train can just pass through the 
     * station without dropping the passengers.
     */
    private Boolean peopleDisembarking;






    /**
     * This method makes the objects on the level think about their next step and consequently, move or not
     *  depending on the logic that is responsible for this decision. For example, the train on the station
     *   will move if it does not match the station or stay and disembark the passengers if it has a matching
     *   color. It will be bound to the system clock.
     */
    public void Step() {
        // TODO implement here
    }

    /**
     * @param logic.path
     * This method sets the path for the car.
     */
    public void SetPath(void logic.path) {
        // TODO implement here
    }

    /**
     * @param logic.nextCell
     *  This method sets the next cell for the car.
     */
    public void SetNextCell(void logic.nextCell) {
        // TODO implement here
    }

    /**
     *  This method returns true if the this car is the locomotive, false is returned if not.
     */
    public void IsLocomotive() {
        // TODO implement here
    }

    /**
     * @param colors[]
     *  When the locomotive is at the station, this method gets the colors of the train, 
     *  checks if any of them match with the station��s colors. If they do, it then drops the passengers. 
     */
    public void CurrentlyAtTheStation(void colors[]) {
        // TODO implement here
    }

    /**
     *  This method checks if the train has passengers or not. Returns true or false respectively.
     */
    public void IsEmpty() {
        // TODO implement here
    }

}