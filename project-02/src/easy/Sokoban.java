package easy;

import javax.swing.*;
import java.awt.*;

public class Sokoban extends JFrame {

    private JPanel board;
    private JPanel controlPanel;

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
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(DimMax);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        board = new Board();
        board.setFocusable(true);
        add(board, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        add(controlPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
                Sokoban game = new Sokoban();
                game.setVisible(true);
            }
        );
    }
}

