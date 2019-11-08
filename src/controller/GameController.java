package controller;

import model.*;
import view.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Creates and manages the controller for the MVC architecture.
 * <p>
 *
 * @author Ryan Lisowski (ID: 00257796)
 * @version 1.0
 * @since 2019-11-06
 */
public class GameController {

  // ============================================================
  // Member Variables
  // ============================================================

  private GameView gameView;
  private Referee referee;

  // ============================================================
  // Constructors
  // ============================================================

  /**
   * The constructor the game controller, which sets up the listeners.
   * 
   * @param gameView The game view for the architecture.
   * @param referee  The referee model for the architecture.
   */
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

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addSetupGameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String[] playerNames = gameView.promptForPlayerNames();

      // If valid player names are provided, the board is setup with the player
      // information in preparation for the game commencing.
      if (playerNames != null) {
        referee.setupGame(playerNames[0], playerNames[1]);

        gameView.disableSetupButton();
        gameView.setPlayerMarker(referee.getCurrentPlayerMark());
        gameView.setPlayerText(referee.getCurrentPlayerName());
        gameView.insertTextToMessageArea(referee.getCurrentPlayerMessage());
      }
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid1Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 0;
      int column = 0;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid2Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 0;
      int column = 1;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid3Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 0;
      int column = 2;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid4Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 1;
      int column = 0;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid5Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 1;
      int column = 1;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid6Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 1;
      int column = 2;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid7Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 2;
      int column = 0;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
  private class addGameGrid8Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int row = 2;
      int column = 1;

      updateGridWithMark(row, column);
    }
  }

  /**
   * An inner class that handles the actions from a button-press event.
   */
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

  /**
   * Updates the game grid with the current player's mark.
   * 
   * @param row    The gridbag row for the button.
   * @param column The gridbag column for the button.
   */
  private void updateGridWithMark(int row, int column) {
    // If the game is not over, the game board is updates with the player's mark,
    // and the information for the next player is added to the labels and text area.
    if (!referee.getIsGameOver()) {
      char markToPlace = referee.markedLocation(row, column);
      gameView.updateGameBoard(row, column, markToPlace);
      gameView.setPlayerMarker(referee.getCurrentPlayerMark());
      gameView.setPlayerText(referee.getCurrentPlayerName());
      gameView.insertTextToMessageArea(referee.getCurrentPlayerMessage());
    }
  }
}