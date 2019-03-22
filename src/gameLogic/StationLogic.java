package gameLogic;

import java.util.*;

/**
 * This class implements the logic of passengers embarking and
 *  disembarking depending on the colors of the train and the station. 
 */
public class StationLogic implements CellLogic {
	
	private boolean finalReportFlag = false;

    /**
     * Default constructor
     */
    public StationLogic() {
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
    	if(car.IsLocomotive()) {
    		Colors colors[] = parentStation.GetColors();
    		if(car.CurrentlyAtTheStation(colors)) {
    			return false;
    		}else {
    			if(parentStation.IsFinal()) {
    				if(!finalReportFlag) {
    					finalReportFlag = true;
    					LevelContainer.FinalReport(car);
    				}
    				return false;
    			}
    			return true;
    		}
    		
    	}
    	return true;
    }

}