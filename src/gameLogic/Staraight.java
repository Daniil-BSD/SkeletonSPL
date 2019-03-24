package gameLogic;

import java.util.LinkedList;

class Staraight extends Segment {
	public Staraight(String id) {
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
}
