package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Displays the tic-tac-toe user interface view to the user.
 * <p>
 *
 * @author Ryan Lisowski (ID: 00257796)
 * @version 1.0
 * @since 2019-11-06
 */
public class GameView {

  // ============================================================
  // Member Variables
  // ============================================================

  private JFrame gameFrame;
  private JPanel gamePanel;
  private GridBagLayout gbLayout;
  private GridBagConstraints gbConstraints;
  private JButton[][] gameSquare;
  private JButton setupGameButton;
  private JLabel markerLabel;
  private JLabel playerLabel;
  private JLabel markerText;
  private JLabel playerText;
  private JLabel messageLabel;
  private JTextArea messageArea;
  private JScrollPane messageAreaScrollPane;

  // ============================================================
  // Constructors
  // ============================================================

  /**
   * The constructor for the tic-tac-toe game view. Calls the necessary methods to
   * setup the user interface.
   */
  public GameView() {
    setupGameFrame();
    setupGamePanel();

    createBoardButtons(3, 3);
    setupButtons();
    createOtherComponents();
    setupOtherComponents();

    showGameFrame();
  }

  // ============================================================
  // Accessors
  // ============================================================

  /**
   * Sets the player text information label.
   * 
   * @param playerName The player name.
   */
  public void setPlayerText(String playerName) {
    playerText.setText(playerName);
  }

  /**
   * Sets the player marker information label.
   * 
   * @param playerMarker The player marker.
   */
  public void setPlayerMarker(char playerMarker) {
    markerText.setText(Character.toString(playerMarker));
  }

  // ============================================================
  // Action Listeners
  // ============================================================

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForSetupGameButton The action listerer for the button.
   */
  public void addSetupGameListener(ActionListener listenForSetupGameButton) {
    setupGameButton.addActionListener(listenForSetupGameButton);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid1Button The action listerer for the button.
   */
  public void addGameGrid1Listener(ActionListener listenForGameGrid1Button) {
    gameSquare[0][0].addActionListener(listenForGameGrid1Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid2Button The action listerer for the button.
   */
  public void addGameGrid2Listener(ActionListener listenForGameGrid2Button) {
    gameSquare[0][1].addActionListener(listenForGameGrid2Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid3Button The action listerer for the button.
   */
  public void addGameGrid3Listener(ActionListener listenForGameGrid3Button) {
    gameSquare[0][2].addActionListener(listenForGameGrid3Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid4Button The action listerer for the button.
   */
  public void addGameGrid4Listener(ActionListener listenForGameGrid4Button) {
    gameSquare[1][0].addActionListener(listenForGameGrid4Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid5Button The action listerer for the button.
   */
  public void addGameGrid5Listener(ActionListener listenForGameGrid5Button) {
    gameSquare[1][1].addActionListener(listenForGameGrid5Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid6Button The action listerer for the button.
   */
  public void addGameGrid6Listener(ActionListener listenForGameGrid6Button) {
    gameSquare[1][2].addActionListener(listenForGameGrid6Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid7Button The action listerer for the button.
   */
  public void addGameGrid7Listener(ActionListener listenForGameGrid7Button) {
    gameSquare[2][0].addActionListener(listenForGameGrid7Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid8Button The action listerer for the button.
   */
  public void addGameGrid8Listener(ActionListener listenForGameGrid8Button) {
    gameSquare[2][1].addActionListener(listenForGameGrid8Button);
  }

  /**
   * Creates an action listener for the button.
   * 
   * @param listenForGameGrid9Button The action listerer for the button.
   */
  public void addGameGrid9Listener(ActionListener listenForGameGrid9Button) {
    gameSquare[2][2].addActionListener(listenForGameGrid9Button);
  }

  // ============================================================
  // Public Instance Methods
  // ============================================================

  /**
   * Adds each component to the panel after setting the individual constraints
   * information.
   * 
   * @param component  The UI component to be added to the panel.
   * @param gridXPos   The x-position in the gridbag.
   * @param gridYPos   The y-position in the gridbag.
   * @param iPadX      The x-padding around the component.
   * @param iPadY      The y-padding around the component.
   * @param gridHeight The number of rows that the component will span.
   */
  public void addComponentToPanel(Component component, int gridXPos, int gridYPos, int iPadX, int iPadY,
      int gridHeight) {
    gbConstraints.gridx = gridXPos;
    gbConstraints.gridy = gridYPos;

    gbConstraints.ipadx = iPadX;
    gbConstraints.ipady = iPadY;
    gbConstraints.gridheight = gridHeight;
    gbConstraints.anchor = GridBagConstraints.SOUTHWEST;

    gbLayout.setConstraints(component, gbConstraints);
    gamePanel.add(component);
  }

  /**
   * Instantiates each of the buttons for the board.
   * 
   * @param rows    The row of the button in the gridbag.
   * @param columns The column of the button in the gridbag.
   */
  public void createBoardButtons(int rows, int columns) {
    gameSquare = new JButton[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        gameSquare[i][j] = new JButton("   ");
        gameSquare[i][j].setFocusPainted(false);
      }
    }
  }

  /**
   * A dialog prompting for the player name.
   * 
   * @param player The player number.
   * @return String The player name.
   */
  public String dialogPlayerNamePrompt(String player) {
    return JOptionPane.showInputDialog("Please input the name for Player " + player + ": ");
  }

  /**
   * A message indicating an invalid player name entry.
   */
  public void messageInvalidPlayerNames() {
    JOptionPane.showMessageDialog(null, "Error: Please re-enter the player names.");
  }

  /**
   * Gets the player names, validates them, and returns them to the calling
   * function.
   * 
   * @return String[] The player names.
   */
  public String[] promptForPlayerNames() {
    // Prompts for each player name.
    String player1 = dialogPlayerNamePrompt("1");
    String player2 = dialogPlayerNamePrompt("2");

    // Validates whether the player names are acceptable, displaying a message to
    // the user if not.
    if (player1 == null || player2 == null || player1.equals("") || player2.equals("")) {
      messageInvalidPlayerNames();
      return null;
    } else {
      String[] playerNames = { player1, player2 };
      return playerNames;
    }
  }

  /**
   * Hides the 'Setup' button once the user sets up the game.
   */
  public void disableSetupButton() {
    setupGameButton.setVisible(false);
  }

  /**
   * Inserts a new message to the text area.
   * 
   * @param message The message for insertion.
   */
  public void insertTextToMessageArea(String message) {
    messageArea.append(message + "\n");
  }

  /**
   * Updates the game board with the symbol for the player, based off of a user
   * action.
   * 
   * @param row    The gridbag row position to update.
   * @param column The gridbag column position to update.
   * @param mark   The player's mark to update in the button text.
   */
  public void updateGameBoard(int row, int column, char mark) {
    // Updates the button only if a valid marker was returned.
    if (mark == 'X' || mark == 'O') {
      gameSquare[row][column].setText(Character.toString(mark));
    }
  }

  // ============================================================
  // Private Instance Methods
  // ============================================================

  /**
   * Creates the UI components that are not buttons.
   */
  private void createOtherComponents() {
    setupGameButton = new JButton("Start");
    markerLabel = new JLabel("Marker:");
    playerLabel = new JLabel("Player:");
    markerText = new JLabel();
    playerText = new JLabel();
    messageLabel = new JLabel("Message Window:");
    messageArea = new JTextArea();

    messageArea.setEditable(false);
    messageArea.setLineWrap(true);
    messageArea.setWrapStyleWord(true);
    messageAreaScrollPane = new JScrollPane(messageArea);
  }

  /**
   * Shows the UI game frame.
   */
  private void showGameFrame() {
    gameFrame.pack();
    gameFrame.setVisible(true);
  }

  /**
   * Sets up the UI game frame.
   */
  private void setupGameFrame() {
    gameFrame = new JFrame("Tic-Tac-Toe");
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setLayout(new GridLayout());
  }

  /**
   * Sets up the UI game panel.
   */
  private void setupGamePanel() {
    gamePanel = new JPanel();
    gbLayout = new GridBagLayout();

    gbConstraints = new GridBagConstraints();
    gbConstraints.insets = new Insets(1, 1, 1, 1);

    gamePanel.setLayout(gbLayout);
    gameFrame.getContentPane().add(gamePanel);
  }

  /**
   * Adds the other UI components to the panel.
   */
  private void setupOtherComponents() {
    addComponentToPanel(setupGameButton, 2, 3, 11, 5, 2);
    addComponentToPanel(markerLabel, 0, 3, 0, 0, 1);
    addComponentToPanel(playerLabel, 0, 4, 0, 0, 1);
    addComponentToPanel(markerText, 1, 3, 30, 0, 1);
    addComponentToPanel(playerText, 1, 4, 30, 0, 1);
    addComponentToPanel(messageLabel, 3, 0, 0, 0, 1);
    addComponentToPanel(messageAreaScrollPane, 3, 1, 200, 132, 2);
  }

  /**
   * Adds the button components to the panel.
   */
  private void setupButtons() {
    addComponentToPanel(gameSquare[0][0], 0, 0, 30, 50, 1);
    addComponentToPanel(gameSquare[0][1], 1, 0, 30, 50, 1);
    addComponentToPanel(gameSquare[0][2], 2, 0, 30, 50, 1);
    addComponentToPanel(gameSquare[1][0], 0, 1, 30, 50, 1);
    addComponentToPanel(gameSquare[1][1], 1, 1, 30, 50, 1);
    addComponentToPanel(gameSquare[1][2], 2, 1, 30, 50, 1);
    addComponentToPanel(gameSquare[2][0], 0, 2, 30, 50, 1);
    addComponentToPanel(gameSquare[2][1], 1, 2, 30, 50, 1);
    addComponentToPanel(gameSquare[2][2], 2, 2, 30, 50, 1);
  }
}