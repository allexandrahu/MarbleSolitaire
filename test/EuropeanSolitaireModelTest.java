import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.marblesolitaire.MarbleSolitaireAbstractFactory;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import java.io.IOException;
import org.junit.Test;

import cs3500.marblesolitaire.view.hw04.MarbleSolitaireTextView;

public class EuropeanSolitaireModelTest {
  EuropeanSolitaireModel simpleState = new EuropeanSolitaireModel();
  EuropeanSolitaireModel simpleState2 = new EuropeanSolitaireModel(2, 2);
  EuropeanSolitaireModel simpleState3 = new EuropeanSolitaireModel(5);
  EuropeanSolitaireModel simpleState4 = new EuropeanSolitaireModel(3, 0, 4);
  EnglishSolitaireModel model = new EuropeanSolitaireModel(3);
  MarbleSolitaireTextView view = new MarbleSolitaireTextView(model);

  // tests move, gameover, renderboard, rendermessage, getscore
  @Test
  public void testPlayGame() throws Exception {


    // assertTrue(model.isGameOver());
    assertFalse(model.isGameOver());
    assertEquals(36, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(3, 1, 3, 3);
    assertEquals(35, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(1, 1, 3, 1);
    assertEquals(34, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(1, 2, 3, 2);
    assertEquals(33, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(4, 2, 2, 2);
    assertEquals(32, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(4, 1, 2, 1);
    assertEquals(31, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(3, 4, 3, 2);
    assertEquals(30, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(4, 4, 4, 2);
    assertEquals(29, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(1, 4, 1, 2);
    assertEquals(28, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(3, 6, 3, 4);
    assertEquals(27, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(4, 6, 4, 4);
    assertEquals(26, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(6, 3, 4, 3);
    assertEquals(25, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(5, 1, 5, 3);
    assertEquals(24, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(5, 3, 3, 3);
    assertEquals(23, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(3, 3, 1, 3);
    assertEquals(22, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(3, 4, 1, 4);
    assertEquals(21, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(0, 3, 2, 3);
    assertEquals(20, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(0, 4, 2, 4);
    assertEquals(19, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    assertFalse(model.isGameOver());
    model.move(5, 4, 3, 4);
    assertEquals(18, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(3, 4, 1, 4);
    assertEquals(17, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(1, 5, 1, 3);
    assertEquals(16, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(1, 2, 1, 4);
    assertEquals(15, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(2, 2, 2, 4);
    assertEquals(14, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(2, 0, 2, 2);
    assertEquals(13, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(2, 5, 2, 3);
    assertEquals(12, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(2, 3, 2, 1);
    assertEquals(11, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(4, 0, 2, 0);
    assertEquals(10, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(4, 2, 2, 2);
    assertEquals(9, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(2, 1, 2, 3);
    assertEquals(8, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(6, 4, 4, 6);
    assertEquals(7, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    model.move(1, 4, 3, 2);
    assertEquals(6, model.getScore());
    view.renderBoard();
    view.renderMessage("score: " + model.getScore());

    assertTrue(model.isGameOver());
    view.renderMessage("Game Over. Your score is: " + model.getScore());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(SlotState.Marble, simpleState.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, simpleState2.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, simpleState3.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, simpleState4.getSlotAt(2, 2));
    try {
      simpleState.getSlotAt(10, 10);
    } catch (Exception e) {
      System.out.println("Index out of range");
    }

  }

  @Test
  public void testView() throws IOException {
    assertEquals(view.toString(), "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O");
  }

}
