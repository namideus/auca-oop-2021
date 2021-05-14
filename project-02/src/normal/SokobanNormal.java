package normal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Iman Augustine
 *
 * Sokoban project game, OOP, 2021
 *
 * instructor: S. Shostak
 *
 * */

public class SokobanNormal extends JFrame {

    private static GameModel gameModel;
    private JPanel controlPanel;
    private JPanel canvasPanel;

    private JButton backButton = new JButton("<<");
    private JButton forwardButton = new JButton(">>");
    private JButton resetButton = new JButton("Reset(ESC)");
    private JButton undoButton = new JButton("Undo(PgUp)");
    private JButton redoButton = new JButton("Redo(PgDn)");

    private JLabel levelLabel = new JLabel("Level", SwingConstants.CENTER);
    private JLabel puzzleLabel = new JLabel("Puzzle",  SwingConstants.CENTER);
    private JLabel movesLabel = new JLabel("Moves",  SwingConstants.CENTER);

    private JLabel levelNameLabel = new JLabel("Minicosmos",  SwingConstants.CENTER);
    private JLabel puzzleNumberLabel = new JLabel("1",  SwingConstants.CENTER);
    private JLabel movesNumberLabel = new JLabel("0", SwingConstants.CENTER);

    // Experiment
    private static ArrayList<BlueBox> boxes;
    private static ArrayList<Goal> goals;
    private static Robot robot;

    public SokobanNormal() {
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

        backButton.setMaximumSize(new Dimension(140, 50));
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.add(backButton);

        forwardButton.setMaximumSize(new Dimension(140, 50));
        forwardButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.add(forwardButton);

        movesNumberLabel.setMaximumSize(new Dimension(140, 50));
        movesNumberLabel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        movesNumberLabel.setBackground(Color.CYAN);
        movesNumberLabel.setOpaque(true);
        controlPanel.add(movesLabel);
        controlPanel.add(movesNumberLabel);

        resetButton.setMaximumSize(new Dimension(140, 50));
        resetButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.add(resetButton);

        undoButton.setMaximumSize(new Dimension(140, 50));
        undoButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.add(undoButton);

        redoButton.setMaximumSize(new Dimension(140, 50));
        redoButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.add(redoButton);

        add(controlPanel, BorderLayout.EAST);

        // Setting on action listeners
        resetButton.addActionListener(actionEvent -> resetGame());

        forwardButton.addActionListener(actionEvent -> {
            gameModel.nextLevel();
            resetGame();
        });

        backButton.addActionListener(actionEvent -> {
            gameModel.prevLevel();
            resetGame();
        });

        undoButton.addActionListener(actionEvent -> {
            State state = gameModel.undoState();
            gameModel.move(state.getDr(), state.getDc(),  GameModel.TIME_TRAVEL);
        });

        redoButton.addActionListener(actionEvent -> {
            gameModel.redoState();
            gameModel.move(gameModel.getState().getDr(), gameModel.getState().getDc(), GameModel.TIME_TRAVEL);
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SokobanNormal game = new SokobanNormal();
            game.setTitle("MicroSokoban");
            game.setBackground(Color.BLACK);
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(1100, 1100);
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
            robot = gameModel.getRobot();

            g.setColor(Color.BLACK);
            g.fillRect(0,0,getWidth(),getHeight());

            int xLeftUpper = getWidth()/4;
            int yLeftUpper = getHeight()/4;

            int widthCell = Math.round(getWidth()/2f/gameModel.getWidth());
            int heightCell = Math.round(getHeight()/2f/gameModel.getHeight());

            for(int r = 0; r < gameModel.getHeight(); ++r) {
                for(int c = 0; c < gameModel.getWidth(); ++c) {
                    g.drawImage(Ground.getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, widthCell,heightCell, null);

                    char item = gameModel.getCurElement(r,c);
                    switch (item) {
                        case '#':
                            g.drawImage(Wall.getImage(), xLeftUpper + c * widthCell, yLeftUpper+r*heightCell, widthCell,heightCell, null);
                            break;
                        case 'B':
                            g.setColor(Color.BLACK);
                            g.fillRect(xLeftUpper+ c * widthCell, yLeftUpper+r*heightCell, widthCell, heightCell);
                            break;
                        default:
                            break;
                    }
                }

                for(Goal goal: goals)
                    g.drawImage(Goal.getImage(), xLeftUpper + goal.getCol() * widthCell + widthCell / 4, yLeftUpper + goal.getRow() * heightCell + heightCell / 4, widthCell/2,heightCell/2,null);

                for(BlueBox box: boxes)
                    if(box.isInGoal())
                        g.drawImage(RedBox.getImage(), xLeftUpper + box.getCol()*widthCell, yLeftUpper+box.getRow()*heightCell, widthCell,heightCell,null);
                    else
                        g.drawImage(BlueBox.getImage(), xLeftUpper + box.getCol()*widthCell, yLeftUpper+box.getRow()*heightCell, widthCell,heightCell,null);

                g.drawImage(Robot.getImage(), xLeftUpper+robot.getCol()*widthCell+widthCell/5, yLeftUpper+robot.getRow()*heightCell+heightCell/10, widthCell-widthCell/3,heightCell-heightCell/7,null);

                repaint();
            }
        }
    }

    private void resetGame() {
        robot.setUp();
        gameModel.resetCurrentPuzzle();
        gameModel.deleteStates();
        puzzleNumberLabel.setText(gameModel.getCurLevel()+"");
        movesNumberLabel.setText("0");
        canvasPanel.requestFocus();
        repaint();
    }

    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            switch(keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    robot.setLeft();
                    gameModel.move(0, -1, GameModel.LEFT_COLLISION);
                    gameModel.addState(new State(0, -1, GameModel.LEFT_COLLISION)); // experiment
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                case KeyEvent.VK_RIGHT:
                    robot.setRight();
                    gameModel.move(0, 1, GameModel.RIGHT_COLLISION);
                    gameModel.addState(new State(0, 1, GameModel.RIGHT_COLLISION)); // experiment
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                case KeyEvent.VK_UP:
                    robot.setUp();
                    gameModel.move(-1, 0, GameModel.TOP_COLLISION);
                    gameModel.addState(new State(-1, 0, GameModel.TOP_COLLISION)); // experiment
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                case KeyEvent.VK_DOWN:
                    robot.setDown();
                    gameModel.move(1, 0, GameModel.BOTTOM_COLLISION);
                    gameModel.addState(new State(1, 0, GameModel.BOTTOM_COLLISION)); // experiment
                    movesNumberLabel.setText(gameModel.getMoves()+"");
                    break;
                case KeyEvent.VK_PAGE_UP: // Undo
                    State state = gameModel.undoState();
                    if(state!=null) {
                        state.setRobot(robot);
                        gameModel.move(state.getDr(), state.getDc(), GameModel.TIME_TRAVEL);
                    }
                    break;
                case KeyEvent.VK_PAGE_DOWN: // Redo
                    state = gameModel.redoState();
                    if(state!=null) {
                        state.setRobot(robot);
                        gameModel.move(Integer.compare(0,state.getDr()), Integer.compare(0,state.getDc()), GameModel.TIME_TRAVEL);
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    resetGame();
                    break;
                default:
                    break;
            }

            repaint();
            canvasPanel.requestFocus();

            if(gameModel.isWin()) {
                JOptionPane.showMessageDialog(SokobanNormal.this, String.format("You solved puzzle %d. Moves: %d", gameModel.getCurLevel(), gameModel.getMoves()));
                gameModel.nextLevel();
                resetGame();
            }
        }
    }
}

