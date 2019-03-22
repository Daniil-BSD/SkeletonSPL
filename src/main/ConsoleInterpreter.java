package main;

import gameLogic.Segment;
import gameLogic.Station;
import gameLogic.Tunnel;
import gameLogic.Fork;
import gameLogic.Level;
import gameLogic.LevelContainer;

public abstract class ConsoleInterpreter {
	private void ConsoleLine(String input) {
		String[] command = input.split(" ");
		if(command.length > 0 ) {
			if(command[0].equals("add") && command.length>2) {
				Segment presentSegment = LevelContainer.FindSegment(command[2]);
				if(presentSegment == null) {
					Segment newSegment = null;
					if(command[1].equals("fork")) { 
						newSegment = new Fork(command[2]);
						LevelContainer.addSegment(newSegment);	
					}
					if(command[1].equals("station")) { 
						newSegment = new Station(command[2]);
						LevelContainer.addSegment(newSegment);
					}
					if(command[1].equals("tunnel")) {
						newSegment = new Tunnel(command[2]);
						LevelContainer.addSegment(newSegment);
					}
					
					
					
					
					
					
				}
			}
			
			
			
			
			
			
		}

	}
}
