package main;

import java.util.*;

/**
 * This class stores all the levels of the game. Also, the levels are managed 
 * internally by this class. The segments are joined and the tunnels are constructed by it.
 */
public abstract class LevelContainer {

    /**
     * Default constructor
     */
    public LevelContainer() {
    }

    /**
     * 
     */
    private Level levels[];

    /**
     * 
     */
    private TunnelEntrance selected;


    /**
     * @param car
     * This method gets the cars which are arrived at the final station. 
     * If the train is empty, the train waits at the Final Station. 
     * If the train is not empty, the game is lost and the level is restarted.  
     */
    public void FinalReport(void car) {
        // TODO implement here
    }

    /**
     * @param string Sgm1ID 
     * @param int end1ID 
     * @param string  Sgm2ID 
     * @param int end2ID
     * This method starts the process of joining two segments. It is called by the Controller.
     */
    public void Join(void string Sgm1ID, void int end1ID, void string  Sgm2ID, void int end2ID) {
        // TODO implement here
    }

    /**
     * @return
     *  This method returns true if a tunnel entrance 
     *  is selected to construct a tunnel between two points.
     */
    public Boolean IsEntranceSelected() {
        // TODO implement here
        return null;
    }

    /**
     * @param TunnelEntrance te1
     */
    public void IsTunnelPossibleFrom(void TunnelEntrance te1) {
        // TODO implement here
    }

    /**
     * @param TunnelEntrance te
     *  If the tunnel is possible between the two points, this method clears 
     *  the current tunnels of the two entrances, creates a new tunnel and sets 
     *  it for the te and the selected entrance.
     */
    public void ConstructFrom(void TunnelEntrance te) {
        // TODO implement here
    }

    /**
     * @param Tunnel newTunnel
     * This method registers a new tunnel to the level.
     */
    public void addTunnel(void Tunnel newTunnel) {
        // TODO implement here
    }

    /**
     * @param TunnelEntrance te 
     * @param TunnelEntrance selected
     * This method is called by the above method to check 
     * if the tunnel is possible between the two entrances. 
     */
    public void IsTunnelPossibleBetween(void TunnelEntrance te, void TunnelEntrance selected) {
        // TODO implement here
    }

}