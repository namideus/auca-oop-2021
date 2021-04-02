package p03.v3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MainP0303 extends JFrame {

    JPanel mainPanel;

    // Layout
    MainP0303() {
        setTitle("Mouse move");
        setLayout(new BorderLayout());
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GRAY);
        add(mainPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                setTitle(e.getX() + ", " + e.getY());
            }
        });
        pack();
    }

    public static void main(String[] args) {
        MainP0303 frame = new MainP0303();
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}