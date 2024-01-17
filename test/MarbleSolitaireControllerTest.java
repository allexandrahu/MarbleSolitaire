import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireView;

public class MarbleSolitaireControllerTest {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable input;
  private Appendable output;
  private Scanner scanner;
  private MarbleSolitaireController controller;

  MarbleSolitaireModel m1 = new EnglishSolitaireModel();
  MarbleSolitaireView m1View = new MarbleSolitaireTextView(m1);

  /**
   * Tests constructor given invalid & valid arguments
   */
  @Test
  public void testConstructor() {
    // tests null model
    try {
      new MarbleSolitaireControllerImpl(null, m1View, input);
      fail("Expected IllegalArgumentException for null model");
    } catch (IllegalArgumentException e) {
      // Exception caught as expected
    }

    // tests null view
    try {
      new MarbleSolitaireControllerImpl(m1, null, input);
      fail("Expected IllegalArgumentException for null view");
    } catch (IllegalArgumentException e) {
      // Exception caught as expected
    }

    // tests valid inputs for controller constructor
    try {
      new MarbleSolitaireControllerImpl(m1, m1View, input);
    } catch (IllegalArgumentException e) {
      fail("Valid constructor should not throw an exception");
    }
  }

  @Test
  public void testQuitGame() throws IOException {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    Readable quit = new StringReader("q");
    Appendable destination = new StringBuilder();
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1, destination);
    MarbleSolitaireController controller1 = new MarbleSolitaireControllerImpl(model1, view1,
        quit);
    controller1.playGame();

    assertEquals("User type q - exit\n\n", destination.toString());
  }

  @Test
  public void testInvalidMove() throws IOException {

    Readable readable = new StringReader("5 5 5 5");
    Appendable appen = new StringBuilder();

    MarbleSolitaireView invalidModelView = new MarbleSolitaireTextView(m1, appen);
    MarbleSolitaireController controller =
        new MarbleSolitaireControllerImpl(m1, invalidModelView, readable);


    controller.playGame();

    assertTrue(appen.toString().contains("invalid input"));
    //  assertEquals(model.getScore(), 32);
  }

  @Test
  public void playGame() {
    model = new EnglishSolitaireModel();
    output = new StringBuilder();
    view = new MarbleSolitaireTextView(model, output);
    input = new StringReader("4 2 4 4");
    scanner = new Scanner(input);
    controller = new MarbleSolitaireControllerImpl(model, view, input);
    try {
      controller.playGame();
      assertEquals(model.getScore(), 31);
      assertEquals("    O O O     \n"
          + "    O O O     \n"
          + "O O O O O O O \n"
          + "O _ _ O O O O \n"
          + "O O O O O O O \n"
          + "    O O O     \n"
          + "    O O O     \n"
          + "\n"
          + "score: 31\n\n", output.toString());

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage() + System.lineSeparator());
    }
  }
}
