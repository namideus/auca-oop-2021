package p01;

import java.awt.*;
import javax.swing.*;
import processing.core.*;

public class Main extends JFrame {

    JPanel mainPanel;
    JPanel controlPanel;

    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    // Layout
    Main() {
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        add(mainPanel, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setTitle("Javax Swing Application");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}