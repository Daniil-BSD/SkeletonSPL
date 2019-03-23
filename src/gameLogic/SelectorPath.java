package gameLogic;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * This class is responsible for choosing the path out of the fork.
 */
public class SelectorPath extends Path {

    /**
     * Default constructor
     * 
     */
    public SelectorPath(Cell[] cells, Cell[] exits) {
		this.cells = cells;
    	this.exits = exits;
		if (this.cells.length > 0 && this.exits.length > 0) {
			this.cells[0].SetLogic(new PathStart(this));
			for(Cell cell : exits) {
				cell.SetLogic(new PathEnd());
			}
		} else {
			throw new InvalidParameterException();
		}
		selectedIndex = 0;
    }
    
    private Cell[] exits;
    private int selectedIndex;
    
    /**
     * This method chooses the path out of the fork.
     */
    public void SelectNextExit() {
    	System.out.println("SelectNextExit(): Selects the next exit of the path.");
        selectedIndex = (1 + selectedIndex) % exits.length;
    }

	@Override
	public Cell NextCell(Cell cell) {
		System.out.print("NextCell(Cell cell): Asks Path for the cell after the given one.\n");
		int index = 0;
		for (Cell localCell : cells) {
			index++;
			if(localCell == cell) break;
		}
		System.out.print("NextCell(Cell cell): Passes the next cell.  (null if the passed cell was the last one in the path)\n");
		if (index < cells.length)return cells[index];
		if (index == cells.length)return exits[selectedIndex];
		return null;
	}
	
	public Cell GetEndByIndex(int index) {
		return exits[index % exits.length];
	}

	@Override
	public Cell GetEnd() {
		return exits[selectedIndex];
	}
	
	public PathEnd GetEndLogicByIndex(int index) {
		return (PathEnd)exits[index % exits.length].GetLogic();
	}

	@Override
	public PathEnd GetEndLogic() {
		return (PathEnd)exits[selectedIndex].GetLogic();
	}
    
    

}