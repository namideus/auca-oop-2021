package prototype05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MainProtoype05 extends JFrame {

    static ArrayList<Figure> figures = new ArrayList<>();

    Figure selecteFigure;

    JPanel mainPanel;
    JPanel controlPanel;

    JButton rectButton = new JButton("Rectangle");
    JButton circleButton = new JButton("Circle");;
    JButton crossButton = new JButton("Cross");;

    int sX;
    int sY;
    boolean isDragging = false;

    // Layout
    MainProtoype05() {
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
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
            mainPanel.requestFocus();
        });
        circleButton.addActionListener(actionEvent -> {
            figures.add(new Circle(150,50,50));
            repaint();
            mainPanel.requestFocus();
        });
        crossButton.addActionListener(actionEvent -> {
            figures.add(new Cross(250,50,100,10));
            repaint();
            mainPanel.requestFocus();
        });

        mainPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_DELETE && selecteFigure!=null) {
                    figures.remove(selecteFigure);
                    selecteFigure = null;
                    repaint();
                }
            }
        });
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==MouseEvent.BUTTON3) {
                    for (Figure f : figures) {
                        if (f.contains(e.getX(), e.getY())) {
                            if(selecteFigure!=null) {
                                selecteFigure.setSelected(false);
                            }
                            f.setSelected(true);
                            selecteFigure = f;
                            repaint();
                            JOptionPane.showMessageDialog(MainProtoype05.this, f.toString());
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getButton()==MouseEvent.BUTTON1) {
                    for (Figure f : figures) {
                        if (f.contains(e.getX(), e.getY())) {
                            if(selecteFigure!=null) {
                                selecteFigure.setSelected(false);
                            }
                            f.setSelected(true);
                            selecteFigure = f;
                            repaint();
                        }
                    }
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
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

