package controller;

import model.*;
import view.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameController {

  // ============================================================
  // Member Variables
  // ============================================================

  private GameView gameView;
  private Game game;

  // ============================================================
  // Constructors
  // ============================================================

  public GameController(GameView gameView, Game game) {
    this.gameView = gameView;
    this.game = game;

    gameView.addSetupGameListener(new addSetupGameListener());
  }

  private class addSetupGameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String[] playerNames = gameView.promptForPlayerNames();
      
      if(playerNames != null) {
        game.setupGame(playerNames[0], playerNames[1]);

        gameView.disableSetupButton();
        gameView.setPlayerMarker(game.getCurrentPlayerMark());
        gameView.setPlayerText(game.getCurrentPlayerName());
        gameView.insertTextToMessageArea(game.getCurrentPlayerMessage());
      }
    }
  }
}