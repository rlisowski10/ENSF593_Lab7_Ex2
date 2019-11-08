package model;

import java.util.Scanner;

/**
 * <h1>Player Class</h1> The Player class instantiates a Player object, which
 * keeps track of the Player's name, opponent, game board, and mark (X or O).
 * The Play method is exposed as public, which allows the player's to make
 * moves, while checking for and displaying win condiitons.
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

  String name;
  Board board;
  Player opponent;
  char mark;

  // ============================================================
  // Constructors
  // ============================================================

  /**
   * Constructor for a Player object, which sets the name and mark (X or O) for
   * the player.
   * 
   * @param name The name of the player.
   * @param mark The mark (X or O) for the player during the game.
   */
  public Player(String name, char mark, Board board) {
    this.name = name;
    this.mark = mark;
    this.board = board;
  }

  // ============================================================
  // Accessors
  // ============================================================

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
   * Calls the method to allow the current player to make a move, while keeping
   * track of which player has the next turn. After each move, an updated board is
   * displayed, and win or tie conditions are checked for before allowing the next
   * player's move. If the win or tie conditions are met, a method is called to
   * display the outcome of the game to the user.
   */
  public void play() {
    //Scanner in = new Scanner(System.in);
    boolean isPlayerXTurn = true;

    // Loops through each player's turn, displaying the game board and checking to
    // see if the win or tie conditions have been met after each turn.
    while (!(getBoard().xWins() || getBoard().oWins() || getBoard().isFull())) {
      if (isPlayerXTurn) {
        makeMove(in);
        isPlayerXTurn = false;
      } else {
        getOpponent().makeMove(in);
        isPlayerXTurn = true;
      }
    }

    // Diplays the game outcome message to the console only after the win or tie
    // conditions have been met.
    in.close();
    displayGameOutcome();
  }

  // ============================================================
  // Private Instance Methods
  // ============================================================

  /**
   * Determines the final outcome of the game, and displays a message to the user
   * with this information.
   */
  private void displayGameOutcome() {
    if (getBoard().xWins())
      System.out.println("\nTHE GAME IS OVER: " + getName() + " is the winner!\n");
    else if (getBoard().oWins())
      System.out.println("\nTHE GAME IS OVER: " + getOpponent().getName() + " is the winner!\n");
    else
      System.out.println("\nTHE GAME IS OVER: There are no winners.\n");
  }

  /**
   * Calls methods to validate the user's row and column input, adding the
   * player's mark (X or O) to the board once complete. Also checks to ensure that
   * a previous mark has not already been added to the board in that location.
   * 
   * @param in The Scanner object for user input.
   */
  private void makeMove(Scanner in) {
    int row = 0;
    int column = 0;
    boolean isValid = false;

    while (!isValid) {
      row = validateGridInput(in, "row");
      column = validateGridInput(in, "column");

      // Checks to ensure that an existing mark has not been previously placed at the
      // chosen board location.
      char existingMark = board.getMark(row, column);
      if (existingMark == ' ')
        isValid = true;
      else
        System.out.println("\nERROR: A mark already exists at that location. Please try again.");
    }

    getBoard().addMark(row, column, getMark());
  }

  /**
   * Validates the user's grid input (i.e. the row or column number) to ensure
   * that it is an integer, and between 0 and 2. If it is not, a message is
   * displayed to the user that a valid number must be entered.
   * 
   * @param in          The Scanner object for user input.
   * @param rowOrColumn A String indicating whether the user input is for a board
   *                    row or column.
   * @return int A valid row or column integer.
   */
  private int validateGridInput(Scanner in, String rowOrColumn) {
    boolean isValid = false;
    int rowOrColumnValue = 0;
    String userInput = "";

    while (!isValid) {
      System.out.println("\n" + getName() + ", what " + rowOrColumn + " should your next X be placed in? ");
      userInput = in.nextLine();

      // Checks to ensure that a valid row or column number has been entered. An error
      // message is displayed if the input is not valid, and the user will have to
      // enter a valid number.
      if (userInput.equals("0") || userInput.equals("1") || userInput.equals("2")) {
        rowOrColumnValue = Integer.parseInt(userInput);
        isValid = true;
      } else {
        System.out.println("\nERROR: Please input a valid " + rowOrColumn + " number.");
      }
    }

    return rowOrColumnValue;
  }
}