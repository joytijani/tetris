package model;

/**
 * 
 *  Piece: L
 *  Orientation:  
 *        up       left      down      right
 *       _____     _____     _____     _____
 *     0|  *  |  0|   * |  0|  ** |  0|     |
 *     1|  *  |  1| *** |  1|   * |  1|  ***| 
 *     2|  ** |  2|     |  2|   * |  2|  *  |
 *     3|_____|  3|_____|  3|_____|  3|_____|
 *       01234     01234     01234     01234
 */

import java.util.ArrayList;
import java.util.Collections;

public class L extends Tetromino {

	public L(Game game) {
		/**
		 * Constructor. You may want to modify
		 * 
		 * @param game used in the call to super constructor
		 */
		super(game, "L", Cell.ORANGE);
		layout[0] = new ArrayList<>();
		layout[1] = new ArrayList<>();
		layout[2] = new ArrayList<>();
		layout[3] = new ArrayList<>();
		Collections.addAll(layout[0], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(0, 2),
				new Coordinate(1, 2));
		Collections.addAll(layout[1], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(-1, 1),
				new Coordinate(-2, 1));
		Collections.addAll(layout[2], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(1, 1),
				new Coordinate(1, 2));
		Collections.addAll(layout[3], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(2, 0),
				new Coordinate(0, 1));
		orientation = 0;
	}

	/**
	 * rotates the piece counter-clockwise. See above orientation for reference
	 * on which tile to rotate around.
	 */
	@Override
	public boolean rotate() {
		// TODO
		if (orientation == 0) {
			orientation = 1;
			setOrigin(getOrigin().translate(1, 0));
			return true;
		}
		if (orientation == 1) {
			orientation = 2;
			setOrigin(getOrigin().translate(-1, 0));
			return true;
		}
		if (orientation == 2) {
			orientation = 3;
			setOrigin(getOrigin().translate(0, 1));
			return true;
		}
		if (orientation == 3) {
			orientation = 0;
			setOrigin(getOrigin().translate(0, -1));
			return true;
		}
		return false;
	}
}
