package gameLogic;

import java.util.*;

/**
 * This class stores all the levels of the game. Also, the levels are managed 
 * internally by this class. The segments are joined and the tunnels are constructed by it.
 */
abstract class LevelContainer {

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
    public void FinalReport(Locomotive locomotive) {
        // TODO implement here
    }

    /**
     * @param string Sgm1ID 
     * @param int end1ID 
     * @param string  Sgm2ID 
     * @param int end2ID
     * This method starts the process of joining two segments. It is called by the Controller.
     */
    public void Join( String Sgm1ID, int end1ID, String  Sgm2ID, int end2ID) {
        // TODO implement here
    }

    /**
     * @return
     *  This method returns true if a tunnel entrance 
     *  is selected to construct a tunnel between two points.
     */
    public boolean IsEntranceSelected() {
        // TODO implement here
        return true;
    }

    /**
     * @param TunnelEntrance te
     */
    public void IsTunnelPossibleFrom(TunnelEntrance te) {
        // TODO implement here
    }

    /**
     * @param TunnelEntrance te
     *  If the tunnel is possible between the two points, this method clears 
     *  the current tunnels of the two entrances, creates a new tunnel and sets 
     *  it for the te and the selected entrance.
     */
    public void ConstructFrom(TunnelEntrance te) {
        // TODO implement here
    }

    /**
     * @param Tunnel newTunnel
     * This method registers a new tunnel to the level.
     */
    public void addTunnel(Tunnel newTunnel) {
        // TODO implement here
    }

    /**
     * @param TunnelEntrance te 
     * @param TunnelEntrance selected
     * This method is called by the above method to check 
     * if the tunnel is possible between the two entrances. 
     */
    public void IsTunnelPossibleBetween(TunnelEntrance te, TunnelEntrance selected) {
        // TODO implement here
    }
    

    /**
     * @param car
     */
    public void Derailed(Car car) {
        // TODO implement here
    }

    /**
     * @param car
     */
    public void Collided(Car car) {
        // TODO implement here
    }

}