package easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Sokoban extends JFrame {

    private static GameModel gameModel;

    private GameLogic game;
    private JPanel controlPanel1;
    private JPanel controlPanel2;

    private JPanel canvasPanel;
    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    public Sokoban() {

        game = new GameLogic();
        gameModel = new GameModel();
        canvasPanel = new CanvasPanel();
        canvasPanel.requestFocus();
        canvasPanel.setFocusable(true);
        add(canvasPanel, BorderLayout.CENTER);
        canvasPanel.addKeyListener(new CanvasPanelListener());

        controlPanel1 = new JPanel();
        controlPanel1.setBackground(Color.DARK_GRAY);
        controlPanel1.add(redButton);
        controlPanel1.add(greenButton);
        controlPanel1.add(blueButton);
        add(controlPanel1, BorderLayout.EAST);

        controlPanel2 = new JPanel();
        //controlPanel2.setLayout(new GridLayout());
        controlPanel2.setBackground(Color.GREEN);
        add(controlPanel2, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Sokoban game = new Sokoban();
        game.setTitle("MicroSokoban");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(1200, 1200);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }

    private static class CanvasPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int xLeftUpper = getWidth()/4;
            int yLeftUpper = getHeight()/4;

            int widthCell = Math.round(getWidth()/2f/gameModel.puzzle.getWidth());
            int heightCell = Math.round(getHeight()/2f/gameModel.puzzle.getHeight());

            for(int r = 0; r < gameModel.puzzle.getHeight(); ++r) {
                for(int c = 0; c < gameModel.puzzle.getWidth(); ++c) {
                    char item = gameModel.puzzle.getCurElement(r,c);
                    switch (item) {
                        case '#':
                            g.drawImage((new Wall()).getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, null);
                            break;
                        case ' ':
                            g.drawImage((new Ground()).getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, null);
                            break;
                        case '.':
                            g.drawImage((new Goal()).getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, null);
                            break;
                        case '$':
                            g.drawImage((new BlueBox()).getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, null);
                            break;
                        default:
                            break;
                    }

//                    Color color = gameModel.puzzle.getCurElement(r,c) =='#' ? Color.DARK_GRAY : Color.GREEN;
//                    g.setColor(color);
//                    g.fillRect(xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, widthCell, heightCell);
//
//                    g.setColor(Color.BLACK);
//                    g.drawRect(xLeftUpper+ c * widthCell, yLeftUpper+r*heightCell, widthCell, heightCell);
                }

                g.setColor(Color.YELLOW);
                g.fillOval(xLeftUpper+gameModel.puzzle.getExitCol()*widthCell, yLeftUpper+gameModel.puzzle.getExitRow()*heightCell, widthCell, heightCell);

                g.setColor(Color.RED);
                // g.fillOval(xLeftUpper+gameModel.puzzle.getRobotCol()*widthCell, yLeftUpper+gameModel.puzzle.getRobotRow()*heightCell, widthCell, heightCell);
                g.drawImage((new Robot()).getImage(), xLeftUpper+gameModel.puzzle.getRobotCol()*widthCell, yLeftUpper+gameModel.puzzle.getRobotRow()*heightCell, null);

            }

        }
    }
    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            switch(keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    gameModel.puzzle.move(0, -1);
                    break;
                case KeyEvent.VK_RIGHT:
                    gameModel.puzzle.move(0, 1);
                    break;
                case KeyEvent.VK_UP:
                    gameModel.puzzle.move(-1, 0);
                    break;
                case KeyEvent.VK_DOWN:
                    gameModel.puzzle.move(1, 0);
                    break;
                default:
                    break;
            }
            repaint();
            if(gameModel.puzzle.isVictorious()) {
                JOptionPane.showMessageDialog(Sokoban.this, String.format("Puzzle %d solved", gameModel.getCurLevel()));
                gameModel.nextLevel();
                repaint();
            }
        }
    }
}

