package easy;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameLogic extends JPanel {
    private ArrayList<String[][]> levels;

    private String level =  "#####\n" +
                            "###   #\n" +
                            "# $ # ##\n" +
                            "# #  . #\n" +
                            "#    # #\n" +
                            "## #   #\n" +
                            " #@  ###\n" +
                            " #####";



    // Canvas panel listener
    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int code = keyEvent.getKeyCode();

            if(code==KeyEvent.VK_F1) {
                JOptionPane.showMessageDialog(null, "Move robot!");
            } else if(code==KeyEvent.VK_UP) {
                // game.moveUp();
            } else if(code==KeyEvent.VK_DOWN) {
                // game.moveDown();
            } else if(code==KeyEvent.VK_LEFT) {
                // game.moveLeft();
            } else if(code==KeyEvent.VK_RIGHT) {
                // game.moveRight();
            }
            repaint();
        }
    }
}
