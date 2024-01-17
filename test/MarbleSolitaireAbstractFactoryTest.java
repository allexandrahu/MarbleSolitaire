import static org.junit.Assert.*;

import cs3500.marblesolitaire.MarbleSolitaireAbstractFactory;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import org.junit.Test;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.hw04.MarbleSolitaireView;

public class MarbleSolitaireAbstractFactoryTest {

  @Test
  public void testEnglishSolitaireFactory() throws Throwable {

    MarbleSolitaireAbstractFactory factory = MarbleSolitaireAbstractFactory.getFactory("English");

    MarbleSolitaireModel model = factory.createModel();

    MarbleSolitaireView view = factory.createView();

    Readable input = new StringReader("q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

    factory = MarbleSolitaireAbstractFactory.getFactory("English", 5);

    model = factory.createModel();

    view = factory.createView();

    input = new StringReader("q\n");

    controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

    factory = MarbleSolitaireAbstractFactory.getFactory("English", 5, 1, 6);

    model = factory.createModel();

    view = factory.createView();

    input = new StringReader("q\n");

    controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

  }


  @Test
  public void testEuropeanSolitaireFactory() throws Throwable {

    MarbleSolitaireAbstractFactory factory = MarbleSolitaireAbstractFactory.getFactory("European");

    MarbleSolitaireModel model = factory.createModel();

    MarbleSolitaireView view = factory.createView();

    Readable input = new StringReader("q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

    factory = MarbleSolitaireAbstractFactory.getFactory("European", 5);

    model = factory.createModel();

    view = factory.createView();

    input = new StringReader("q\n");

    controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

    factory = MarbleSolitaireAbstractFactory.getFactory("European", 5, 1, 8);

    model = factory.createModel();

    view = factory.createView();

    input = new StringReader("q\n");

    controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

  }

  @Test
  public void testTriangleSolitaireFactory() throws Throwable {

    MarbleSolitaireAbstractFactory factory = MarbleSolitaireAbstractFactory.getFactory("triangle");

    MarbleSolitaireModel model = factory.createModel();

    MarbleSolitaireView view = factory.createView();

    Readable input = new StringReader("q\n");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

    factory = MarbleSolitaireAbstractFactory.getFactory("triangle", 5);

    model = factory.createModel();

    view = factory.createView();

    input = new StringReader("q\n");

    controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

    factory = MarbleSolitaireAbstractFactory.getFactory("triangle", 5, 1, 8);

    model = factory.createModel();

    view = factory.createView();

    input = new StringReader("q\n");

    controller = new MarbleSolitaireControllerImpl(model, view, input);
    view.renderBoard();
    controller.playGame();

  }

}
