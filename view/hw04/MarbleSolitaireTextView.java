package cs3500.marblesolitaire.view.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * Represents a text-based view of the Marble Solitaire game.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
	
	private MarbleSolitaireModel model;
	private Appendable ap;

	/**
	 * Constructs a MarbleSolitaireTextView instance with the specified model and Appendable object.
	 *
	 * @param model the MarbleSolitaireModel to be displayed
	 * @param ap    the Appendable object used for rendering the view
	 */
	public MarbleSolitaireTextView(MarbleSolitaireModel model, Appendable ap )  {
		this.model = model;
		this.ap = ap;
	}

	/**
	 * Constructs a MarbleSolitaireTextView instance with the specified model, using the standard output as the Appendable object.
	 *
	 * @param model the MarbleSolitaireModel to be displayed
	 */
	public MarbleSolitaireTextView(MarbleSolitaireModel model  )  {
		this(model, System.out);
	}

	/**
	 * Renders the current state of the game board.
	 *
	 * @throws IOException if an error occurs while writing to the Appendable object
	 */
	@Override
	public void renderBoard() throws IOException {
		
		  SlotState current ;
		
		for (int i = 0; i <  model.getBoardSize()  ; i++) {
		 			
			for (int j = 0; j<  model.getBoardSize()  ; j++) {
				current = model.getSlotAt(i, j) ;
				if (current == SlotState.Empty ) {
					ap.append('_');	
				} else if (current == SlotState.Marble  ) {
					ap.append('O');	
				} else {
					ap.append(' ');	
				}
				ap.append(' ');	
			}
			
			
			ap.append('\n');
		}
		ap.append('\n');
	}

	/**
	 * Renders the specified message.
	 *
	 * @param message the message to be rendered
	 * @throws IOException if an error occurs while writing to the Appendable object
	 */
	@Override
	public void renderMessage(String message) throws IOException {
		ap.append(message);
		ap.append('\n');
	}

	/**
	 * Returns a string representation of the game board.
	 *
	 * @return a string representation of the game board
	 */
	public String toString() {
		int size = model.getBoardSize();
		int armSize = (size + 2) / 3;
		StringBuilder b = new StringBuilder("");
		String s = "";
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (model.getSlotAt(y, x).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
					b.append(" ");
				} else {
					if (model.getSlotAt(y, x).equals(MarbleSolitaireModelState.SlotState.Marble)) {
						b.append("O");
					} else {
						b.append("_");
					}
					if (x == (size - 1)) {
						b.append("\n");
					}
					if (((0 <= y && y <= (armSize - 2)) || ((size - armSize + 1) <= y && y <= (size - 1)))
							&& model.getSlotAt(y, x + 1)
							.equals(MarbleSolitaireModelState.SlotState.Invalid)) {
						if (y != (size - 1)) {
							b.append("\n");
						}
						break;
					}
				}
				if (x != (size - 1)) {
					b.append(" ");
				}
			}
		}
		s = b.toString();
		return s;
	}

}
