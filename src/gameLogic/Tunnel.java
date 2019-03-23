package gameLogic;

import java.util.*;

/**
 * This class is responsible for the tunnels which connect the two entrances.
 */
public class Tunnel extends Segment {

    /**
     * Default constructor
     */
    public Tunnel() {
    }
    
    
    public Tunnel(String id) {
    	this.id = id;
    }
    
    public Tunnel(TunnelEntrance entrance1, TunnelEntrance entrance2) {
    	this.entrance0 = entrance1;
    	this.entrance1 = entrance2;
    	
    }
    /**
     * This attribute stores one entrance of the tunnel.
     */
    protected TunnelEntrance entrance0;

    /**
     *  This attribute stores another entrance of the tunnel.
     */
    protected TunnelEntrance entrance1;

    /**
     * @param TunnelEntrance te
     * This method returns the other end of the tunnel passed on to this method as te.
     */
    public void TunnelEntranceGetTheOtherEnd(TunnelEntrance te) {
        // TODO implement here
    }

}