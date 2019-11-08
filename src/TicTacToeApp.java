import view.*;
import controller.*;
import model.*;

public class TicTacToeApp {

  public static void main(String[] args) {
    GameView gameView = new GameView();
    Referee referee = new Referee();
    GameController gameController = new GameController(gameView, referee);
  }
}