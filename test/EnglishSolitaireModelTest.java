import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.marblesolitaire.MarbleSolitaireAbstractFactory;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import java.io.IOException;
import org.junit.Test;

import cs3500.marblesolitaire.view.hw04.MarbleSolitaireTextView;

public class EnglishSolitaireModelTest {
	EnglishSolitaireModel model = new  EnglishSolitaireModel();
	MarbleSolitaireTextView view = new MarbleSolitaireTextView(model);
	EnglishSolitaireModel simpleState = new EnglishSolitaireModel();
	EnglishSolitaireModel simpleState2 = new EnglishSolitaireModel(2, 2);
	EnglishSolitaireModel simpleState3 = new EnglishSolitaireModel(5);
	EnglishSolitaireModel simpleState4 = new EnglishSolitaireModel(3, 0, 4);

	@Test
	public void testIsGameOver() {
		assertEquals(false, simpleState.isGameOver());
		assertEquals(false, simpleState2.isGameOver());
		assertEquals(false, simpleState3.isGameOver());
		assertEquals(false, simpleState4.isGameOver());

	}

	@Test
	public void testGetBoardSize() {
		assertEquals(7, simpleState.getBoardSize());
		assertEquals(7, simpleState2.getBoardSize());
		assertEquals(13, simpleState3.getBoardSize());
		assertEquals(7, simpleState4.getBoardSize());
	}

	@Test
	public void testGetSlotAt() {
		assertEquals(SlotState.Marble, simpleState.getSlotAt(2, 2));
		assertEquals(SlotState.Empty, simpleState2.getSlotAt(2, 2));
		assertEquals(SlotState.Invalid, simpleState3.getSlotAt(2, 2));
		assertEquals(SlotState.Marble, simpleState4.getSlotAt(2, 2));
		try {
			simpleState.getSlotAt(10, 10);
		} catch (Exception e) {
			System.out.println("Index out of range");
		}

	}

	@Test
	public void testGetScore() {
		assertEquals(32, simpleState.getScore());
		assertEquals(32, simpleState2.getScore());
		assertEquals(104, simpleState3.getScore());
		assertEquals(32, simpleState4.getScore());

	}

	// tests move, gameover, renderboard, rendermessage, getscore
	@Test
	public void testPlayGame() throws Exception {

		// assertTrue(model.isGameOver());
		assertFalse(model.isGameOver());
		assertEquals(32, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(1, 3, 3, 3);
		assertEquals(31, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 1, 2, 3);
		assertEquals(30, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(0, 2, 2, 2);
		assertEquals(29, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(0, 4, 0, 2);
		assertEquals(28, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(3, 2, 1, 2);
		assertEquals(27, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(0, 2, 2, 2);
		assertEquals(26, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 3, 2, 1);
		assertEquals(25, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 0, 2, 2);
		assertEquals(24, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 4, 0, 4);
		assertEquals(23, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 6, 2, 4);
		assertEquals(22, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 0, 2, 0);
		assertEquals(21, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 1, 2, 1);
		assertEquals(20, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 3, 2, 3);
		assertEquals(19, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 5, 2, 5);
		assertEquals(18, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 6, 2, 6);
		assertEquals(17, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(3, 4, 1, 4);
		assertEquals(16, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 6, 2, 4);
		assertEquals(15, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(5, 2, 3, 2);
		assertEquals(14, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(5, 4, 3, 4);
		assertEquals(13, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 4, 4, 4);
		assertEquals(12, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 2, 4, 2);
		assertEquals(11, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 0, 2, 2);
		assertEquals(10, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 2, 2, 4);
		assertEquals(9, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(1, 4, 3, 4);
		assertEquals(8, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 4, 2, 4);
		assertEquals(7, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(6, 3, 4, 3);
		assertEquals(6, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 2, 4, 4);
		assertEquals(5, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		assertTrue(model.isGameOver());
		view.renderMessage("Game Over. Your score is: " + model.getScore());
	}

	@Test
	public void testView() throws IOException {
		assertEquals(view.toString(), "    O O O\n"
				+ "    O O O\n"
				+ "O O O O O O O\n"
				+ "O O O _ O O O\n"
				+ "O O O O O O O\n"
				+ "    O O O\n"
				+ "    O O O");
	}
}
