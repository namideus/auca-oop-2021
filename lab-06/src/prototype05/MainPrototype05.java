package prototype05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class MainProtoype05 extends JFrame {

    static ArrayList<Figure> figures = new ArrayList<>();

    JPanel mainPanel;
    JPanel controlPanel;

    JButton rectButton = new JButton("Rectangle");
    JButton circleButton = new JButton("Circle");;
    JButton crossButton = new JButton("Cross");;

    // Layout
    MainProtoype05() {
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        add(mainPanel, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.setLayout(new GridLayout(1, 3));
        controlPanel.add(rectButton);
        controlPanel.add(circleButton);
        controlPanel.add(crossButton);
        add(controlPanel, BorderLayout.SOUTH);

        rectButton.addActionListener(actionEvent -> {
            figures.add(new Rect(0,0,100,100));
            repaint();
        });
        circleButton.addActionListener(actionEvent -> {
            figures.add(new Circle(150,50,50));
            repaint();
        });
        crossButton.addActionListener(actionEvent -> {
            figures.add(new Cross(250,50,100,10));
            repaint();
        });
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for(Figure f : figures) {
                    if(f.contains(e.getX(), e.getY())) {
                        JOptionPane.showMessageDialog(MainProtoype05.this, f.toString());
                    }
                }
            }

//            @Override
//            public void mouseDragged(MouseEvent e) {
//                super.mousePressed(e);
//                for(Figure f : figures) {
//                    if(f.contains(e.getX(), e.getY())) {
//                        f.move(e.getX(), e.getY());
//                        //f.draw(g);
//                        repaint();
//                    }
//                }
//            }
        });
    }

    public static void main(String[] args) {
        MainProtoype05 frame = new MainProtoype05();
        frame.setTitle("Javax Swing Application");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class CanvasPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(Figure f : figures) {
                f.draw(g);
            }
        }
    }
}

