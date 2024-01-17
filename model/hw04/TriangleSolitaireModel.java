package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.AbstractSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * Represents the Triangle Solitaire Model, a variation of the marble solitaire game
 * where the game board is in the shape of a triangle.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel implements MarbleSolitaireModel {

	/**
	 * Constructs a TriangleSolitaireModel instance with default dimensions (5x5) and the top left slot as the empty slot.
	 */
	public TriangleSolitaireModel() {
		this(5, 0, 0);
	}

	/**
	 * Constructs a TriangleSolitaireModel instance with the specified dimensions and the top left slot as the empty slot.
	 *
	 * @param dimensions the dimensions of the triangular game board
	 */
	public TriangleSolitaireModel(int dimensions) {
		this(dimensions, 0, 0);
	}

	/**
	 * Constructs a TriangleSolitaireModel instance with the specified row and column values and default dimensions (5x5).
	 *
	 * @param row the row value representing the initial empty slot's row position
	 * @param col the column value representing the initial empty slot's column position
	 */
	public TriangleSolitaireModel(int row, int col) {
		this(5, row, col);
	}

	/**
	 * Constructs a TriangleSolitaireModel instance with the specified dimensions, row, and column values.
	 *
	 * @param dimensions the dimensions of the triangular game board
	 * @param row        the row value representing the initial empty slot's row position
	 * @param col        the column value representing the initial empty slot's column position
	 */
	public TriangleSolitaireModel(int dimensions, int row, int col) throws IllegalArgumentException {
		super();
		if (dimensions * row * col < 0) {
			throw new IllegalArgumentException("invalid param - negative ");
		} else if (!(row < dimensions)) {
			throw new IllegalArgumentException("row out of bound");
		} else if (col > row) {
			throw new IllegalArgumentException("col out of bound");
		}

		slots = new SlotState[dimensions][dimensions];
		this.dim = dimensions;
		this.row = row;
		this.col = col;

		// populate slots
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				if (j <= i) {
					score++;
					slots[i][j] = SlotState.Marble;
				} else {
					slots[i][j] = SlotState.Invalid;
				}

			}
		}

		slots[this.row][this.col] = SlotState.Empty;
		score--;

	}

	/**
	 * Checks if a valid move is possible from the specified row and column position.
	 *
	 * @param row the row value of the position to check
	 * @param col the column value of the position to check
	 * @return true if a valid move is possible, false otherwise
	 */
	@Override
	public boolean hasValidMove(int row, int col) {
		if (slots[row][col] != SlotState.Marble) {
			return false;
		}

		SlotState middle, target;

		try {
			// north east
			middle = slots[row - 1][col];
			target = slots[row - 2][col];
			if (middle == SlotState.Marble && target == SlotState.Empty) {
				return true;
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			// north west
			middle = slots[row - 1][col - 1];
			target = slots[row - 2][col - 2];
			if (middle == SlotState.Marble && target == SlotState.Empty) {
				return true;
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			// south east
			middle = slots[row + 1][col + 1];
			target = slots[row + 2][col + 2];
			if (middle == SlotState.Marble && target == SlotState.Empty) {
				return true;
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			// south westÏ
			middle = slots[row - 1][col];
			target = slots[row - 2][col];
			if (middle == SlotState.Marble && target == SlotState.Empty) {
				return true;
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			// left
			middle = slots[row][col - 1];
			target = slots[row][col - 2];
			if (middle == SlotState.Marble && target == SlotState.Empty) {
				return true;
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			// right
			middle = slots[row][col + 1];
			target = slots[row][col + 2];
			if (middle == SlotState.Marble && target == SlotState.Empty) {
				return true;
			}
		} catch (Exception e) {
			// do nothing
		}

		return false;
	}

}
