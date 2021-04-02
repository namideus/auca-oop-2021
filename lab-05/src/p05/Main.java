package p05;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    Main() {
        setTitle("Chessboard");
        setLayout(new GridLayout(8,8,0,0));
        // 8x8 squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean isBlack = (col % 2 == 0) == (row % 2 == 0);
                add(new DrawRect(isBlack ? 0 : 1));
            }
        }
    }

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

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}