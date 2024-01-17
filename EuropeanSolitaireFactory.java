package cs3500.marblesolitaire;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireView;

public class EuropeanSolitaireFactory implements MarbleSolitaireAbstractFactory {


	private int arm = 3 , x = -1, y = -1;

	/**
	 * Constructs an EuropeanSolitaireFactory instance with the default arm size of 3.
	 */
	public EuropeanSolitaireFactory() {
	}

	/**
	 * Constructs an EuropeanSolitaireFactory instance with the specified arm size.
	 *
	 * @param arm the arm size of the game board
	 */
	public EuropeanSolitaireFactory(int arm) {
		this.arm = arm;

	}

	/**
	 * Constructs an EuropeanSolitaireFactory instance with the specified arm size and empty slot position.
	 *
	 * @param arm the arm size of the game board
	 * @param x   the x-coordinate of the empty slot position
	 * @param y   the y-coordinate of the empty slot position
	 */
	public EuropeanSolitaireFactory(int arm, int x, int y) {
		this(arm);
		this.x = x;
		this.y = y;

	}

	/**
	 * Creates a new instance of the EuropeanSolitaireModel.
	 *
	 * @return a new instance of the EuropeanSolitaireModel
	 */
	@Override
	public MarbleSolitaireModel createModel() {

		if ( x == -1 || y == -1 ) {
			return new EuropeanSolitaireModel(arm);
		}

		return new EuropeanSolitaireModel(arm, x, y);

	}

	/**
	 * Creates a new instance of the MarbleSolitaireTextView, using the created model.
	 *
	 * @return a new instance of the MarbleSolitaireTextView
	 */
	@Override
	public MarbleSolitaireView createView() {

		return new MarbleSolitaireTextView(createModel());

	}

	/**
	 * Creates a new instance of the MarbleSolitaireTextView with the specified Appendable object, using the created model.
	 *
	 * @param ap the Appendable object used for rendering the view
	 * @return a new instance of the MarbleSolitaireTextView with the specified Appendable object
	 */
	@Override
	public MarbleSolitaireView createView(Appendable ap) {
		return new MarbleSolitaireTextView( createModel(), ap);

	}

}
