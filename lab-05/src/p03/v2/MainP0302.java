package p03.v2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MainP0302 extends JFrame {

    JPanel mainPanel;

    // Layout
    MainP0302() {
        setTitle("Mouse move");
        setLayout(new BorderLayout());
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GRAY);
        add(mainPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) { }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                setTitle(mouseEvent.getX() + ", " + mouseEvent.getY());
            }
        });
        pack();
    }

    public static void main(String[] args) {
        MainP0302 frame = new MainP0302();
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}