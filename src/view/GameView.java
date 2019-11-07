package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

// TODO Add comments throughout
// TODO Look at refactoring code to abide by SRP for methods and classes
// TODO Error checking

public class GameView {

  private JFrame gameFrame;
  private JPanel gamePanel;
  private GridBagLayout gbLayout;
  private GridBagConstraints gbConstraints;
  private JButton[][] gameSquare;

  public GameView() {
    
    setupGameFrame();
    setupGamePanel();

    
    gameFrame.getContentPane().add(gamePanel);

    
    

    createBoardButtons(3, 3);
    setupButtons();
    setupOtherComponents();

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
  }

  private void setupOtherComponents() {
    JButton setupGameButton = new JButton("Start");
    JLabel markerLabel = new JLabel("Marker:");
    JLabel playerLabel = new JLabel("Player:");
    JLabel markerText = new JLabel("X");
    JLabel playerText = new JLabel("Ryan");
    JLabel messageLabel = new JLabel("Message Window:");
    JTextArea messageArea = new JTextArea();

    messageArea.setEditable(false);
    messageArea.setLineWrap(true);
    JScrollPane messageAreaScrollPane = new JScrollPane(messageArea);

    addComponentsToPanel(setupGameButton, 2, 3, 9, 5, 2);
    addComponentsToPanel(markerLabel, 0, 3, 0, 0, 1);
    addComponentsToPanel(playerLabel, 0, 4, 0, 0, 1);
    addComponentsToPanel(markerText, 1, 3, 30, 0, 1);
    addComponentsToPanel(playerText, 1, 4, 30, 0, 1);
    addComponentsToPanel(messageLabel, 3, 0, 0, 0, 1);
    addComponentsToPanel(messageAreaScrollPane, 3, 1, 200, 100, 2);
  }

  private void setupButtons() {
    addComponentsToPanel(gameSquare[0][0], 0, 0, 30, 50, 1);
    addComponentsToPanel(gameSquare[0][1], 1, 0, 30, 50, 1);
    addComponentsToPanel(gameSquare[0][2], 2, 0, 30, 50, 1);
    addComponentsToPanel(gameSquare[1][0], 0, 1, 30, 50, 1);
    addComponentsToPanel(gameSquare[1][1], 1, 1, 30, 50, 1);
    addComponentsToPanel(gameSquare[1][2], 2, 1, 30, 50, 1);
    addComponentsToPanel(gameSquare[2][0], 0, 2, 30, 50, 1);
    addComponentsToPanel(gameSquare[2][1], 1, 2, 30, 50, 1);
    addComponentsToPanel(gameSquare[2][2], 2, 2, 30, 50, 1);
  }

  public void addComponentsToPanel(Component component, int gridXPos, int gridYPos, int iPadX, int iPadY,
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
        gameSquare[i][j] = new JButton();
      }
    }
  }
}