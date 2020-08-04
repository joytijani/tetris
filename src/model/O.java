package model;

/**
Piece: O
*  Orientation:  
*      up      left     down     right
*     ____     ____     ____     ____
*   0|    |  0|    |  0|    |  0|    |
*   1| ** |  1| ** |  1| ** |  1| ** |   
*   2| ** |  2| ** |  2| ** |  2| ** |
*   3|____|  3|____|  3|____|  3|____|
*     0123     0123     0123     0123
*    
*/

import java.util.ArrayList;
import java.util.Collections;

public class O extends Tetromino {

	public O(Game game) {
		/**
		 * Constructor. You may want to modify
		 * 
		 * @param game used in the call to super constructor
		 */
		super(game, "O", Cell.YELLOW);
		layout[0] = new ArrayList<>();
		layout[1] = new ArrayList<>();
		layout[2] = new ArrayList<>();
		layout[3] = new ArrayList<>();
		Collections.addAll(layout[0], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(1, 0),
				new Coordinate(1, 1));
		Collections.addAll(layout[1], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(1, 0),
				new Coordinate(1, 1));
		Collections.addAll(layout[2], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(1, 0),
				new Coordinate(1, 1));
		Collections.addAll(layout[3], new Coordinate(0, 0),
				new Coordinate(0, 1), new Coordinate(1, 0),
				new Coordinate(1, 1));
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
			return true;
		}
		if (orientation == 1) {
			orientation = 2;
			return true;
		}
		if (orientation == 2) {
			orientation = 3;
			return true;
		}
		if (orientation == 3) {
			orientation = 0;
			return true;
		}
		return false;
	}

}
