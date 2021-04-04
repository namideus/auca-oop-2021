package p05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainP05 extends JFrame implements KeyListener{

    MainP05() {
        setTitle("Chessboard");
        setFocusable(true);
        setLayout(new GridLayout(8,8,0,0));
        // 8x8 squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean isBlack = (col % 2 == 0) == (row % 2 == 0);
                add(new DrawRect(isBlack ? 0 : 1));
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
//            KeyEvent.VK_UP;
//            KeyEvent.VK_DOWN;
//            KeyEvent.VK_LEFT;
//            KeyEvent.VK_RIGHT;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    // DrawRect
    static class DrawRect extends JPanel {
        private final int colorCode;
        public DrawRect(int c) {
            colorCode = c;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (colorCode==0)
                g.setColor(Color.BLACK);
            else
                g.setColor(Color.WHITE);

            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    // DrawCircle
    static class DrawCircle extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(40, 40, 60, 60);
            g.fillOval(40, 40, 60, 60);
        }
    }

    public static void main(String[] args) {
        MainP05 frame = new MainP05();
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}