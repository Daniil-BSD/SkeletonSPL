package gameLogic;

import java.util.*;

/**
 * This class is responsible for bigger units of space of the level than cells - segments.
 *  A segment is a part of the level that is either a tunnel, a station, or a fork. 
 *  Straight and Turn classes are also derived from segment, but their purpose is mainly in 
 *  graphically representing the level. Other than that, a segment is a sequence of cells 
 *  along two paths in opposite directions for the trains to traverse.
 */
public abstract class Segment {

    /**
     * Default constructor
     */
    public Segment(String id) {
    	this.id = id;
    }
    
    protected Cell cells[];
    
    /**
     * This attribute stores the first cell of the segment
     */
    protected PathEnd end0;

    /**
     * This attribute stores the last cell of the segment.
     */
    protected PathEnd end1;

    /**
     * A path from B to A is stored in this attribute.
     */
    protected Path path10;

    /**
     * A path from A to B is stored in this attribute.
     */
    protected Path path01;

    /**
     * 
     */
    protected final String id;





    /**
     * @param segment
     *  This attribute is needed to find a needed segment in the level by its 
     *  string identifier. It is needed in order to build the level by connecting segments.
     */
    public boolean AreYou(String segmentID) {
    	
        if(segmentID == id)
        	return true;
        return false;
    }
    
    /**
     * @param segment
     *  This attribute is needed to find a needed segment in the level by its 
     *  reference. It is needed in order to build the level by connecting segments.
     */
    public void AreYou(Segment segment) {
        // TODO implement here
    }

    /**
     * @param cell
     * This method returns a cell that is an edge of the segment if this cell is free.
     */
    public Cell GetFreeEnd(int endID) {
        if(!IsEndFree(endID))
        	return null;
        if(endID == 0) 
        	return path01.GetStart();
        if(endID == 1) 
        	return path10.GetStart();
        return null;
    }
    
    public boolean IsEndFree(int endID) {
    	if(endID == 0) 
    		return !end0.HasConnection();
    	if(endID == 1)
    		return !end1.HasConnection();
    	return false;
    	
    }
    
    
    // the one below has an error, but I do not remember how it has to be
    /**
     * @param cell
     * This method connects the segments by its ends, one of 
     * which is passed on as a parameter to this method.
     */
    public void ConnectTo(Cell end) {
        
    }

    /**
     * This method is needed to store the segment which was selected by the player to 
     * construct a tunnel, or to control a switch at the chosen fork.
     */
    public void Select() {
        // TODO implement here
    }

}