package model;

/**
 * <h1>Referee Class</h1> The Referee class instantiates a Referee object, which
 * begins gameplay by setting the opponents for each of the players, displaying
 * the Board to the user, and starting play with the 'X' player.
 * <p>
 *
 * @author Ryan Lisowski (ID: 00257796)
 * @version 1.0
 * @since 2019-10-06
 */
class Referee {

  // ============================================================
  // Member Variables
  // ============================================================

  Player xPlayer;
  Player oPlayer;
  Player currentPlayer;
  Board board;

  // ============================================================
  // Accessors
  // ============================================================

  /**
   * Sets the Player object that uses the 'X' mark.
   * 
   * @param xPlayer A reference to the Player that uses the 'X' mark.
   */
  public void setxPlayer(Player xPlayer) {
    this.xPlayer = xPlayer;
  }

  /**
   * Returns the 'X' Player object.
   * 
   * @return Player The 'X' Player object.
   */
  public Player getxPlayer() {
    return this.xPlayer;
  }

  /**
   * Sets the Player object that uses the 'O' mark.
   * 
   * @param oPlayer A reference to the Player that uses the 'O' mark.
   */
  public void setoPlayer(Player oPlayer) {
    this.oPlayer = oPlayer;
  }

  /**
   * Returns the 'O' Player object.
   * 
   * @return Player The 'O' Player object.
   */
  public Player getoPlayer() {
    return this.oPlayer;
  }

  /**
   * Sets the Board object inside of the Referee object.
   * 
   * @param board The game Board object.
   */
  public void setBoard(Board board) {
    this.board = board;
  }

  /**
   * Returns the game board object.
   * 
   * @return Board The game Board object.
   */
  public Board getBoard() {
    return this.board;
  }

  public String getCurrentPlayerName() {
    return currentPlayer.getName();
  }

  public char getCurrentPlayerMark() {
    return currentPlayer.getMark();
  }

  public String getCurrentPlayerMessage() {
    return currentPlayer.getMessage();
  }

  // ============================================================
  // Public Instance Methods
  // ============================================================

  public void assignXPlayer(String name, char mark) {
    xPlayer = new Player(name, mark, board);
  }

  public void assignOPlayer(String name, char mark) {
    oPlayer = new Player(name, mark, board);
  }

  /**
   * Runs the game by setting the opponent both the 'X' and 'O' players,
   * displaying the initial board to the user, and starting play with the 'X'
   * player.
   */
  public void runTheGame() {
    getxPlayer().setOpponent(getoPlayer());
    getoPlayer().setOpponent(getxPlayer());

    currentPlayer = getxPlayer();
    getxPlayer().play();
  }
}