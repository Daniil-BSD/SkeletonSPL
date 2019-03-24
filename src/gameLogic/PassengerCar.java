package gameLogic;

/**
 * This class is a car that carries passengers.
 */
class PassengerCar extends Car {

	/**
	 * Default constructor
	 */
	public PassengerCar(Cell cell, Colors color) {
		super(cell);
		this.color = color;
		this.full = true;
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
		System.out.println("\t>CurrentlyAtTheStation(Color[] colors): Tells the car that the passengers in the cars of these colors are allowed to leave the car.");
		if (full) {
			for (Colors c : Colors.values()) {
				if (c.toString().equals(this.color.toString())) {
					System.out.println("\t<CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.");
					full = false;
					return true;
				}
			}
			System.out.println("\t<CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.");
			return false;
		}
		else {
			System.out.println("\t<CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.");
			return super.CurrentlyAtTheStation(colors);
		}
	}
}
