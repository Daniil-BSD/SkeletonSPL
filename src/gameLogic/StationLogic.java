package gameLogic;

import java.util.*;

/**
 * This class implements the logic of passengers embarking and
 *  disembarking depending on the colors of the train and the station. 
 */
class StationLogic implements CellLogic {

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
        // TODO implement here
    	if(car.IsLocomotive()) {
    		Colors colors[] = parentStation.GetColors();
    		if(car.CurrentlyAtTheStation(colors)&&parentStation.getClass() == FinalStation.class) {
    			LevelContainer.FinalReport(car);
    			return false;
    		}
    	
    		return true;
    		
    		
    	}
    	return true;
    }

}