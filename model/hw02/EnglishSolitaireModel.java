package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.AbstractSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
/**
 * Represents the English Solitaire Model, which is a type of the Marble Solitaire game.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel implements MarbleSolitaireModel {

	protected int arm;

	/**
	 * A default constructor (no parameters)
	 */
	public EnglishSolitaireModel() {
		this(3);
	}

	/**
	 * Constructs an EnglishSolitaireModel instance with the specified arm value.
	 *
	 * @param arm the arm value representing the dimensions of the game board
	 */
	public EnglishSolitaireModel(int arm) {
		this(arm, ((arm * 3) - 2)/2, ((arm * 3) - 2)/2);
	}

	/**
	 * Constructs an EnglishSolitaireModel instance with the specified row and column values.
	 *
	 * @param row the row value representing the initial empty slot's row position
	 * @param col the column value representing the initial empty slot's column position
	 */
	public EnglishSolitaireModel(int row, int col) {
		this(3, row, col);
	}

	/**
	 * Constructs an EnglishSolitaireModel instance with the specified arm, row, and column values.
	 *
	 * @param arm the arm value representing the dimensions of the game board
	 * @param row the row value representing the initial empty slot's row position
	 * @param col the column value representing the initial empty slot's column position
	 */
	public EnglishSolitaireModel(int arm, int row, int col) throws IllegalArgumentException {
		super();

		// odd, minimum 3
		if (arm % 2 == 0 || arm < 3) {
			throw new IllegalArgumentException("invalid param - dim has to be odd int greater than 3 ");
		}

		this.dim = (arm * 3) - 2;
		this.arm = arm;
		this.row = row;
		this.col = col;

		slots = new SlotState[dim][dim];

		// populate slots
		// cut four corners
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {


				if (i  < arm -1   &&  j < arm -1 ) {
					slots[i][j] =   SlotState.Invalid;
				} else if (i  < arm -1    &&  j > dim - arm  ) {
					slots[i][j] =   SlotState.Invalid;
				} else if (i  > dim - arm  &&  j < arm -1  ) {
					slots[i][j] =   SlotState.Invalid;
				} else if (i > dim - arm   &&  j > dim - arm  ) {
					slots[i][j] =   SlotState.Invalid;
				} else {
					score++;
					slots[i][j] = SlotState.Marble;
				}

			}
		}

		try {
			if (slots[this.row][this.col] != SlotState.Marble) {
				throw new IllegalArgumentException("center location is invalid state");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("center location out of bound");
		}

		slots[this.row][this.col] = SlotState.Empty;
		score--;

	}

	/**
	 * Checks if a valid move exists from the specified row and column position.
	 *
	 * @param row the row value representing the position to check
	 * @param col the column value representing the position to check
	 * @return true if a valid move exists, false otherwise
	 */
	@Override
	public boolean hasValidMove(int row, int col) {
		if (slots[row][col] != SlotState.Marble) {
			return false;
		}

		SlotState middle, target;

		try {
			//  top
			middle = slots[row - 1][col];
			target = slots[row - 2][col];
			if (middle == SlotState.Marble && target == SlotState.Empty) {
				return true;
			}
		} catch (Exception e) {
			// do nothing
		}

		try {
			// bottom
			middle = slots[row + 1][col - 1];
			target = slots[row + 2][col - 2];
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
