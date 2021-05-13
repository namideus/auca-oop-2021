import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {

    Canvas mainCanvas ;

    static int row = 0;
    static int col = 0;


    public Main() {
        mainCanvas = new Canvas();
        mainCanvas.setFocusable(true);
        add(mainCanvas);
        mainCanvas.addKeyListener(new CanvasListener());
        setTitle("Robot");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setLocationRelativeTo(null);
        main.requestFocus();
        main.setSize(600,600);
        main.setVisible(true);
    }

    public static class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int height = Math.round(getHeight()/8f);
            int width = Math.round(getWidth()/8f);

            for(int r = 0; r < 8; ++r) {
                for (int c = 0; c < 8; ++c) {
                    if((r%2==0 && c%2==0) || (r%21!=0 && c%2!=0)) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.GRAY);
                    }
                    g.fillRect(c*height, r*width, height, width);
                }
            }

            g.setColor(Color.RED);
            g.fillOval(row*height, col*width, height, width);
        }
    }

    class CanvasListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            int code = e.getKeyCode();

            if(code==KeyEvent.VK_UP) {
                row--;
            } else if(code==KeyEvent.VK_DOWN) {
                row++;
            } else if(code==KeyEvent.VK_LEFT) {
                col--;
            } else if(code==KeyEvent.VK_RIGHT) {
                col++;
            }
            mainCanvas.requestFocus();
            repaint();
        }
    }
}
