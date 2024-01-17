package cs3500.marblesolitaire;

import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireView;
import cs3500.marblesolitaire.view.hw04.TriangleSolitaireTextView;
/**
 * Represents the main class for running the Marble Solitaire game.
 * Allows the game to be played with different variations and configurations through command line arguments.
 */
public class MarbleSolitaire {

	/**
	 * The main method for running the Marble Solitaire game.
	 * Moves begin at 1 not 0 for better user experience.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		/*
		english -size 6
			produces a plus-shaped board with arm-width of 6, and initial hole in the center

		triangular -size 5 -hole 1 1
			produces a triangle-shaped board with side-length 5, and initial hole at the top

		triangular -size 4
			produces a triangle-shaped board with side-length 4, and initial hole at the top

		triangular -size 4 -hole 2 1
			produces a triangle-shaped board with side-length 4, and hole at (2, 1)

		european -size 9
			produces an octagon-shaped board with side length of 9, and the default hole in the middle

		european -hole 1 4
			produces an octagon-shaped board with default length of 3, and the hole at (1, 4)
		*/

		System.out.println("args: " + String.join(" ", args));
		System.out.println();

		if (args.length == 1 && args[0].equalsIgnoreCase("english")) {

			MarbleSolitaireModel model = new EnglishSolitaireModel();
			MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			view.renderBoard();
			controller.playGame();

		} else if (args.length == 3 && args[0].equalsIgnoreCase("english") && args[1].equalsIgnoreCase("-size")) {

			int arm = Integer.parseInt(args[2]);
			MarbleSolitaireModel model = new EnglishSolitaireModel(arm);
			MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			view.renderBoard();
			controller.playGame();

		} else if (args.length == 1 && args[0].equalsIgnoreCase("triangular")) {

			MarbleSolitaireModel model = new TriangleSolitaireModel();
			MarbleSolitaireView view = new TriangleSolitaireTextView(model, System.out);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			controller.playGame();

		} else if (args.length == 3 && args[0].equalsIgnoreCase("triangular") && args[1].equalsIgnoreCase("-size")) {

			int dim = Integer.parseInt(args[2]);

			MarbleSolitaireModel model = new TriangleSolitaireModel(dim);
			MarbleSolitaireView view = new TriangleSolitaireTextView(model);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			view.renderBoard();
			controller.playGame();

		} else if (args.length == 6 && args[0].equalsIgnoreCase("triangular") && args[1].equalsIgnoreCase("-size")
				&& args[3].equalsIgnoreCase("-hole")) {

			int dim = Integer.parseInt(args[2]);
			int x = Integer.parseInt(args[4]) - 1;
			int y = Integer.parseInt(args[5]) - 1;

			MarbleSolitaireModel model = new TriangleSolitaireModel(dim, x, y);
			MarbleSolitaireView view = new TriangleSolitaireTextView(model);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			view.renderBoard();
			controller.playGame();

		} else if (args.length == 1 && args[0].equalsIgnoreCase("european")) {

			MarbleSolitaireModel model = new EuropeanSolitaireModel(3);
			MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			view.renderBoard();
			controller.playGame();

		} else if (args.length == 3 && args[0].equalsIgnoreCase("european") && args[1].equalsIgnoreCase("-size")) {

			int arm = Integer.parseInt(args[2]);
			MarbleSolitaireModel model = new EuropeanSolitaireModel(arm);
			MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			view.renderBoard();
			controller.playGame();

		} else if (args.length == 4 && args[0].equalsIgnoreCase("european") && args[1].equalsIgnoreCase("-hole")) {

			int x = Integer.parseInt(args[2]) - 1;
			int y = Integer.parseInt(args[3]) - 1;
			MarbleSolitaireModel model = new EuropeanSolitaireModel(x, y);
			MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

			MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
					new InputStreamReader(System.in));
			view.renderBoard();
			controller.playGame();
		}

	}

}
