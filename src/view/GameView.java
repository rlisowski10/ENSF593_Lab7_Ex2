package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionListener;

// TODO Add comments throughout
// TODO Look at refactoring code to abide by SRP for methods and classes
// TODO Error checking

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

  public void setPlayerText(String playerName) {
    playerText.setText(playerName);
  }

  public void setPlayerMarker(char playerMarker) {
    markerText.setText(Character.toString(playerMarker));
  }

  // ============================================================
  // Action Listeners
  // ============================================================

  public void addSetupGameListener(ActionListener listenForSetupGameButton) {
    setupGameButton.addActionListener(listenForSetupGameButton);
  }

  public void addGameGrid1Listener(ActionListener listenForGameGrid1Button) {
    gameSquare[0][0].addActionListener(listenForGameGrid1Button);
  }

  public void addGameGrid2Listener(ActionListener listenForGameGrid2Button) {
    gameSquare[0][1].addActionListener(listenForGameGrid2Button);
  }

  public void addGameGrid3Listener(ActionListener listenForGameGrid3Button) {
    gameSquare[0][2].addActionListener(listenForGameGrid3Button);
  }

  public void addGameGrid4Listener(ActionListener listenForGameGrid4Button) {
    gameSquare[1][0].addActionListener(listenForGameGrid4Button);
  }

  public void addGameGrid5Listener(ActionListener listenForGameGrid5Button) {
    gameSquare[1][1].addActionListener(listenForGameGrid5Button);
  }

  public void addGameGrid6Listener(ActionListener listenForGameGrid6Button) {
    gameSquare[1][2].addActionListener(listenForGameGrid6Button);
  }

  public void addGameGrid7Listener(ActionListener listenForGameGrid7Button) {
    gameSquare[2][0].addActionListener(listenForGameGrid7Button);
  }

  public void addGameGrid8Listener(ActionListener listenForGameGrid8Button) {
    gameSquare[2][1].addActionListener(listenForGameGrid8Button);
  }

  public void addGameGrid9Listener(ActionListener listenForGameGrid9Button) {
    gameSquare[2][2].addActionListener(listenForGameGrid9Button);
  }

  // ============================================================
  // Public Instance Methods
  // ============================================================

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

  public void createBoardButtons(int rows, int columns) {
    gameSquare = new JButton[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        gameSquare[i][j] = new JButton("   ");
      }
    }
  }

  public String dialogPlayerNamePrompt(String player) {
    return JOptionPane.showInputDialog("Please input the name for Player " + player + ": ");
  }

  public void messageInvalidPlayerNames() {
    JOptionPane.showMessageDialog(null, "Error: Please re-enter the player names.");
  }

  public String[] promptForPlayerNames() {
    String player1 = dialogPlayerNamePrompt("1");
    String player2 = dialogPlayerNamePrompt("2");

    if (player1 == null || player2 == null || player1.equals("") || player2.equals("")) {
      messageInvalidPlayerNames();
      return null;
    } else {
      String[] playerNames = { player1, player2 };
      return playerNames;
    }
  }

  public void disableSetupButton() {
    setupGameButton.setVisible(false);
  }

  public void insertTextToMessageArea(String message) {
    messageArea.append(message + "\n");
  }

  public void updateGameBoard(int row, int column, char mark) {
    if (mark != ' ') {
      gameSquare[row][column].setText(Character.toString(mark));
    }
  }

  // ============================================================
  // Private Instance Methods
  // ============================================================

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

  private void showGameFrame() {
    gameFrame.pack();
    gameFrame.setVisible(true);
  }

  private void setupGameFrame() {
    gameFrame = new JFrame("Tic-Tac-Toe");
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setLayout(new GridLayout());
  }

  private void setupGamePanel() {
    gamePanel = new JPanel();
    gbLayout = new GridBagLayout();
    gbConstraints = new GridBagConstraints();
    gbConstraints.insets = new Insets(1, 1, 1, 1);
    gamePanel.setLayout(gbLayout);
    gameFrame.getContentPane().add(gamePanel);
  }

  private void setupOtherComponents() {
    addComponentToPanel(setupGameButton, 2, 3, 11, 5, 2);
    addComponentToPanel(markerLabel, 0, 3, 0, 0, 1);
    addComponentToPanel(playerLabel, 0, 4, 0, 0, 1);
    addComponentToPanel(markerText, 1, 3, 30, 0, 1);
    addComponentToPanel(playerText, 1, 4, 30, 0, 1);
    addComponentToPanel(messageLabel, 3, 0, 0, 0, 1);
    addComponentToPanel(messageAreaScrollPane, 3, 1, 200, 132, 2);
  }

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