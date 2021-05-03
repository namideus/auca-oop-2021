package easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameLogic extends JPanel {

    private final int OFFSET = 30;
    private final int SPACE = 20;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private ArrayList<Wall> walls;
    private ArrayList<BlueBox> boxes;
    private ArrayList<Ground> grounds;
    private ArrayList<Goal> goals;

    private Robot robot;

    private int w = 0;
    private int h = 0;

    private boolean isCompleted = false;

    private ArrayList<String[][]> levels;

    private String level =  "#####\n" +
                            "###   #\n" +
                            "# $ # ##\n" +
                            "# #  . #\n" +
                            "#    # #\n" +
                            "## #   #\n" +
                            " #@  ###\n" +
                            " #####";

    public GameLogic() {
        addKeyListener(new CanvasPanelListener());
        setFocusable(true);
        initWorld();

        // System.out.println(level);
    }

    public int getWidth() {
        return this.w;
    }

    public int getHeight() {
        return this.h;
    }

    private void initWorld() {

        walls = new ArrayList<>();
        boxes = new ArrayList<>();
        grounds = new ArrayList<>();
        goals = new ArrayList<>();

        int x = OFFSET;
        int y = OFFSET;

        Wall wall;
        BlueBox box;
        Ground ground;
        Goal goal;

        for(int i=0; i<level.length(); ++i) {
            char item = level.charAt(i);

            switch (item) {
                case '\n':
                    y += SPACE;
                    if(this.w < x) {
                        this.w = x;
                    }
                    x = OFFSET;
                    break;
                case '#':
                    wall = new Wall(x, y);
                    walls.add(wall);
                    x += SPACE;
                    break;
                case '$':
                    box = new BlueBox(x, y);
                    boxes.add(box);
                    x += SPACE;
                    break;
                case '.':
                    goal = new Goal(x, y);
                    goals.add(goal);
                    x += SPACE;
                    break;
                case '@':
                    robot = new Robot(x, y);
                    x += SPACE;
                    break;
                case ' ':
                    ground = new Ground(x, y);
                    grounds.add(ground);
                    x += SPACE;
                    break;
                default:
                    break;
            }
        }
    }

    private void buildWorld(Graphics g) {
        g.setColor(new Color(250,240,170));
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        ArrayList<Actor> world = new ArrayList<>();

        world.addAll(walls);
        world.addAll(grounds);
        world.addAll(goals);
        world.addAll(boxes);
        world.add(robot);

        for (Actor item : world) {
            if (item instanceof Robot || item instanceof BlueBox) {
                g.drawImage(item.getImage(), item.getX() + 2, item.getY() + 2, this);
            } else {
                g.drawImage(item.getImage(), item.getX(), item.getY(), this);
            }

            if (isCompleted) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        buildWorld(g);
    }

    // Canvas panel listener
    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            if(isCompleted)
                return;

            int key = keyEvent.getKeyCode();

            switch(key) {
                case KeyEvent.VK_LEFT:
                    if(checkWallCollision(robot, LEFT_COLLISION))
                        return;

                    break;
                case KeyEvent.VK_RIGHT:
                    if(checkWallCollision(robot, RIGHT_COLLISION))
                        return;

                    break;
                case KeyEvent.VK_UP:
                    if(checkWallCollision(robot, TOP_COLLISION))
                        return;

                    break;
                case KeyEvent.VK_DOWN:
                    if(checkWallCollision(robot, BOTTOM_COLLISION))
                        return;

                    break;
                case KeyEvent.VK_R:
                    restartLevel();
                    break;
                default:
                    break;
            }

            repaint();
        }
    }

    private boolean checkWallCollision(Actor actor, int type) {
        switch (type) {
            case LEFT_COLLISION:
                for (Wall wall : walls) {
                    if (actor.isLeftCollision(wall))
                        return true;
                }
                return false;
            case RIGHT_COLLISION:
                for (Wall wall : walls) {
                    if (actor.isRightCollision(wall))
                        return true;
                }
                return false;
            case TOP_COLLISION:
                for (Wall wall : walls) {
                    if (actor.isTopCollision(wall))
                        return true;
                }
                return false;
            case BOTTOM_COLLISION:
                for (Wall wall : walls) {
                    if (actor.isBottomCollision(wall))
                        return true;
                }
                return false;
            default:
                break;
        }
        return false;
    }

    private boolean checkBoxCollision(int type) {
        return false;
    }


    public void isCompleted() {
        int numberOfBoxes = boxes.size();
        int finishedBoxes = 0;

        for (BlueBox box : boxes) {
            for (Goal goal : goals)
                if (goal.getX() == box.getX() && goal.getY() == box.getY())
                    ++finishedBoxes;
        }

        if(finishedBoxes==numberOfBoxes) {
            isCompleted = true;
            repaint();
        }
    }

    public void restartLevel() {
        walls.clear();
        boxes.clear();
        grounds.clear();
        goals.clear();

        initWorld();

        if(isCompleted)
            isCompleted = false;
    }
}
