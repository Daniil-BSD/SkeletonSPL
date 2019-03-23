package gameLogic;

public abstract class LevelInitializer {
	
	public static void ForkDemoInitializer() {
		LevelContainer.level = new Level();
		LevelContainer.addSegment(new Fork("fork"));
	}
	
	public static void LevelConstructionDemoInitializer() {
		LevelContainer.level = new Level();
	}
}
