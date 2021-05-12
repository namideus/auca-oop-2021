package p02.v3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainP0203 extends JFrame {

    JPanel mainPanel;
    JPanel controlPanel;

    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    // Layout
    MainP0203() {
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

        redButton.addActionListener(actionEvent -> {
            mainPanel.setBackground(Color.RED);
        });

        greenButton.addActionListener(actionEvent -> {
            mainPanel.setBackground(Color.GREEN);
        });

        blueButton.addActionListener(actionEvent -> {
            mainPanel.setBackground(Color.BLUE);
        });
    }

    public static void main(String[] args) {
        MainP0203 frame = new MainP0203();
        frame.setTitle("Javax Swing Application");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


