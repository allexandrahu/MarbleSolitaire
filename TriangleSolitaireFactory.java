package cs3500.marblesolitaire;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireView;
import cs3500.marblesolitaire.view.hw04.TriangleSolitaireTextView;

/**
 * Represents a factory for creating Triangle Solitaire models and views.
 */
public class TriangleSolitaireFactory implements MarbleSolitaireAbstractFactory {

	private int dim = 5 , x = -1, y = -1;

	/**
	 * Constructs a TriangleSolitaireFactory with the default dimension.
	 */
	public TriangleSolitaireFactory() {
	}

	/**
	 * Constructs a TriangleSolitaireFactory with the specified dimension.
	 *
	 * @param dim the dimension of the Triangle Solitaire model
	 */
	public TriangleSolitaireFactory(int dim) {
		this.dim = dim;

	}

	/**
	 * Constructs a TriangleSolitaireFactory with the specified dimension and empty slot position.
	 *
	 * @param dim the dimension of the Triangle Solitaire model
	 * @param x   the x-coordinate of the empty slot position
	 * @param y   the y-coordinate of the empty slot position
	 */
	public TriangleSolitaireFactory(int dim, int x, int y) {
		this(dim);
		this.x = x - 1;
		this.y = y - 1;

	}

	/**
	 * Creates a Triangle Solitaire model.
	 *
	 * @return the created Triangle Solitaire model
	 */
	@Override
	public MarbleSolitaireModel createModel() {

		if ( x == -1 || y == -1 ) {
			return new TriangleSolitaireModel(dim);
		}

		return new TriangleSolitaireModel(dim, x, y);

	}

	/**
	 * Creates a Triangle Solitaire view.
	 *
	 * @return the created Triangle Solitaire view
	 */
	@Override
	public MarbleSolitaireView createView() {

		return new TriangleSolitaireTextView(createModel());

	}

	/**
	 * Creates a Triangle Solitaire view with the specified appendable object.
	 *
	 * @param ap the appendable object to which the view output will be appended
	 * @return the created Triangle Solitaire view
	 */
	@Override
	public MarbleSolitaireView createView(Appendable ap) {
		return new TriangleSolitaireTextView( createModel(), ap);

	}
}
