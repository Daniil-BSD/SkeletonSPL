package gameLogic;

import java.util.*;

/**
 * This class is needed to set the paths for the trains.
 */
public class PathStart implements CellLogic {

    /**
     * Default constructor
     */
    public PathStart(Path path) {
    	this.path = path;
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
        System.out.println("path set");
    	car.SetPath(path);
    	return true;
    }

}