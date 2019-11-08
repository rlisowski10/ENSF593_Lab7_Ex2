import view.*;
import controller.*;
import model.*;

/**
 * The main entry point into the application. Instantiates the View and Model,
 * providing them as references to the controller.
 * <p>
 *
 * @author Ryan Lisowski (ID: 00257796)
 * @version 1.0
 * @since 2019-11-06
 */
public class TicTacToeApp {

  // ============================================================
  // Static Methods
  // ============================================================

  /**
   * The main method for the application, which sets up the MVC controller with
   * the model and view.
   * 
   * @param args Unused.
   */
  public static void main(String[] args) {
    GameView gameView = new GameView();
    Referee referee = new Referee();
    GameController gameController = new GameController(gameView, referee);
  }
}