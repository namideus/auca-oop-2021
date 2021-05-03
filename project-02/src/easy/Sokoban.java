package easy;

import javax.swing.*;
import java.awt.*;

public class Sokoban extends JFrame {

    private final int OFFSET = 30;

    public Sokoban() {
        initUI();
    }

    private void initUI() {
        GameLogic game = new GameLogic();
        add(game);

        setTitle("MicroSokoban");

        setSize(800, 800);
        // setSize(game.getWidth() + OFFSET, game.getHeight() + 2 * OFFSET);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Sokoban game = new Sokoban();
            game.setVisible(true);
        });
    }

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

