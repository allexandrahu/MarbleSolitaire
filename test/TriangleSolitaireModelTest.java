import static org.junit.Assert.*;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import java.io.IOException;
import org.junit.Test;

import cs3500.marblesolitaire.MarbleSolitaireAbstractFactory;
import cs3500.marblesolitaire.view.hw04.TriangleSolitaireTextView;



public class TriangleSolitaireModelTest {
	TriangleSolitaireModel model = new  TriangleSolitaireModel();

	TriangleSolitaireTextView view = new TriangleSolitaireTextView(model);

	MarbleSolitaireAbstractFactory f =  MarbleSolitaireAbstractFactory.getFactory("English");

	MarbleSolitaireModel m = f.createModel();

	// tests move, gameover, renderboard, rendermessage, getscore
	@Test
	public void testPlayGame() throws Exception {
		// assertTrue(model.isGameOver());
		assertFalse(model.isGameOver());
		assertEquals(14, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 0, 0, 0);
		assertEquals(13, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 2, 2, 0);
		assertEquals(12, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 4, 2, 2);
		assertEquals(11, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 2, 4, 4);
		assertEquals(10, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(3, 1, 3, 3);
		assertEquals(9, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(4, 0, 4, 2);
		assertEquals(8, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());

		model.move(2, 0, 4, 0);
		assertEquals(7, model.getScore());
		view.renderBoard();
		view.renderMessage("score: " + model.getScore());
		assertTrue(model.isGameOver());
		view.renderMessage("Game Over. Your score is: " + model.getScore());
	}

	@Test
	public void testView() throws IOException {
		assertEquals(view.toString(), "    _\n"
				+ "   O O\n"
				+ "  O O O\n"
				+ " O O O O\n"
				+ "O O O O O");
	}
}
