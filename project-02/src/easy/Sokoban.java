package easy;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Sokoban extends JFrame {

    private static GameModel gameModel;
    private JPanel controlPanel;
    private JPanel canvasPanel;
    JButton resetButton = new JButton("Reset(ESC)");
    JLabel levelLabel = new JLabel("Level", SwingConstants.CENTER);
    JLabel puzzleLabel = new JLabel("Puzzle",  SwingConstants.CENTER);
    JLabel movesLabel = new JLabel("Moves",  SwingConstants.CENTER);

    JLabel levelNameLabel = new JLabel("Minicosmos",  SwingConstants.CENTER);
    JLabel puzzleNumberLabel = new JLabel("1",  SwingConstants.CENTER);
    JLabel movesNumberLabel = new JLabel("0", SwingConstants.CENTER);


    // Experiment
    private static ArrayList<BlueBox> boxes;
    private static ArrayList<Goal> goals;

    public Sokoban() {
        gameModel = new GameModel();
        canvasPanel = new CanvasPanel();

        canvasPanel.requestFocus();
        canvasPanel.setFocusable(true);
        add(canvasPanel, BorderLayout.CENTER);
        canvasPanel.addKeyListener(new CanvasPanelListener());

        controlPanel = new JPanel(new BorderLayout(5,5));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.setBackground(Color.GRAY);

        levelLabel.setForeground(Color.YELLOW);
        puzzleLabel.setForeground(Color.YELLOW);
        movesLabel.setForeground(Color.YELLOW);
        controlPanel.add(levelLabel);

        levelNameLabel.setMaximumSize(new Dimension(140, 50));
        levelNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        levelNameLabel.setBackground(Color.CYAN);
        levelNameLabel.setOpaque(true);
        controlPanel.add(levelLabel);
        controlPanel.add(levelNameLabel);

        puzzleNumberLabel.setMaximumSize(new Dimension(140, 50));
        puzzleNumberLabel.setText(gameModel.getCurLevel()+"");
        puzzleNumberLabel.setBorder(BorderFactory.createEmptyBorder(10, 55, 10, 50));
        puzzleNumberLabel.setBackground(Color.CYAN);
        puzzleNumberLabel.setOpaque(true);
        controlPanel.add(puzzleLabel);
        controlPanel.add(puzzleNumberLabel);

        movesNumberLabel.setMaximumSize(new Dimension(140, 50));
        movesNumberLabel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        movesNumberLabel.setBackground(Color.CYAN);
        movesNumberLabel.setOpaque(true);
        controlPanel.add(movesLabel);
        controlPanel.add(movesNumberLabel);

        resetButton.setMaximumSize(new Dimension(140, 50));
        resetButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.add(resetButton);
        add(controlPanel, BorderLayout.EAST);

        resetButton.addActionListener(actionEvent -> {

        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Sokoban game = new Sokoban();
            game.setTitle("MicroSokoban");
            game.setBackground(Color.BLACK);
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(1200, 1200);
            game.setLocationRelativeTo(null);
            game.setVisible(true);
        });
    }

    // Canvas panel
    private static class CanvasPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            boxes = gameModel.getBoxes();
            goals = gameModel.getGoals();

            g.setColor(Color.BLACK);
            g.fillRect(0,0,getWidth(),getHeight());

            int xLeftUpper = getWidth()/4;
            int yLeftUpper = getHeight()/4;

            int widthCell = Math.round(getWidth()/2f/gameModel.puzzle.getWidth());
            int heightCell = Math.round(getHeight()/2f/gameModel.puzzle.getHeight());

            for(int r = 0; r < gameModel.puzzle.getHeight(); ++r) {
                for(int c = 0; c < gameModel.puzzle.getWidth(); ++c) {
                    g.drawImage((new Ground()).getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, widthCell,heightCell, null);

                    char item = gameModel.puzzle.getCurElement(r,c);
                    switch (item) {
                        case '#':
                            g.drawImage((new Wall()).getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, widthCell,heightCell, null);
                            break;
                        case 'B':
                            g.setColor(Color.BLACK);
                            g.fillRect(xLeftUpper+ c * widthCell, yLeftUpper+r*heightCell, widthCell, heightCell);
                            break;
                        default:
                            break;
                    }
                }

                for(Goal goal: goals) {
                    g.drawImage(goal.getImage(), xLeftUpper+goal.getCol()*widthCell+widthCell/4, yLeftUpper+goal.getRow()*heightCell+heightCell/4,null);
                }

                for(BlueBox box: boxes) {
                    g.drawImage(box.getImage(), xLeftUpper + box.getCol()*widthCell, yLeftUpper+box.getRow()*heightCell, widthCell,heightCell,null);
                }
                g.drawImage((new Robot()).getImage(), xLeftUpper+gameModel.puzzle.getRobotCol()*widthCell+widthCell/4, yLeftUpper+gameModel.puzzle.getRobotRow()*heightCell,null);
            }
        }
    }
    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            switch(keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    gameModel.puzzle.move(0, -1, GameModel.LEFT_COLLISION);
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                case KeyEvent.VK_RIGHT:
                    gameModel.puzzle.move(0, 1, GameModel.RIGHT_COLLISION);
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                case KeyEvent.VK_UP:
                    gameModel.puzzle.move(-1, 0, GameModel.TOP_COLLISION);
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                case KeyEvent.VK_DOWN:
                    gameModel.puzzle.move(1, 0, GameModel.BOTTOM_COLLISION);
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                default:
                    break;
            }
            repaint();
            canvasPanel.requestFocus();

            if(gameModel.puzzle.isVictorious()) {
                JOptionPane.showMessageDialog(Sokoban.this, String.format("You solved puzzle %d. Moves: %d", gameModel.getCurLevel(), gameModel.getMoves()));
                gameModel.nextLevel();
                puzzleNumberLabel.setText(gameModel.getCurLevel()+"");
                movesNumberLabel.setText("0");
                repaint();
            }
        }
    }
}

