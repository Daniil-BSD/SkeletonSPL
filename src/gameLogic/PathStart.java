package gameLogic;

import java.util.*;

/**
 * This class is needed to set the paths for the trains.
 */
class PathStart implements CellLogic {

    /**
     * Default constructor
     */
    public PathStart() {
    }

    /**
     *  This attribute stores the path along which the train will 
     *  advance further into the level.
     */
    private Path path;


    /**
     * @param car
     */
    public boolean LogicRequest(Car car) {
        // TODO implement here
    	car.SetPath(path);
    	return true;
    }

}