package gameLogic;

import java.util.*;

/**
 * This class manages the levels of the game which store cars, 
 * segments and cells within them.
 */
public class Level {

    /**
     * Default constructor
     */
    public Level() {
    	trains = new ArrayList<Locomotive>();
    	segments = new ArrayList<Segment>();
    	tunnels = new ArrayList<Tunnel>();
    }

    /**
     * This attribute stores the trains of the level.
     */
    protected ArrayList<Locomotive> trains;

    /**
     *  Segments of the level are stored by this attribute
     */
    protected ArrayList<Segment> segments;
    
    /**
     *  Stores the tunnels of the level.
     */
    protected ArrayList<Tunnel> tunnels;

    /**
     *  System clock is implemented by this method.
     */
    
    protected String name;
    
    
    public void Tick() {
        for (Locomotive locomotive : trains) {
			locomotive.Step();
		}
    }

    /**
     * @param String sgm1ID
     *  This method returns a segment which was found by its string ID.
     * @return 
     */
    public Segment FindSegment(String sgmID) {
        for(Segment sg : segments) {
        	if(sg.AreYou(sgmID))
        		return sg;
        }
        return null;
    }
    /**
     * @param TunnelEntrance te1
     * @param TunnelEntrance te2
     * This method is called by the level container and returns true if the tunnel
     *  is possible between the selected point and the entrance which was passed to 
     *  this method. Returns false otherwise.
     */
    public boolean IsTunnelPossibleBetween(TunnelEntrance te1, TunnelEntrance te2) {
        for(Tunnel tunnel : tunnels) {
        	if(te1.equals(tunnel.entrance0) && te2.equals(tunnel.entrance1)) {
        		return true;
        	}
        }
        return false;
    }
    
    public Tunnel GetTunnelBetween(TunnelEntrance te1, TunnelEntrance te2) {
    	
    	 for(Tunnel tunnel : tunnels) {
         	if(te1.equals(tunnel.entrance0) && te2.equals(tunnel.entrance1)||te1.equals(tunnel.entrance1) && te2.equals(tunnel.entrance0)) {
         		return tunnel;
         	}
         }
         return null;
    }

    /**
     * @param Tunnel newTunnel
     *  This method adds a new tunnel to the level and it is called by a similarly named method of 
     *  the LevelContainer class.
     */
    public void addTunnel(Tunnel newTunnel) {
       tunnels.add(newTunnel);
    }
    
    public void addSegment(Segment sgm) {
    	segments.add(sgm);
    }
    
    public void addLcomotive(Locomotive locomotive) {
		trains.add(locomotive);
	}

}