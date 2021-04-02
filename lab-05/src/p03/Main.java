package p03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main extends JFrame {

    JPanel mainPanel;

    // Layout
    Main() {
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
        Main frame = new Main();
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}