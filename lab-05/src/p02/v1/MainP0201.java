package p02.v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainP0201 extends JFrame {

    JPanel mainPanel;
    JPanel controlPanel;

    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    // Layout
    MainP0201() {
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

        redButton.addActionListener(new ButtonListener(this, Color.RED));
        greenButton.addActionListener(new ButtonListener(this, Color.GREEN));
        blueButton.addActionListener(new ButtonListener(this, Color.BLUE));
    }

    public static void main(String[] args) {
        MainP0201 frame = new MainP0201();
        frame.setTitle("Javax Swing Application");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Button listener
class ButtonListener implements ActionListener {

    private final MainP0201 frame;
    private final Color color;

    public ButtonListener(MainP0201 frame, Color color) {
        this.frame = frame;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        frame.mainPanel.setBackground(this.color);
    }
}

