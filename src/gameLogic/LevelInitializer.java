package gameLogic;

import java.awt.Color;

public abstract class LevelInitializer {

	public static void ForkDemoInitializer() {
		
		LevelContainer.Load(new Level());
		Fork fork = new Fork("fork");
		LevelContainer.addSegment(fork);
		LevelContainer.addLocomotive(new Locomotive(fork.GET_DEMO_CELL(0)));
		fork.GET_DEMO_CELL(1).SetLogic(new LoggerCell("car goes west"));
		fork.GET_DEMO_CELL(2).SetLogic(new LoggerCell("car goes east"));
	}

	public static void LevelConstructionDemoInitializer() {
		LevelContainer.Load(new Level());
	}
	
	public static void StatonDemoInitializer() {
		LevelContainer.Load(new Level());
		Station station = new Station("station", new Colors[] {Colors.Blue});
		LevelContainer.addSegment(station);
		PassengerCar passengerCar = new PassengerCar(station.GET_DEMO_CELL(0), Colors.Blue);
		Locomotive locomotive = new Locomotive(station.GET_DEMO_CELL(1));
		locomotive.attach(passengerCar);
		passengerCar.SetPath(station.path01);
		locomotive.SetPath(station.path01);
		LevelContainer.addLocomotive(locomotive);
	}
}
class LoggerCell implements CellLogic{
	
	public String output;
	
	public LoggerCell(String output) {
		this.output = output;
		
	}

	@Override
	public boolean LogicRequest(Car car) {
		System.out.println(output);
		return true;
	}
}