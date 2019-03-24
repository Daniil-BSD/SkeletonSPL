package gameLogic;

import java.util.*;

/**
 * This class implements the logic of passengers embarking and
 *  disembarking depending on the colors of the train and the station. 
 */
class StationLogic implements CellLogic {
	
	private boolean finalReportFlag = false;

    /**
     * Default constructor
     */
    public StationLogic(Station parentStation) {
    	this.parentStation = parentStation;
    }

    /**
     * 
     */
    private Station parentStation;


    /**
     * @param car
     */
    @Override
    public boolean LogicRequest(Car car) {
    	System.out.print("LogicRequest(Car car): Performs actions assigned to this cell.\n");
    	if(car.IsLocomotive()) {
    		Colors colors[] = parentStation.GetColors();
    		if(car.CurrentlyAtTheStation(colors)) {
    			System.out.print("LogicRequest(Car car): Permission to leave the station.\n");
    			return false;
    		}else {
    			if(parentStation.IsFinal()) {
    				if(!finalReportFlag) {
    					finalReportFlag = true;
    					LevelContainer.FinalReport(car);
    				}
    		    	System.out.print("LogicRequest(Car car): Permission to leave the station.\n");
    				return false;
    			}
    			System.out.print("LogicRequest(Car car): Permission to leave the station.\n");
    			return true;
    		}
    		
    	}
    	System.out.print("LogicRequest(Car car): Permission to leave the station.\n");
    	return true;
    }


}