package p03.v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MainP0301 extends JFrame {

    JPanel mainPanel;

    // Layout
    MainP0301() {
        setTitle("Mouse move");
        setLayout(new BorderLayout());
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GRAY);
        add(mainPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(new PanelMouseMotionListener(this));
        pack();
    }

    public static void main(String[] args) {
        MainP0301 frame = new MainP0301();
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    static class PanelMouseMotionListener implements MouseMotionListener {

        private final MainP0301 frame;

        public PanelMouseMotionListener(MainP0301 frame) {
            this.frame = frame;
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            frame.setTitle(mouseEvent.getX() + ", " + mouseEvent.getY());
        }
    }

}