package gameLogic;

import java.util.*;

/**
 * This class is responsible for the tunnels which connect the two entrances.
 */
public class Tunnel extends Segment {
    
    
    public Tunnel(String id) {
    	super(id);
    }
    /**
     * This attribute stores one entrance of the tunnel.
     */
    private TunnelEntrance entrance0;

    /**
     *  This attribute stores another entrance of the tunnel.
     */
    private TunnelEntrance entrance1;

    /**
     * @param TunnelEntrance te
     * This method returns the other end of the tunnel passed on to this method as te.
     */
    public void TunnelEntranceGetTheOtherEnd(TunnelEntrance te) {
        // TODO implement here
    }

}