package gameLogic;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * The path is a sequence of cells along which the train moves which is
 * implemented by this class.
 */
class Path {

	protected Cell[] cells;

	/**
	 * Default constructor
	 */
	public Path(Cell[] cells) {
		this.cells = cells;
		if (this.cells.length > 1) {
			this.cells[0].SetLogic(new PathStart(this));
			this.cells[this.cells.length - 1].SetLogic(new PathEnd());
		} else {
			throw new InvalidParameterException();
		}
	}

	protected Path() {
	}

	/**
	 * @param cell This method gets the cell, and returns the cell which is next to
	 *             it along the same path.
	 */
	public Cell NextCell(Cell cell) {
		System.out.print("NextCell(Cell cell): Asks Path for the cell after the given one.\n");
		int index = 0;
		for (Cell localCell : cells) {
			index++;
			if (localCell == cell)
				break;
		}
		System.out.print(
				"NextCell(Cell cell): Passes the next cell.  (null if the passed cell was the last one in the path)\n");
		if (index < cells.length)
			return cells[index];
		return null;
	}

	public Cell GetStart() {
		return cells[0];
	}

	public Cell GetEnd() {
		return cells[this.cells.length - 1];
	}

	public PathEnd GetEndLogic() {
		return (PathEnd) cells[this.cells.length - 1].GetLogic();
	}

	/**
	 * @param      int length
	 * @param Cell current This method gets the cell, which is occupied by a car and
	 *             makes the amount of cells equal to length behind the car occupied
	 *             as well.
	 */
	public void UpdatePresence(int length, Cell current) {
		int index = 0;
		boolean found = false;
		for (Cell localCell : cells) {
			if (localCell == current) {
				found = true;
				break;
			}
			index++;
		}
		if (found) {
			if (index < cells.length - 1) {
				int i = 0;
				for (; i < length && index - i >= 0; i++) {
					cells[index - i].setOccupied(true);
				}
				if(++i == length) {
					cells[index - i].setOccupied(false);
				}
			} else {
				for (int i = 0; i < length && index - i >= 0; i++) {
					cells[index - i].setOccupied(false);
				}
			}
		}
	}

}