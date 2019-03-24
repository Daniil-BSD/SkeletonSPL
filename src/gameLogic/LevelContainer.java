package gameLogic;

import java.io.Console;
import java.util.*;

/**
 * This class stores all the levels of the game. Also, the levels are managed
 * internally by this class. The segments are joined and the tunnels are
 * constructed by it.
 */
abstract class LevelContainer {

	/**
	 * 
	 */
	private static Level level;

	private static volatile GameTick gameTick = null;

	/**
	 * 
	 */
	private static TunnelEntrance selected;

	/**
	 * @param car This method gets the cars which are arrived at the final station.
	 *            If the train is empty, the train waits at the Final Station. If
	 *            the train is not empty, the game is lost and the level is
	 *            restarted.
	 */
	public static void FinalReport(Car car) {
		System.out.println(">>FinalReport(Car car): reports to the station that the train has let all possible passengers disembark at the final station.");
		if (car.IsEmpty())
			Victory();
		else
			Defeat();
		Stop();
	}

	/**
	 * @param string Sgm1ID
	 * @param        int end1ID
	 * @param string Sgm2ID
	 * @param        int end2ID This method starts the process of joining two
	 *               segments. It is called by the Controller.
	 */
	public static void Join(String Sgm1ID, int end1ID, String Sgm2ID, int end2ID) {
		Segment segment1 = level.FindSegment(Sgm1ID);
		Segment segment2 = level.FindSegment(Sgm2ID);
		if (segment1 != null && segment2 != null) {
			if (segment1.IsEndFree(end1ID) && segment2.IsEndFree(end2ID)) {
				Cell end1 = segment1.GetFreeEnd(end1ID);
				Cell end2 = segment2.GetFreeEnd(end2ID);
				segment1.ConnectTo(end1ID, end2);
				segment2.ConnectTo(end2ID, end1);
			} else {
				System.out.println("Cannot Connect!");
			}
		} else {
			System.out.println("No such segments (one or both are missing)!");
		}

	}

	public static Segment FindSegment(String sgmID) {
		System.out.println("\t>FindSegment(string id): Searches for a segment in the current level.");
		Segment ret = level.FindSegment(sgmID);
		System.out.println("\t<FindSegment(string id): reference to a segment if it exists.(null if not)");
		return ret;
	}

	/**
	 * @return This method returns true if a tunnel entrance is selected to
	 *         construct a tunnel between two points.
	 */
	public static boolean IsEntranceSelected() {
		System.out.println("\t>IsEntranceSelected(): Checks if another entrance is selected.");
		System.out.println("\t<IsEntranceSelected(): Returns a boolean value. In this case it�s false.");
		return selected != null;
	}

	/**
	 * @param TunnelEntrance te
	 */
	public static boolean IsTunnelPossibleFrom(TunnelEntrance te) {
		System.out.println("\t>IsTunnelPossibleFrom(TunnelEntrance te1): checks if the tunnel is possible from the given entrance.");


		if (te == null || selected == null)
			{
			System.out.println("\t<IsTunnelPossibleFrom(TunnelEntrance te1): Returns a boolean value.");
			return false;
			}
		Boolean a = level.IsTunnelPossibleBetween(te, selected); //variable used for the sake of printing before and after function returns
		
		System.out.println("\t<IsTunnelPossibleFrom(TunnelEntrance te1): Returns a boolean value.");
		return 	a;
	}

	/**
	 * @param TunnelEntrance te If the tunnel is possible between the two points,
	 *                       this method clears the current tunnels of the two
	 *                       entrances, creates a new tunnel and sets it for the te
	 *                       and the selected entrance.
	 */
	public static void ConstructFrom(TunnelEntrance te) {
		System.out.println(">>ConstructFrom(TunnelEntrance te1):Construct a tunnel from the first entrance.");
		te.FullClear();
		selected.FullClear();
		Tunnel newTunnel = LevelContainer.level.GetTunnelBetween(te, selected);
		te.SetTunnel(newTunnel);
		selected.SetTunnel(newTunnel);
		selected = null;
	}

	/**
	 * @param Tunnel newTunnel This method registers a new tunnel to the level.
	 */
	public static void addTunnel(Tunnel newTunnel) {
		level.addTunnel(newTunnel);
	}

	public static void addSegment(Segment sgm) {
		level.addSegment(sgm);
	}

	public static void addLocomotive(Locomotive locomotive) {
		level.addLcomotive(locomotive);
	}

	/**
	 * @param TunnelEntrance te
	 * @param TunnelEntrance selected This method is called by the above method to
	 *                       check if the tunnel is possible between the two
	 *                       entrances.
	 * @return
	 */
	public static boolean IsTunnelPossibleBetween(TunnelEntrance te, TunnelEntrance selected) {
		System.out.println("\t>IsTunnelPossibleBetween(TunnelEntrance te1, TunnelEntrance te2): checks if the tunnel is possible between the entrances by looking into the level�s tunnel collection.");
		
		Boolean a = level.IsTunnelPossibleBetween(te, selected); //variable used for the sake of printing before and after function returns. Original body: return  level.IsTunnelPossibleBetween(te, selected);
		
		System.out.println("\t<IsTunnelPossibleBetween(TunnelEntrance te1,TunnelEntrance te2): Returns a boolean value.");
		return a;
	}

	public static boolean IsThisSelected(TunnelEntrance te) {
		return te == selected;
	}

	public static void SelectEntrance(TunnelEntrance te) {
		selected = te;

	}

	/**
	 * @param car
	 */
	public static void Derailed(Car car) {
		Defeat();
	}

	/**
	 * @param car
	 */
	public static void Collided(Car car) {

		System.out.println(">>Collided(Locomotive locomotive): tells the level that trains collided");

		Defeat();
	}

	public static void Victory(String message) {
		Victory();
	}

	public static void Victory() {
		System.out.print("Victory(): Method called whenever game is completed.\n");
		Stop();
	}

	public static void Defeat(String message) {
		Defeat();
	}

	public static void Defeat() {
		System.out.print("Defeat(): Method called whenever game is lost.");
		Stop();
	}

	public static void Start() {
		gameTick = new GameTick(10);
		gameTick.start();
	}

	public static void Load(String name) {
		// no current implementation
	}

	public static void Load(Level level) {
		LevelContainer.level = level;
	}

	public static void Stop() {
		if (gameTick != null) {
			gameTick.run = false;
			try {
				gameTick.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gameTick = null;
		}
	}

	public static void Tick() {
		System.out.println("Tick");
		level.Tick();
	}
}

class GameTick extends Thread {
	public volatile boolean run = false;
	private final int interval;

	public GameTick(int interval) {
		run = false;
		this.interval = interval;
	}

	@Override
	public void run() {
		run = true;
		while (run) {
			LevelContainer.Tick();
			try {
				sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}