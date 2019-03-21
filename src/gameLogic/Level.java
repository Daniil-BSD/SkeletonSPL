package gameLogic;

import java.util.*;

/**
 * This class manages the levels of the game which store cars, 
 * segments and cells within them.
 */
class Level {

    /**
     * Default constructor
     */
    public Level() {
    }

    /**
     * This attribute stores the trains of the level.
     */
    private ArrayList<Locomotive> trains;

    /**
     *  Segments of the level are stored by this attribute
     */
    private ArrayList<Segment> segments;
    
    /**
     *  Stores the tunnels of the level.
     */
    private ArrayList<Tunnel> tunnels;

    /**
     *  System clock is implemented by this method.
     */
    public void Tick() {
        // TODO implement here
    }

    /**
     * @param String sgm1ID
     *  This method returns a segment which was found by its string ID.
     */
    public void FindSegment(String sgmID) {
        // TODO implement here
    }
    /**
     * @param TunnelEntrance te1
     * @param TunnelEntrance te2
     * This method is called by the level container and returns true if the tunnel
     *  is possible between the selected point and the entrance which was passed to 
     *  this method. Returns false otherwise.
     */
    public void IsTunnelPossibleBetween(TunnelEntrance te1, TunnelEntrance te2) {
        // TODO implement here
    }

    /**
     * @param Tunnel newTunnel
     *  This method adds a new tunnel to the level and it is called by a similarly named method of 
     *  the LevelContainer class.
     */
    public void addTunnel(Tunnel newTunnel) {
        // TODO implement here
    }

}