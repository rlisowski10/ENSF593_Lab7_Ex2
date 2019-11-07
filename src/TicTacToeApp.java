import view.*;
import controller.*;
import model.*;

public class TicTacToeApp {

  public static void main(String[] args) {
    GameView gameView = new GameView();
    Game game = new Game();
    GameController gameController = new GameController(gameView, game);
  }
}