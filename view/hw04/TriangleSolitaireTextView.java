package cs3500.marblesolitaire.view.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import java.util.Objects;

/**
 * Represents a text-based view of the Triangle Solitaire game.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {
	
	private MarbleSolitaireModel model;
	private Appendable display;

	/**
	 * Constructs a TriangleSolitaireTextView instance with the specified model and Appendable object.
	 *
	 * @param model   the MarbleSolitaireModel to be displayed
	 * @param ap the Appendable object used for rendering the view
	 */
	public TriangleSolitaireTextView(MarbleSolitaireModel model, Appendable ap )  {
		this.model = model;
		this.display = ap;
	}

	/**
	 * Constructs a TriangleSolitaireTextView instance with the specified model, using the standard output as the Appendable object.
	 *
	 * @param model the MarbleSolitaireModel to be displayed
	 */
	public TriangleSolitaireTextView(MarbleSolitaireModel model  )  {
		this(model, System.out);
	}

	/**
	 * Renders the current state of the game board.
	 */
	@Override
	public void renderBoard() throws IOException {
		// line width: dim*2  - 1 
		int spaces = model.getBoardSize() - 1;
		
		for (int i = 0; i <  model.getBoardSize()  ; i++) {
			for (int k = 0 ; k < spaces; k++) {
				display.append(' ');
			}
			spaces-- ;
			
			SlotState current ;
			
			for (int j = 0; j<= i ; j++) {
				current = model.getSlotAt(i, j) ;

				if (current == SlotState.Empty ) {
					display.append('_');	
				} else if (current == SlotState.Marble  ) {
					display.append('O');	
				} else {
					display.append(' ');	
				}
				
				display.append(' ');	
			}
			
			
			display.append('\n');
		}
		
		display.append('\n');
		
	}

	/**
	 * Returns a string representation of the game board.
	 *
	 * @return a string representation of the game board
	 */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("");
		int dimension = model.getBoardSize();
		int stepper = 0;
		for (int y = 0; y < dimension; y++) {
			b.append(" ".repeat(Math.max(0, dimension - 1 - stepper)));
			for (int x = 0; x < dimension; x++) {
				if (model.getSlotAt(y, x).equals(MarbleSolitaireModelState.SlotState.Marble)) {
					b.append("O");
				}
				if (model.getSlotAt(y, x).equals(MarbleSolitaireModelState.SlotState.Empty)) {
					b.append("_");
				}
				if ((x == dimension - 1 && y == dimension - 1)
						|| model.getSlotAt(y, x + 1).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
					if (y != dimension - 1) {
						b.append("\n");
					}
					break;
				}
				b.append(" ");
			}
			stepper++;
		}
		return b.toString();
	}

	/**
	 * Renders the specified message.
	 *
	 * @param message the message to be rendered
	 */
	@Override
	public void renderMessage(String message) throws IOException {
		display.append(message);
		display.append('\n');
		
	}

}
