package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

// TODO Add comments throughout
// TODO Look at altering code to abide by SRP for methods
// TODO Error checking

public class GameView {

  private JPanel gamePanel;
  private GridBagLayout gbLayout;
  private GridBagConstraints gbConstraints;

  public GameView() {
    JFrame gameFrame = new JFrame("Tic-Tac-Toe");
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setLayout(new GridLayout());

    gamePanel = new JPanel();
    gbLayout = new GridBagLayout();
    gbConstraints = new GridBagConstraints();

    gbConstraints.insets = new Insets(1, 1, 1, 1);
    gamePanel.setLayout(gbLayout);
    gameFrame.getContentPane().add(gamePanel);

    JButton gameSquareButton1 = new JButton("1");
    JButton gameSquareButton2 = new JButton("2");
    JButton gameSquareButton3 = new JButton("3");
    JButton gameSquareButton4 = new JButton("4");
    JButton gameSquareButton5 = new JButton("5");
    JButton gameSquareButton6 = new JButton("6");
    JButton gameSquareButton7 = new JButton("7");
    JButton gameSquareButton8 = new JButton("8");
    JButton gameSquareButton9 = new JButton("9");
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

    addComponentsToPanel(gameSquareButton1, 0, 0, 30, 50, 1);
    addComponentsToPanel(gameSquareButton2, 1, 0, 30, 50, 1);
    addComponentsToPanel(gameSquareButton3, 2, 0, 30, 50, 1);
    addComponentsToPanel(gameSquareButton4, 0, 1, 30, 50, 1);
    addComponentsToPanel(gameSquareButton5, 1, 1, 30, 50, 1);
    addComponentsToPanel(gameSquareButton6, 2, 1, 30, 50, 1);
    addComponentsToPanel(gameSquareButton7, 0, 2, 30, 50, 1);
    addComponentsToPanel(gameSquareButton8, 1, 2, 30, 50, 1);
    addComponentsToPanel(gameSquareButton9, 2, 2, 30, 50, 1);
    addComponentsToPanel(setupGameButton, 2, 3, 9, 5, 2);
    addComponentsToPanel(markerLabel, 0, 3, 0, 0, 1);
    addComponentsToPanel(playerLabel, 0, 4, 0, 0, 1);
    addComponentsToPanel(markerText, 1, 3, 30, 0, 1);
    addComponentsToPanel(playerText, 1, 4, 30, 0, 1);
    addComponentsToPanel(messageLabel, 3, 0, 0, 0, 1);
    addComponentsToPanel(messageAreaScrollPane, 3, 1, 200, 132, 2);

    gameFrame.pack();
    gameFrame.setVisible(true);
  }

  public void addComponentsToPanel(Component component, int gridXPos, int gridYPos, int iPadX, int iPadY, int gridHeight) {
    gbConstraints.gridx = gridXPos;
    gbConstraints.gridy = gridYPos;

    gbConstraints.ipadx = iPadX;
    gbConstraints.ipady = iPadY;
    gbConstraints.gridheight = gridHeight;
    gbConstraints.anchor = GridBagConstraints.SOUTHWEST;

    gbLayout.setConstraints(component, gbConstraints);
    gamePanel.add(component);
  }
}