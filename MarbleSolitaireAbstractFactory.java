package cs3500.marblesolitaire;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireView;

/**
 * Represents an abstract factory for creating Marble Solitaire models and views.
 */
public interface MarbleSolitaireAbstractFactory {

	/**
	 * Creates a Marble Solitaire model.
	 *
	 * @return the created Marble Solitaire model
	 */
	MarbleSolitaireModel createModel();

	/**
	 * Creates a Marble Solitaire view.
	 *
	 * @return the created Marble Solitaire view
	 */
	MarbleSolitaireView createView();

	/**
	 * Creates a Marble Solitaire view with the specified appendable object.
	 *
	 * @param ap the appendable object to which the view output will be appended
	 * @return the created Marble Solitaire view
	 */
	MarbleSolitaireView createView(Appendable ap);

	/**
	 * Gets a MarbleSolitaireAbstractFactory instance based on the specified name.
	 *
	 * @param name the name of the factory
	 * @return the MarbleSolitaireAbstractFactory instance corresponding to the name,
	 *         or null if the name is not recognized
	 */
	static MarbleSolitaireAbstractFactory getFactory(String name) {
		if (name.equals("triangle")) {
			return new TriangleSolitaireFactory();
		} else if (name.equals("English")) {
			return new EnglishSolitaireFactory();
		} else if (name.equals("European")) {
			return new EuropeanSolitaireFactory();
		}

		return null;

	}

	/**
	 * Gets a MarbleSolitaireAbstractFactory instance based on the specified name and arm size.
	 *
	 * @param name the name of the factory
	 * @param arm  the arm size for the model
	 * @return the MarbleSolitaireAbstractFactory instance corresponding to the name and arm size,
	 *         or null if the name is not recognized
	 */
	static MarbleSolitaireAbstractFactory getFactory(String name, int arm) {

		if (name.equals("triangle")) {
			return new TriangleSolitaireFactory(arm);
		} else if (name.equals("English")) {
			return new EnglishSolitaireFactory(arm);
		} else if (name.equals("European")) {
			return new EuropeanSolitaireFactory(arm);
		}

		return null;

	}

	/**
	 * Gets a MarbleSolitaireAbstractFactory instance based on the specified name, arm size, and empty slot position.
	 *
	 * @param name the name of the factory
	 * @param arm  the arm size for the model
	 * @param x    the x-coordinate of the empty slot position
	 * @param y    the y-coordinate of the empty slot position
	 * @return the MarbleSolitaireAbstractFactory instance corresponding to the name, arm size, and empty slot position,
	 *         or null if the name is not recognized
	 */
	static MarbleSolitaireAbstractFactory getFactory(String name, int arm, int x, int y) {

		if (name.equals("triangle")) {
			return new TriangleSolitaireFactory();
		} else if (name.equals("English")) {
			return new EnglishSolitaireFactory(arm, x, y);
		} else if (name.equals("European")) {
			return new EuropeanSolitaireFactory(arm, x, y);
		}

		return null;

	}
}
