package gameLogic;

import java.util.*;

/**
 * This class is responsible for the entrances of the tunnels. 
 * When the train disappears at one end, it emerges at the other end 
 * which is implemented by this class.
 */
public class TunnelEntrance extends Segment {

	
	
    /**
     * Default constructor
     */
    private TunnelEntrance() {
    }

    /**
     * This attribute stores the tunnel which corresponds to the given entrance.
     */
    protected Tunnel tunnel;

    /**
     * This method sets the entrance of the tunnel to null.
     */
    public void Clear() {
        tunnel = null;
    }

    /**
     * This method sets the tunnel of both entrances to null.
     */
    public void FullClear() {
       tunnel.GetTheOtherEnd(this).Clear();
       Clear();
    }

    /**
     * @param Tunnel newTunnel
     * This method sets the tunnel for the current Tunnel Entrance.
     */
    public void SetTunnel(Tunnel newTunnel) {
        this.tunnel = newTunnel;
    }
    
    
    public void Select() {
    	
    	if(LevelContainer.IsEntranceSelected()) {
    		
    		if(LevelContainer.IsTunnelPossibleFrom(this)) {
    			
    			LevelContainer.ConstructFrom(this);
    		}
    		if(LevelContainer.IsThisSelected(this)) {
        		//LevelContainer.selected = null;
        		
        	}
    		LevelContainer.SelectEntrance(this);
    		
    	}
    	
    	
    }
}