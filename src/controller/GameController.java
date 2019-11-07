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
  }
}