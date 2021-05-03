package easy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sokoban extends JFrame {

    private final int OFFSET = 30;

    public Sokoban() {
        //GameLogic game = new GameLogic();
        GameLogic game = new GameLogic();
        add(game, BorderLayout.CENTER);

        setTitle("MicroSokoban");

        setSize(800, 800);
        // setSize(game.getWidth() + OFFSET, game.getHeight() + 2 * OFFSET);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    }

    public static void main(String[] args) {
        Sokoban game = new Sokoban();
        game.setVisible(true);
    }

//    public static class GameLogicLocal extends JPanel {
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//
//            Toolkit t=Toolkit.getDefaultToolkit();
//            Image i=t.getImage("/home/iman/Documents/AUCA/SP/Java/auca-oop-2021/project-02/src/easy/resources/BoxBlue.png");
//            g.drawImage(i, 120,100,this);
//        }
//    }

    /*private JPanel game;
    private JPanel controlPanel;
    private final int OFFSET = 30;

    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    public Sokoban() {
        initUI();
    }

    private void initUI() {
        setTitle("MiniSokoban");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game = new GameLogic();
        setSize(game.getWidth() + OFFSET, game.getHeight() + 2 * OFFSET);
        add(game, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        add(controlPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
//        EventQueue.invokeLater(()->{
                Sokoban game = new Sokoban();
                game.setVisible(true);
//            }
//        );
    }*/
}

