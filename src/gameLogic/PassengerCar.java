package gameLogic;

/**
 * This class is a car that carries passengers.
 */
public class PassengerCar extends Car {

	/**
	 * Default constructor
	 */
	public PassengerCar(Cell cell, Colors color) {
		super(cell);
		this.color = color;
	}

	/**
	 * This attribute stores the color of the car for it to drop the passengers if
	 * it matches the station¡¦s color.
	 */
	private Colors color;

	private boolean full;

	public boolean isFull() {
		return full;
	}

	@Override
	public boolean CurrentlyAtTheStation(Colors[] colors) {
		System.out.print("CurrentlyAtTheStation(Color[] colors): Sends colors of the station to the car. Tells the car that the passengers in the cars of these colors are allowed to leave the car.\n");
		if (full) {
			for (Colors c : Colors.values()) {
				if (c.toString().equals(this.color.toString())) {
					System.out.print("CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.\n");
					return true;
				}
			}
			System.out.print("CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.\n");
			return false;
		}
		else {
			System.out.print("CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.\n");
			return super.CurrentlyAtTheStation(colors);
		}
	}
}
