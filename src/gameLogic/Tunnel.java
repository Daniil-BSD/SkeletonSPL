package gameLogic;

import java.util.*;

/**
 * This class is responsible for the tunnels which connect the two entrances.
 */
class Tunnel extends Segment {
    
    
    public Tunnel(String id) {
    	super(id);
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
    public TunnelEntrance GetTheOtherEnd(TunnelEntrance te) {
        if(te.equals(entrance0))
        	return entrance1;
        return entrance0;
    }

}