import static org.junit.Assert.*;


import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.*;
import cs3500.marblesolitaire.view.hw04.*;
import org.junit.Test;

public class MarbleSolitaireTextViewTest {
  private MarbleSolitaireView simpleView;
  private MarbleSolitaireView simpleView2;
  private MarbleSolitaireView simpleView3;
  private MarbleSolitaireView simpleView4;
  private MarbleSolitaireView simpleView5;
  private MarbleSolitaireView simpleView6;
  private MarbleSolitaireView simpleView7;

  private EnglishSolitaireModel simpleState = new EnglishSolitaireModel();
  private EnglishSolitaireModel simpleState2 = new EnglishSolitaireModel(2, 2);
  private EnglishSolitaireModel simpleState3 = new EnglishSolitaireModel(5);
  private EnglishSolitaireModel simpleState4 = new EnglishSolitaireModel(3, 0, 4);
  private EuropeanSolitaireModel simpleState5 = new EuropeanSolitaireModel();
  private EuropeanSolitaireModel simpleState6 = new EuropeanSolitaireModel(5);
  private TriangleSolitaireModel simpleState7 = new TriangleSolitaireModel();

  @org.junit.Test
  public void testToString() {
    simpleView = new MarbleSolitaireTextView(simpleState);
    simpleView2 = new MarbleSolitaireTextView(simpleState2);
    simpleView3 = new MarbleSolitaireTextView(simpleState3);
    simpleView4 = new MarbleSolitaireTextView(simpleState4);
    simpleView5 = new MarbleSolitaireTextView(simpleState5);
    simpleView6 = new MarbleSolitaireTextView(simpleState6);
    simpleView7 = new TriangleSolitaireTextView(simpleState7);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", simpleView.toString());
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O _ O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", simpleView2.toString());
    assertEquals("        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", simpleView3.toString());
    assertEquals("    O O _\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", simpleView4.toString());
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", simpleView5.toString());
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", simpleView6.toString());
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", simpleView7.toString());
  }
  @Test
  public void testRenderBoard() {
    Appendable acc = new StringBuilder();
    Appendable acc2 = new StringBuilder();
    Appendable acc3 = new StringBuilder();
    Appendable acc4 = new StringBuilder();
    Appendable acc5 = new StringBuilder();
    simpleView = new MarbleSolitaireTextView(simpleState, acc);
    simpleView2 = new MarbleSolitaireTextView(simpleState2, acc2);
    simpleView3 = new MarbleSolitaireTextView(simpleState3, acc3);
    simpleView4 = new MarbleSolitaireTextView(simpleState4, acc4);

    try {
      simpleView.renderBoard();
      simpleView2.renderBoard();
      simpleView3.renderBoard();
      simpleView4.renderBoard();
    } catch (Exception e){
      System.out.println("Error: " + e.getMessage() + System.lineSeparator());
    }
    assertEquals("    O O O     \n"
        + "    O O O     \n"
        + "O O O O O O O \n"
        + "O O O _ O O O \n"
        + "O O O O O O O \n"
        + "    O O O     \n"
        + "    O O O     \n\n", acc.toString());
    assertEquals("    O O O     \n"
        + "    O O O     \n"
        + "O O _ O O O O \n"
        + "O O O O O O O \n"
        + "O O O O O O O \n"
        + "    O O O     \n"
        + "    O O O     \n\n", acc2.toString());
    assertEquals("        O O O O O         \n"
        + "        O O O O O         \n"
        + "        O O O O O         \n"
        + "        O O O O O         \n"
        + "O O O O O O O O O O O O O \n"
        + "O O O O O O O O O O O O O \n"
        + "O O O O O O _ O O O O O O \n"
        + "O O O O O O O O O O O O O \n"
        + "O O O O O O O O O O O O O \n"
        + "        O O O O O         \n"
        + "        O O O O O         \n"
        + "        O O O O O         \n"
        + "        O O O O O         \n\n", acc3.toString());
    assertEquals("    O O _     \n"
        + "    O O O     \n"
        + "O O O O O O O \n"
        + "O O O O O O O \n"
        + "O O O O O O O \n"
        + "    O O O     \n"
        + "    O O O     \n\n", acc4.toString());
  }
  @Test
  public void testRenderMessage() {
    Appendable acc = new StringBuilder();
    Appendable acc2 = new StringBuilder();
    Appendable acc3 = new StringBuilder();
    Appendable acc4 = new StringBuilder();
    simpleView = new MarbleSolitaireTextView(simpleState, acc);
    simpleView2 = new MarbleSolitaireTextView(simpleState2, acc2);
    simpleView3 = new MarbleSolitaireTextView(simpleState3, acc3);
    simpleView4 = new MarbleSolitaireTextView(simpleState4, acc4);
    try {
      simpleView.renderMessage("Hello World");
      simpleView2.renderMessage("Hello World");
      simpleView3.renderMessage("Hello World");
      simpleView4.renderMessage("Hello World");
    } catch (Exception e) {

    }
    assertEquals("Hello World\n", acc.toString());
    assertEquals("Hello World\n", acc2.toString());
    assertEquals("Hello World\n", acc3.toString());
    assertEquals("Hello World\n", acc4.toString());
  }
}