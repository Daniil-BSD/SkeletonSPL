package main;

import gameLogic.Segment;
import gameLogic.Station;
import gameLogic.Tunnel;
import gameLogic.Fork;
import gameLogic.Level;
import gameLogic.LevelContainer;
import gameLogic.LevelInitializer;

public abstract class ConsoleInterpreter {
	public static void ConsoleLine(String input) {
		String[] command = input.split(" ");
		if(command.length > 0 ) {
			if(command[0].equals("add") && command.length > 2) {
				Segment presentSegment = LevelContainer.FindSegment(command[2]);
				if(presentSegment == null) {
					Segment newSegment = null;
					if(command[1].equals("fork")) { 
						newSegment = new Fork(command[2]);	
					}
					else if(command[1].equals("station")) { 
						newSegment = new Station(command[2]);
					}
					else if(command[1].equals("tunnel")) {
						newSegment = new Tunnel(command[2]);
					}
					if(newSegment != null) {
					LevelContainer.addSegment(newSegment);
					}
				}
			}
			if(command[0].equals("init") && command.length > 1) {
				if(command[1].equals("level")) {
					LevelInitializer.LevelConstructionDemoInitializer();
					System.out.print("//Initializing Level for Level Construction Demonstration");
				}
				if(command[1].equals("fork")) {
					LevelInitializer.ForkDemoInitializer();
					System.out.print("//Initializing Level for Fork Demonstration");
				}
			}
			if(command[0].equals("quit")) {
				Main.run = false;
			}
		}

	}
}
