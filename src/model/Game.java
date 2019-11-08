package model;

/**
 * <h1>Game Class</h1> The Game class contains member variables for the Board
 * and Referee objects, which are instantiated by the constructor and assigned
 * by a method, respectively. The tic-tack-toe game runs from the Static
 * Main(...) function provided within this class.
 * <p>
 *
 * @author Ryan Lisowski (ID: 00257796)
 * @version 1.0
 * @since 2019-10-04
 */
public class Game implements Constants {

	// ============================================================
	// Member Variables
	// ============================================================

	private Board board;
	private Referee referee;

	// ============================================================
	// Constructors
	// ============================================================

	public void setupGame(String player1Name, String player2Name) {
		board = new Board();
		referee = new Referee();

		referee.setBoard(board);
		referee.assignXPlayer(player1Name, LETTER_X);
		referee.assignOPlayer(player2Name, LETTER_O);

		referee.runTheGame();
	}

	// ============================================================
	// Accessors
	// ============================================================

	public String getCurrentPlayerName() {
		return referee.getCurrentPlayerName();
	}

	public char getCurrentPlayerMark() {
		return referee.getCurrentPlayerMark();
	}

	public String getCurrentPlayerMessage() {
		return referee.getCurrentPlayerMessage();
	}

	// ============================================================
	// Public Instance Methods
	// ============================================================

}