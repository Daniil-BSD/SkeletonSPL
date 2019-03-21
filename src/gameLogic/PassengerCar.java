package gameLogic;

import java.util.*;

/**
 * This class is a car that carries passengers.
 */
class PassengerCar extends Car {

    /**
     * Default constructor
     */
    public PassengerCar() {
    }

    /**
     * This attribute stores the color of the car for it to drop the passengers 
     * if it matches the station¡¦s color. 
     */
    private Colors color;

    @Override
    public boolean CurrentlyAtTheStation(Colors[] colors) {
        // TODO implement here
    	for (Colors c : Colors.values()) {
            if (c.toString().equals(this.color.toString())) {
                return true;
            }
        }

        return false;
    }
    }

