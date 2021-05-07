package easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Sokoban extends JFrame {

    private static GameModel gameModel;
    private JPanel controlPanel;
    private JPanel canvasPanel;
    JButton resetButton = new JButton("Reset(ESC)");
    JLabel levelLabel = new JLabel("Level");
    JLabel levelName = new JLabel("Minicosmos");

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

        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBackground(Color.GRAY);
        levelLabel.setForeground(Color.YELLOW);
        controlPanel.add(levelLabel);
        levelName.setBackground(Color.BLUE);
        controlPanel.add(levelName);
        controlPanel.add(resetButton);
        add(controlPanel, BorderLayout.EAST);
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

                //                g.drawImage((new BlueBox()).getImage(), xLeftUpper + gameModel.puzzle.getBoxCol()*widthCell, yLeftUpper+gameModel.puzzle.getBoxRow()*heightCell,  widthCell,heightCell,null);
                //                g.drawImage((new Goal()).getImage(), xLeftUpper+gameModel.puzzle.getExitCol()*widthCell+widthCell/4, yLeftUpper+gameModel.puzzle.getExitRow()*heightCell+heightCell/4,null);

            }
        }
    }
    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            switch(keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    gameModel.puzzle.move(0, -1, GameModel.LEFT_COLLISION);
                    break;
                case KeyEvent.VK_RIGHT:
                    gameModel.puzzle.move(0, 1, GameModel.RIGHT_COLLISION);
                    break;
                case KeyEvent.VK_UP:
                    gameModel.puzzle.move(-1, 0, GameModel.TOP_COLLISION);
                    break;
                case KeyEvent.VK_DOWN:
                    gameModel.puzzle.move(1, 0, GameModel.BOTTOM_COLLISION);
                    break;
                default:
                    break;
            }
            repaint();
            canvasPanel.requestFocus();

            if(gameModel.puzzle.isVictorious()) {
                JOptionPane.showMessageDialog(Sokoban.this, String.format("Puzzle %d solved", gameModel.getCurLevel()));
                gameModel.nextLevel();
                repaint();
            }
        }
    }
}

