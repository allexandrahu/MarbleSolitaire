package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents the European Solitaire Model, which is a type of the English Solitaire game
 * @author Alexandra Hu
 * @author Matthew Li
 */
public class EuropeanSolitaireModel extends EnglishSolitaireModel implements MarbleSolitaireModel {

  /**
   * Constructs a EuropeanSolitaireModel instance with a default arm value of 3 and the center slot
   * as the empty slot.
   */
  public EuropeanSolitaireModel() {
    this(3, ((3 * 3) - 2) / 2, ((3 * 3) - 2) / 2);
  }

  /**
   * Constructs a EuropeanSolitaireModel instance with the specified arm value and the center slot
   * as the empty slot.
   *
   * @param arm the arm value representing the dimensions of the game board
   */
  public EuropeanSolitaireModel(int arm) {
    this(arm, ((arm * 3) - 2) / 2, ((arm * 3) - 2) / 2);
  }

  /**
   * Constructs a EuropeanSolitaireModel instance with the specified row and column values and a default arm value of 3.
   *
   * @param row the row value representing the initial empty slot's row position
   * @param col the column value representing the initial empty slot's column position
   */
  public EuropeanSolitaireModel(int row, int col) {
    this(3, row, col);
  }


  /**
   * Constructs a EuropeanSolitaireModel instance with the specified arm, row, and column values.
   *
   * @param arm the arm value representing the dimensions of the game board
   * @param row the row value representing the initial empty slot's row position
   * @param col the column value representing the initial empty slot's column position
   * @throws IllegalArgumentException if the arm value is even or less than 3
   */
  public EuropeanSolitaireModel(int arm, int row, int col) throws IllegalArgumentException {
    super(arm, row, col);

    // fill in missing marble
    for (int i = 1; i < arm; i++) {
      for (int j = arm - i - 1; j < 2 * arm + i - 1; j++) {

        if (slots[i][j] != SlotState.Marble) {
          score++;
          slots[i][j] = SlotState.Marble;


        }
        if (slots[j][i] != SlotState.Marble) {
          score++;
          slots[j][i] = SlotState.Marble;


        }
        if (slots[j][dim - i - 1] != SlotState.Marble) {
          score++;
          slots[j][dim - i - 1] = SlotState.Marble;


        }
      }
    }

  }

}