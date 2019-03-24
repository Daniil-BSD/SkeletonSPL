package gameLogic;

import java.io.Console;
import java.util.*;

/**
 * This class stores all the levels of the game. Also, the levels are managed
 * internally by this class. The segments are joined and the tunnels are
 * constructed by it.
 */
public abstract class LevelContainer {

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
		System.out.print(
				"FinalReport(Car car): reports to the station that the train has let all possible passengers disembark at the final station.\n");
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
				segment1.ConnectTo(segment2.GetFreeEnd(end2ID));
				segment2.ConnectTo(segment1.GetFreeEnd(end1ID));

			}
			System.out.println("Already connected!");
		}
		if (segment1 == null || segment2 == null) {
			System.out.println("Missing Segments!");

		}

	}

	public static Segment FindSegment(String sgmID) {
		System.out.println("FindSegment(string id): Looks for a segment with the same id.\n");

		System.out.println("FindSegment(string id): reference to the first entrance(null if does not exist.)\n");
		return level.FindSegment(sgmID);
	}

	/**
	 * @return This method returns true if a tunnel entrance is selected to
	 *         construct a tunnel between two points.
	 */
	public static boolean IsEntranceSelected() {
		System.out.println(">IsEntranceSelected(): Checks if another entrance is selected.");
		System.out.println("<IsEntranceSelected(): Returns a boolean value. In this case it�s false.");
		return selected != null;
	}

	/**
	 * @param TunnelEntrance te
	 */
	public static boolean IsTunnelPossibleFrom(TunnelEntrance te) {
		System.out.println(
				">IsTunnelPossibleFrom(TunnelEntrance te1): checks if the tunnel is possible from the given entrance.\n");

		System.out.println(">IsTunnelPossibleFrom(TunnelEntrance te1): Returns a boolean value.\n");
		return level.IsTunnelPossibleBetween(te, selected);
	}

	/**
	 * @param TunnelEntrance te If the tunnel is possible between the two points,
	 *                       this method clears the current tunnels of the two
	 *                       entrances, creates a new tunnel and sets it for the te
	 *                       and the selected entrance.
	 */
	public static void ConstructFrom(TunnelEntrance te) {
		System.out.println(">>ConstructFrom(TunnelEntrance te1): Construct a tunnel from the first entrance.\n");
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
		return level.IsTunnelPossibleBetween(te, selected);
	}

	public static boolean IsThisSelected(TunnelEntrance te) {
		if (selected == te) {
			return true;

		}
		return false;
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
		System.out.print("Collided(Locomotive locomotive): tells the level that trains collided");
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