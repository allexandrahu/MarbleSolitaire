package cs3500.marblesolitaire.model;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an abstract class that provides common functionality for different implementations of
 * the marble solitaire game.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected int dim;
  protected int row;
  protected int col;
  protected int score = 0;
  protected SlotState[][] slots;

  /**
   * Constructs an AbstractSolitaireModel instance.
   */
  public AbstractSolitaireModel() {
    super();
  }

  /**
   * Returns the size of the game board.
   *
   * @return the size of the game board
   */
  @Override
  public int getBoardSize() {
    return dim;
  }

  /**
   * Returns the state of the slot at the specified row and column position.
   *
   * @param row the row value of the slot
   * @param col the column value of the slot
   * @return the state of the slot at the specified position
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    try {
      return slots[row][col];
    } catch (Exception e) {

      throw new IllegalArgumentException("slot out of bound");
    }
  }

  /**
   * Returns the current score of the game.
   *
   * @return the current score of the game
   */
  @Override
  public int getScore() {
    return score;
  }

  /**
   * Moves a marble from the specified source position to the specified target position.
   *
   * @param fromRow the row value of the source position
   * @param fromCol the column value of the source position
   * @param toRow   the row value of the target position
   * @param toCol   the column value of the target position
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

    SlotState middle, target, from;

    try {
      middle = slots[(fromRow + toRow) / 2][(fromCol + toCol) / 2];
      target = slots[toRow][toCol];
      from = slots[fromRow][fromCol];

      if (from != SlotState.Marble || middle != SlotState.Marble || target != SlotState.Empty) {
        throw new IllegalArgumentException("invalid move");
      }

      slots[toRow][toCol] = SlotState.Marble;
      slots[fromRow][fromCol] = SlotState.Empty;
      slots[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
      score--;

    } catch (Exception e) {

      throw new IllegalArgumentException("invalid slot location");
    }

  }

  /**
   * Checks if a valid move is possible from the specified row and column position.
   *
   * @param row the row value of the position to check
   * @param col the column value of the position to check
   * @return true if a valid move is possible, false otherwise
   */
  protected abstract boolean hasValidMove(int row, int col);

  /**
   * Checks if the game is over by determining if there are any valid moves left on the game board.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {

    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        if (hasValidMove(i, j)) {
          return false;
        }
      }
    }

    return true;
  }

}
