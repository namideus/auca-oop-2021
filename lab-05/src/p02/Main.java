package p02;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        add(controlPanel, BorderLayout.SOUTH);

        redButton.addActionListener(new ButtonListener(this, Color.RED));
        greenButton.addActionListener(new ButtonListener(this, Color.GREEN));
        blueButton.addActionListener(new ButtonListener(this, Color.BLUE));
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("Javax Swing Application");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Button listener
class ButtonListener implements ActionListener {

    private final Main frame;
    private final Color color;

    public ButtonListener(Main frame, Color color) {
        this.frame = frame;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        frame.mainPanel.setBackground(this.color);
    }
}

