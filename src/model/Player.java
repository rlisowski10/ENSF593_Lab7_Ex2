package model;

/**
 * <h1>Player Class</h1> The Player class instantiates a Player object, which
 * keeps track of the Player's name, opponent, game board, and mark (X or O).
 * The Play method is exposed as public, which allows the player's to make
 * moves.
 * <p>
 *
 * @author Ryan Lisowski (ID: 00257796)
 * @version 1.0
 * @since 2019-10-06
 */
class Player {

  // ============================================================
  // Member Variables
  // ============================================================

  private String name;
  private Board board;
  private Player opponent;
  private char mark;
  private String message;

  // ============================================================
  // Constructors
  // ============================================================

  /**
   * Constructor for a Player object, which sets the name and mark (X or O) for
   * the player.
   * 
   * @param name  The name of the player.
   * @param mark  The mark (X or O) for the player during the game.
   * @param board The game board.
   */
  public Player(String name, char mark, Board board) {
    this.name = name;
    this.mark = mark;
    this.board = board;
    this.setMessage(name + ", please place a mark.\n");
  }

  // ============================================================
  // Accessors
  // ============================================================

  /**
   * Gets the message for the player's status.
   * 
   * @return String The player status message.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message for the player's status.
   * 
   * @param message The player's status message.
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Sets the name of the player.
   * 
   * @param name The name of the Player.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the player.
   * 
   * @return String The name of the player.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the Board object inside of the Player object.
   * 
   * @param theBoard The game Board object.
   */
  public void setBoard(Board theBoard) {
    board = theBoard;
  }

  /**
   * Returns the playing board.
   * 
   * @return Board The playing board object.
   */
  public Board getBoard() {
    return this.board;
  }

  /**
   * Sets a reference to the opponenet Player object.
   * 
   * @param player The opponent Player object.
   */
  public void setOpponent(Player player) {
    this.opponent = player;
  }

  /**
   * Returns the opponent object.
   * 
   * @return Board The opponent Player object.
   */
  public Player getOpponent() {
    return this.opponent;
  }

  /**
   * Sets the mark (X or O) for the Player.
   * 
   * @param mark The mark (X or O) for the Player.
   */
  public void setMark(char mark) {
    this.mark = mark;
  }

  /**
   * Returns the Player's mark (X or O).
   * 
   * @return char The Player's mark (X or O).
   */
  public char getMark() {
    return this.mark;
  }

  // ============================================================
  // Public Instance Methods
  // ============================================================

  /**
   * Allows the player to make a move by placing a mark on the board, if the board
   * position is empty. Returns a message to the user if the board has a mark in
   * that position already.
   * 
   * @param row The gridbag row.
   * @param row The gridbag column.
   */
  public char makeMove(int row, int column) {
    // Checks to ensure that an existing mark has not been previously placed at the
    // chosen board location.
    setMessage(name + ", please place a mark.\n");
    char existingMark = board.getMark(row, column);

    if (existingMark == ' ') {
      getBoard().addMark(row, column, getMark());
      return getMark();
    } else {
      setMessage(getName() + ", a mark already exists at that location. Please try again.\n");
      return ' ';
    }
  }
}