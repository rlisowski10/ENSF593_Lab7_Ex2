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
public class Referee implements Constants {

  // ============================================================
  // Member Variables
  // ============================================================

  Player xPlayer;
  Player oPlayer;
  Player currentPlayer;
  Board board;
  Boolean isGameOver;

  // ============================================================
  // Constructors
  // ============================================================

  /**
   * The constructor for the referee object, which initially sets the isGameOver
   * status to true so that the board cannot be modified until the valid player
   * names have been added.
   */
  public Referee() {
    isGameOver = true;
  }

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

  /**
   * @return String
   */
  public String getCurrentPlayerName() {
    return currentPlayer.getName();
  }

  /**
   * @return char
   */
  public char getCurrentPlayerMark() {
    return currentPlayer.getMark();
  }

  /**
   * @return String
   */
  public String getCurrentPlayerMessage() {
    return currentPlayer.getMessage();
  }

  /**
   * @return Boolean
   */
  public Boolean getIsGameOver() {
    return isGameOver;
  }

  // ============================================================
  // Public Instance Methods
  // ============================================================

  /**
   * Assigns the X player information and marker.
   * 
   * @param name The name of the X player.
   * @param mark The marker for the X player.
   */
  public void assignXPlayer(String name, char mark) {
    xPlayer = new Player(name, mark, board);
  }

  /**
   * Assigns the O player information and marker.
   * 
   * @param name The name of the O player.
   * @param mark The marker for the O player.
   */
  public void assignOPlayer(String name, char mark) {
    oPlayer = new Player(name, mark, board);
  }

  /**
   * Allows the current player to make a move, and collects the mark for that
   * player. If the game has not ended, the mark is returned to the user
   * interface.
   * 
   * @param row    The button's gridbag position.
   * @param column The button's gridbag position.
   * @return char The character representing the marker for the player.
   */
  public char markedLocation(int row, int column) {
    char markToPlace = currentPlayer.makeMove(row, column);
    if (checkGameEndConditions()) {
      isGameOver = true;
    } else if (markToPlace != ' ' && currentPlayer == xPlayer) {
      currentPlayer = oPlayer;
    } else if (markToPlace != ' ' && currentPlayer == oPlayer) {
      currentPlayer = xPlayer;
    }

    return markToPlace;
  }

  /**
   * Sets up the game and players initially.
   * 
   * @param player1Name The name of the first player.
   * @param player2Name The name of the second player.
   */
  public void setupGame(String player1Name, String player2Name) {
    board = new Board();
    isGameOver = false;

    setBoard(board);
    assignXPlayer(player1Name, LETTER_X);
    assignOPlayer(player2Name, LETTER_O);

    setupPlayers();
  }

  /**
   * Sets up the players by setting the opponent players.
   */
  public void setupPlayers() {
    getxPlayer().setOpponent(getoPlayer());
    getoPlayer().setOpponent(getxPlayer());

    currentPlayer = getxPlayer();
  }

  // ============================================================
  // Private Instance Methods
  // ============================================================

  /**
   * Determines the final outcome of the game, and provides a message for the user
   * with this information.
   */
  private Boolean checkGameEndConditions() {
    if (getBoard().xWins() || getBoard().oWins()) {
      currentPlayer.setMessage("\nTHE GAME IS OVER: " + currentPlayer.getName() + " is the winner!\n");
      return true;
    } else if (getBoard().isFull()) {
      currentPlayer.setMessage("\nTHE GAME IS OVER: There are no winners.\n");
      return true;
    } else {
      return false;
    }
  }
}