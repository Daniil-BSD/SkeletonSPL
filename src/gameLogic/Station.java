package gameLogic;

import java.util.*;

/**
 * This class is responsible for the stations that have colorr. Depending on these colors, 
 * passengers embark or disembark.
 */
public class Station extends Segment {

    /**
     * Default constructor
     */
    public Station() {
    }
    
    
    public Station(String id) {
    	
    	this.id = id;
    }
    /**
     * 
     */
    private Colors colors[];
    
    
    public  boolean IsFinal() {
		return false;
	}

    /**
     * This attribute returns the colors of the station.
     * @return 
     */
    public Colors[] GetColors() {
    	System.out.print("GetColors(): Requests parent station for colors.\n");
        // TODO implement here
    	System.out.print("GetColors(): Set of colors accepted by the station.\n");
    	return colors;
    }

}