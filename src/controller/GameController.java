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
  private Referee referee;

  // ============================================================
  // Constructors
  // ============================================================

  public GameController(GameView gameView, Referee referee) {
    this.gameView = gameView;
    this.referee = referee;

    gameView.addSetupGameListener(new addSetupGameListener());
    gameView.addGameGrid1Listener(new addGameGrid1Listener());
    gameView.addGameGrid2Listener(new addGameGrid2Listener());
    gameView.addGameGrid3Listener(new addGameGrid3Listener());
    gameView.addGameGrid4Listener(new addGameGrid4Listener());
    gameView.addGameGrid5Listener(new addGameGrid5Listener());
    gameView.addGameGrid6Listener(new addGameGrid6Listener());
    gameView.addGameGrid7Listener(new addGameGrid7Listener());
    gameView.addGameGrid8Listener(new addGameGrid8Listener());
    gameView.addGameGrid9Listener(new addGameGrid9Listener());
  }

  // ============================================================
  // Action Listeners
  // ============================================================

  private class addSetupGameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String[] playerNames = gameView.promptForPlayerNames();

      if (playerNames != null) {
        referee.setupGame(playerNames[0], playerNames[1]);

        gameView.disableSetupButton();
        gameView.setPlayerMarker(referee.getCurrentPlayerMark());
        gameView.setPlayerText(referee.getCurrentPlayerName());
        gameView.insertTextToMessageArea(referee.getCurrentPlayerMessage());
      }
    }
  }

  private class addGameGrid1Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 0;
      int column = 0;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid2Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 0;
      int column = 1;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid3Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 0;
      int column = 2;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid4Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 1;
      int column = 0;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid5Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 1;
      int column = 1;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid6Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 1;
      int column = 2;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid7Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 2;
      int column = 0;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid8Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 2;
      int column = 1;

      updateGridWithMark(row, column);
    }
  }

  private class addGameGrid9Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 2;
      int column = 2;

      updateGridWithMark(row, column);
    }
  }

  // ============================================================
  // Private Instance Methods
  // ============================================================

  private void updateGridWithMark(int row, int column) {
    if (!referee.getIsGameOver()) {
      char markToPlace = referee.markedLocation(row, column);
      gameView.updateGameBoard(row, column, markToPlace);
      gameView.setPlayerMarker(referee.getCurrentPlayerMark());
      gameView.setPlayerText(referee.getCurrentPlayerName());
      gameView.insertTextToMessageArea(referee.getCurrentPlayerMessage());
    }
  }
}