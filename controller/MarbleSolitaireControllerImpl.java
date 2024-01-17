package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.nio.CharBuffer;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireView;

/**
 * The MarbleSolitaireControllerImpl class implements the MarbleSolitaireController interface and is
 * responsible for controlling the game flow of the Marble Solitaire game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable rd;

  /**
   * Constructs a MarbleSolitaireControllerImpl with the provided model, view, and readable
   *
   * @param model The MarbleSolitaireModel to be used for the game.
   * @param view  The MarbleSolitaireView to display the game.
   * @param rd    The Readable object to read user input.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
      Readable rd) {
    if (model == null) {
      throw new IllegalArgumentException("The provided model cannot be null.");
    }
    if (view == null) {
      throw new IllegalArgumentException("The provided view cannot be null.");
    } else {
      this.model = model;
      this.view = view;
      this.rd = rd;
    }
  }

  /**
   * Plays the Marble Solitaire game by reading user input, making moves, updating the view, and
   * checking for game over conditions.
   */
  @Override
  public void playGame() throws IllegalArgumentException, IOException {
    String line = "";

    CharBuffer cb = CharBuffer.allocate(255);
    StringBuilder sb = new StringBuilder();
    while (rd.read(cb) != -1) {
      cb.flip();
      line = cb.toString().trim();

      if (!line.equalsIgnoreCase("q")) {
        String[] loc = line.split(" ");

        try {
          model.move(Integer.parseInt(loc[0]) - 1, Integer.parseInt(loc[1]) - 1,
              Integer.parseInt(loc[2]) - 1, Integer.parseInt(loc[3]) - 1);
        } catch (NumberFormatException e) {
          view.renderMessage("invalid number format\n");
        } catch (IllegalArgumentException e) {
          view.renderMessage("invalid input\n");
        }

        view.renderBoard();
        view.renderMessage("score: " + model.getScore() + "\n");

        if (model.isGameOver()) {
          view.renderMessage("game over\n");
        }

      } else {
        view.renderMessage("User type q - exit\n");
        break;
      }
    }
  }
}
