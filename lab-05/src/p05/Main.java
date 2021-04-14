package p05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {
    private JPanel mainPanel;

    GameModel game = new GameModel();

    Main() {
        setLayout(new BorderLayout());
        mainPanel = new CanvasPanel();
        mainPanel.setFocusable(true);
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.addKeyListener(new CanvasPanelListener());
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("Chessboard");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class CanvasPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Chessboard
            int widthCell = Math.round(getWidth() / 8f);
            int heightCell = Math.round(getHeight() / 8f);

            for (int r = 0; r < 8; ++r) {
                for (int c = 0; c < 8; ++c) {
                    if ((c % 2 == 0 && r % 2 == 0) || (r % 2 != 0 && c % 2 != 0)) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    g.fillRect(c * widthCell, r * heightCell, widthCell, heightCell);
                }
            }
            g.setColor(Color.RED);
            g.fillOval(game.getCol()*widthCell, game.getRow()*heightCell, widthCell, heightCell);
        }
    }

    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int code = keyEvent.getKeyCode();

            if(code==KeyEvent.VK_F1) {
                JOptionPane.showMessageDialog(null, "Move robot!");
            } else if(code==KeyEvent.VK_UP) {
                game.moveUp();
            } else if(code==KeyEvent.VK_DOWN) {
                game.moveDown();
            } else if(code==KeyEvent.VK_LEFT) {
                game.moveLeft();
            } else if(code==KeyEvent.VK_RIGHT) {
                game.moveRight();
            }
            repaint();
        }
    }
}

