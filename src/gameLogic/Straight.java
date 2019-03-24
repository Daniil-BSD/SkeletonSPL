package gameLogic;

import java.util.LinkedList;

/**
 * This class realizes the segment with straight paths i.e, without turns.
 */

class Straight extends Segment {
	
	 /**
     * Constructor that accepts a string id.
     */

	public Straight(String id) {
		super(id);
		cells = new Cell[9];
		LinkedList<Cell> temp = new LinkedList<Cell>();
		cells[0] = new Cell();
		cells[8] = new Cell();
		for (int i = 1; i < 7; i++) {
			cells[i] = new Cell();
			temp.add(cells[i]);
		}
		path01 = new Path(temp.toArray(new Cell[temp.size()]));
		temp = new LinkedList<Cell>();
		for (int i = 8; i >= 0; i--) {
			if (i == 7 || i == 1 )
				i--;
			temp.add(cells[i]);
		}
		path10 = new Path(temp.toArray(new Cell[temp.size()]));
		end0 = path10.GetEndLogic();
		end1 = path01.GetEndLogic();
	}

	// Method purely for skeleton
	/**
	 * 
	 * 
	 * this method returns a cell where a locomotive should be placed for
	 * demonstraton
	 */
	public Cell GET_DEMO_CELL(int index) {
		index %= 2;
		if (index == 1)
			return cells[3];
		return cells[6];
	}
	
	// Method purely for skeleton
	/**
	 * 
	 * 
	 * this method returns a cell where a locomotive should be placed for
	 * demonstraton
	 */
	public Path GET_DEMO_PATHL(int index) {
		index %= 2;
		if (index == 1)
			return path01;
		return path10;
	}

}
