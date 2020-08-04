package model;

/**
Piece: I
*  Orientation:  
*        up       left      down      right       up again
*       _____     _____     _____     _____        _____
*     0|   * |  0|     |  0|  *  |  0|     | ->  0| *   |
*     1|   * |  1| ****|  1|  *  |  1|**** | ->  1| *   |
*     2|   * |  2|     |  2|  *  |  2|     | ->  2| *   |
*     3|   * |  3|     |  3|  *  |  3|     | ->  3| *   |
*     4|_____|  4|_____|  4|_____|  4|_____| ->  4|_____|
*       01234     01234     01234   01234          01234
*     
*     Notice this means that as you keep rotating it 
*     will automatically move left
*/

import java.util.ArrayList;
import java.util.Collections;

public class I extends Tetromino {
	/**
	 * Constructor. You may want to modify
	 * 
	 * @param game used in the call to super constructor
	 */
	public I(Game game) {
		super(game, "I", Cell.CYAN);
		layout[0] = new ArrayList<>();
		layout[1] = new ArrayList<>();
		layout[2] = new ArrayList<>();
		layout[3] = new ArrayList<>();
		Collections.addAll(layout[0], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(0, 2),
				new Coordinate(0, 3));
		Collections.addAll(layout[1], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(2, 0),
				new Coordinate(3, 0));
		Collections.addAll(layout[2], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(0, 2),
				new Coordinate(0, 3));
		Collections.addAll(layout[3], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(2, 0),
				new Coordinate(3, 0));
		orientation = 0;
	}

	/**
	 * rotates the piece counter-clockwise. See above orientation for reference
	 * on which tile to rotate around.
	 */
	@Override
	public boolean rotate() {
		if (orientation == 0) {
			orientation = 1;
			setOrigin(getOrigin().translate(-2, 1));
			return true;
		}
		if (orientation == 1) {
			orientation = 2;
			setOrigin(getOrigin().translate(1, -1));
			return true;
		}
		if (orientation == 2) {
			orientation = 3;
			setOrigin(getOrigin().translate(-2, 1));
			return true;
		}
		if (orientation == 3) {
			orientation = 0;
			setOrigin(getOrigin().translate(1, -1));
			return true;
		}
		return false;
	}
}
