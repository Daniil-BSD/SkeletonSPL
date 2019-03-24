package gameLogic;

import java.util.*;

import javax.xml.stream.events.EndDocument;

/**
 * This class is responsible for bigger units of space of the level than cells -
 * segments. A segment is a part of the level that is either a tunnel, a
 * station, or a fork. Straight and Turn classes are also derived from segment,
 * but their purpose is mainly in graphically representing the level. Other than
 * that, a segment is a sequence of cells along two paths in opposite directions
 * for the trains to traverse.
 */
abstract class Segment {

	/**
	 * Default constructor
	 */
	protected Segment() {
		this.id = "12341";
	}

	public Segment(String id) {
		this.id = id;
	}

	protected Cell cells[];

	/**
	 * This attribute stores the first cell of the segment
	 */
	protected PathEnd end0;

	/**
	 * This attribute stores the last cell of the segment.
	 */
	protected PathEnd end1;

	/**
	 * A path from B to A is stored in this attribute.
	 */
	protected Path path10;

	/**
	 * A path from A to B is stored in this attribute.
	 */
	protected Path path01;

	/**
	 * 
	 */
	protected final String id;

	/**
	 * @param segment This attribute is needed to find a needed segment in the level
	 *                by its string identifier. It is needed in order to build the
	 *                level by connecting segments.
	 */
	public boolean AreYou(String segmentID) {
		System.out.println("\t>GetID(): Getter for Id parameter.");
		System.out.println("\t<GetID(): ID of the segment as a string");
		return id.equals(segmentID);
	}

	/**
	 * @param segment This attribute is needed to find a needed segment in the level
	 *                by its reference. It is needed in order to build the level by
	 *                connecting segments.
	 */
	public boolean AreYou(Segment segment) {
		return this == segment;
	}

	/**
	 * @param cell This method returns a cell that is an edge of the segment if this
	 *             cell is free.
	 */
	public Cell GetFreeEnd(int endID) {
		if (!IsEndFree(endID))
			return null;
		if (endID == 0)
			return path01.GetStart();
		if (endID == 1)
			return path10.GetStart();
		return null;
	}

	public boolean IsEndFree(int endID) {
		if (endID == 0)
			return !end0.HasConnection();
		if (endID == 1)
			return !end1.HasConnection();
		return false;
	}

	// the one below has an error, but I do not remember how it has to be
	/**
	 * @param cell This method connects the segments by its ends, one of which is
	 *             passed on as a parameter to this method.
	 */
	public void ConnectTo(int endID, Cell end) {
		System.out.println(">>ConnectTo(Cell pathStart, int endID): assignes cell to the specified PathEnd.");
		if (!IsEndFree(endID))
			return;
		if (endID == 0)
			end0.Connect(end);
		if (endID == 1)
			end1.Connect(end);
	}

	/**
	 * This method is needed to store the segment which was selected by the player
	 * to construct a tunnel, or to control a switch at the chosen fork.
	 */
	public void Select() {
		// TODO implement here
	}

	public Path GetPathEndingWith(int endID) {
		System.out.println("\t>GetPathEndingWith(int endid): getter for a path based on the exit �endid�.");
		System.out.println("\t<GetPathEndingWith(int endid): path that ends with indecated end.");

		if (endID == 0)
			return path01;
		if (endID == 1)
			return path10;
		return null;

	}

}