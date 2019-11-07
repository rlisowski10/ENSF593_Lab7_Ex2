package model;

import java.io.*;

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

	private Board theBoard;
	private Referee theRef;

	// ============================================================
	// Constructors
	// ============================================================

	/**
	 * Constuctor to instantiate a new board object.
	 */
	public Game() {
		theBoard = new Board();
	}

	// ============================================================
	// Public Instance Methods
	// ============================================================

	/**
	 * The method receives a Referee object, assigns it to a Referee member
	 * variable, and calls the runTheGame() method.
	 * 
	 * @param r Object of type Referee.
	 * @throws IOException Throws an Input/Output Exception if an error occurs
	 *                     during the method execution.
	 */
	public void appointReferee(Referee r) throws IOException {
		theRef = r;
		theRef.runTheGame();
	}

	// ============================================================
	// Static Methods
	// ============================================================

	/**
	 * The static main method to instantiate the Game, Player, and Referee object,
	 * read in player names, and set the players and board objects.
	 * 
	 * @param args Input arguments sent from the command line.
	 * @throws IOException Throws an Input/Output Exception if an error occurs
	 *                     during the method execution.
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);

		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);

		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);

		theGame.appointReferee(theRef);
	}
}