package main;

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
    public Segment() {
    }

    /**
     * This attribute stores the first cell of the segment
     */
    protected Cell end0;

    /**
     * This attribute stores the last cell of the segment.
     */
    protected Cell end1;

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
    protected String id;





    /**
     * @param segment
     *  This attribute is needed to find a needed segment in the level by its 
     *  string identifier. It is needed in order to build the level by connecting segments.
     */
    public void AreYou(String segmentID) {
        // TODO implement here
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
    public void GetFreeEnd(IndexOutOfBoundsException endID) {
        // TODO implement here
    }

    
    
    // the one below has an error, but I do not remember how it has to be
    /**
     * @param cell
     * This method connects the segments by its ends, one of 
     * which is passed on as a parameter to this method.
     */
    public void ConnectTo() {
        // TODO implement here
    }

    /**
     * This method is needed to store the segment which was selected by the player to 
     * construct a tunnel, or to control a switch at the chosen fork.
     */
    public void Select() {
        // TODO implement here
    }

}