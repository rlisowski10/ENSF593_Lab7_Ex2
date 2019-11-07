package model;

/**
 * <h1>Board Class</h1> The Board class instantiates the Board character array,
 * displays the tic-tac-toe board to the user in the console, adds marks, clears
 * the board before a new game, and checks for win conditions.
 * <p>
 *
 * @author Ryan Lisowski (ID: 00257796)
 * @version 1.0
 * @since 2019-10-04
 */
class Board implements Constants {

	// ============================================================
	// Member Variables
	// ============================================================

	private char theBoard[][];
	private int markCount;

	// ============================================================
	// Constructors
	// ============================================================

	/**
	 * Constuctor that assigns both the theBoard and markCount private member
	 * variables. The total number of marks (markCount) is initially assigned a
	 * value of 0, while the Board 3x3 character array (theBoard) is initially
	 * assigned with space characters in all elements (or a clean board).
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	// ============================================================
	// Accessors
	// ============================================================

	/**
	 * Gets the mark (X, O, or space) from a board array element.
	 * 
	 * @param row Row in the Board character array.
	 * @param col Column in the Board character array.
	 * @return char The character (X, O, or space) currently stored in the Board
	 *         array element.
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	// ============================================================
	// Public Instance Methods
	// ============================================================

	/**
	 * Returns a true boolean value if the board has been completely filled with
	 * marks.
	 * 
	 * @return boolean True if the board is completely full of marks.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Returns a true boolean value if the Player using X's wins.
	 * 
	 * @return boolean True if the Player using X's wins.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Returns a true boolean value if the Player using O's wins.
	 * 
	 * @return boolean True if the Player using O's wins.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Sets up the board display and structure in the console.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds either an X or O mark to the board.
	 * 
	 * @param row  The row to add the mark in.
	 * @param col  The column to add the mark in.
	 * @param mark The type of mark (X or O).
	 */
	public void addMark(int row, int col, char mark) {

		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the board of any characters in preparation for a new game.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	// ============================================================
	// Private Instance Methods
	// ============================================================

	/**
	 * Iterates through all rows, columns, and diagonals to determine if a line of
	 * marks all of the same value (X or O) exists. Returns a '1' value if so, which
	 * indicates that a winning line was found.
	 * 
	 * @param mark Either an 'X' or 'O' character, depending on the player who we
	 *             are checking win conditions for.
	 * @return int Either a '1' value for a win, or a '0' value for a no-win
	 *         condition.
	 */
	private int checkWinner(char mark) {
		int row, col;
		int result = 0;

		// Iterates through each row checking to see if all of the marks are of the mark
		// type provided as an argument (X or O). Returns a '1' value, for win, if all
		// marks are of the same type. Otherwise, a '0' value is returned.
		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		// Iterates through each column checking to see if all of the marks are of the
		// mark type provided as an argument (X or O). Returns a '1' value, for win, if
		// all marks are of the same type. Otherwise, a '0' value is returned.
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		// Iterates through the column that starts at Row 0, Column 0 and ends at Row 2,
		// Column 2, for the mark type provided as an argument (X or O). Returns a '1'
		// value, for win, if all marks are of the same type. Otherwise, a '0' value is
		// returned.
		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}

		// Iterates through the column that starts at Row 0, Column 2 and ends at Row 2,
		// Column 0, for the mark type provided as an argument (X or O). Returns a '1'
		// value, for win, if all marks are of the same type. Otherwise, a '0' value is
		// returned.
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}

		return result;
	}

	/**
	 * Displays the board column lines.
	 */
	private void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Displays the board row lines.
	 */
	private void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Displays the board spaces in between the row and column lines.
	 */
	private void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
