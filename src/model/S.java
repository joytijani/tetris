package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Piece: S Orientation: up left down right _____ _____ _____ _____ 0 | | 0| * |
 * 0| | 0| * | 1 | ** | 1| ** | 1| ** | 1| ** | 2 | ** | 2| * | 2| ** | 2| * | 3
 * |_____| 3|_____| 3|_____| 3|_____| 01234 01234 01234 01234
 */

public class S extends Tetromino {
	/**
	 * Constructor. You may want to modify
	 * 
	 * @param game used in the call to super constructor
	 */
	public S(Game game) {
		super(game, "S", Cell.GREEN);
		layout[0] = new ArrayList<>();
		layout[1] = new ArrayList<>();
		layout[2] = new ArrayList<>();
		layout[3] = new ArrayList<>();
		Collections.addAll(layout[0], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(0, 1),
				new Coordinate(-1, 1));
		Collections.addAll(layout[1], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(0, -1),
				new Coordinate(1, 1));
		Collections.addAll(layout[2], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(0, 1),
				new Coordinate(-1, 1));
		Collections.addAll(layout[3], new Coordinate(0, 0),
				new Coordinate(1, 0), new Coordinate(0, -1),
				new Coordinate(1, 1));
		orientation = 0;
	}

	@Override
	public boolean insertAt(Coordinate center) {
		int midpoint = (this.length - 1) / 2;
		center = center.translate(-(midpoint + 1), 0);
		return setOrigin(center);
	}

	/**
	 * rotates the piece counter-clockwise. See above orientation for reference
	 * on which tile to rotate around.
	 */
	//Moves piece accordingly to the 
	@Override
	public boolean rotate() {
		if (orientation == 0) {
			orientation++;
			if (setOrigin(getOrigin().translate(-1, 0)) == false) {
				orientation--;
				return false;
			} else {

				return true;
			}

		}

		if (orientation == 1) {
			orientation++;
			if (setOrigin(getOrigin().translate(1, 0)) == false) {
				orientation--;
				return false;
			} else {

				return true;
			}
		}
		if (orientation == 2) {
			orientation++;
			if (setOrigin(getOrigin().translate(-1, 0)) == false) {
				orientation--;
				return false;
			} else {

				return true;
			}
		}
		if (orientation == 3) {
			orientation = 0;
			if (setOrigin(getOrigin().translate(1, 0)) == false) {
				orientation = 3;
				;
				return false;
			} else {

				return true;
			}
		}
		return false;
	}
}
