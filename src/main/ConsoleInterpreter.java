package main;

import gameLogic.Segment;
import gameLogic.Station;
import gameLogic.Tunnel;
import gameLogic.TunnelEntrance;
import gameLogic.Fork;
import gameLogic.Level;
import gameLogic.LevelContainer;

public abstract class ConsoleInterpreter {
	private void ConsoleLine(String input) throws Exception {
		Segment newSegment = null;
		Segment presentSegment = null;
		String[] command = input.split(" ");
		if(command.length > 0 ) {
			if(command[0].equals("add") && command.length>2) {
				presentSegment = LevelContainer.FindSegment(command[2]);
				if(presentSegment == null) {
					
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
			if(command[0].equals("select") && command.length > 1) {
				presentSegment = LevelContainer.FindSegment(command[1]);
				if(presentSegment!=null) {
					presentSegment.Select();
					
				}
			}
			if(command[0].equals("join") && !command[1].equals("entrances") && command.length > 3) {
				try {
				LevelContainer.Join(command[2], Integer.parseInt(command[3]), command[4], Integer.parseInt(command[5]));
				} catch(NumberFormatException e) {
					System.out.println("Incorrect input");
				}
			}
			if(command[0].equals("join") && command[1].equals("entrances") && command.length > 4) {
				Segment entrance1 = LevelContainer.FindSegment(command[2]);
				Segment entrance2 = LevelContainer.FindSegment(command[3]);
				if(entrance1.getClass() == TunnelEntrance.class && entrance2.getClass() == TunnelEntrance.class) {
					if(!LevelContainer.IsTunnelPossibleBetween((TunnelEntrance)entrance1, (TunnelEntrance)entrance2)) {
						Tunnel tunnel = new Tunnel((TunnelEntrance)entrance1, (TunnelEntrance)entrance2);
						LevelContainer.addTunnel(tunnel);
					
					}
					
				}else{
					throw new Exception("Incorrect segments");
					
				}
				
			}
			if(command[0].equals("place") && command.length > 4 ) {
				Segment entrance = LevelContainer.FindSegment(command[1]);
				try {
				entrance.GetPathEndingWith(Integer.parseInt(command[2]));
				}catch(NumberFormatException e) {
					System.out.println("Incorrect input");
				}
				//тут какая то жирнющая логика, сделай плес
			}
			if(command[0].equals("start")) {
				
				LevelContainer.Start();
				
			}
			if(command[0].equals("stop")) {
				
				LevelContainer.Stop();
				
			}
			if(command[0].equals("load") && command.length>1) {
				
				LevelContainer.Load(command[1]);
				
			}
			
			
			
			
			
		}

	}
}
