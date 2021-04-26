package prototype05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainPrototype05 extends JFrame {

    JPanel mainPanel;
    JPanel controlPanel;

    JButton rectButton = new JButton("Rect");
    JButton circleButton = new JButton("Circle");
    JButton crossButton = new JButton("Cross");

    private ArrayList<Rect> rects;
    private ArrayList<Rect> circles;
    private ArrayList<Rect> crosses;

    // Layout
    MainPrototype05() {
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        mainPanel.setFocusable(true);
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.addMouseListener(new MouseListener());

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.add(rectButton);
        controlPanel.add(circleButton);
        controlPanel.add(crossButton);
        add(controlPanel, BorderLayout.SOUTH);

        rectButton.addActionListener(new ButtonListener(this));
        circleButton.addActionListener(new ButtonListener(this));
        crossButton.addActionListener(new ButtonListener(this));
    }

    private static class CanvasPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Chessboard
            int widthCell = 40;
            int heightCell = 40;

            g.setColor(Color.BLUE);
            g.fillRect(10, 10, widthCell, heightCell);

            g.setColor(Color.BLUE);
            g.fillOval(10, 10, widthCell, heightCell);
        }
    }

    public static void main(String[] args) {
        MainPrototype05 frame = new MainPrototype05();
        frame.setTitle("Graph Editor");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
        }
    }

    // Button listener
    static class ButtonListener implements ActionListener {

        private final MainPrototype05 frame;

        public ButtonListener(MainPrototype05 frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //
        }
    }
}
