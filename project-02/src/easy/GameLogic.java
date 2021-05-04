package easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameLogic extends JPanel {

    private final int OFFSET = 30;
    private final int SPACE = 65;
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
    private int curLevel =  0;
    private int curHeight = 0;
    private int curWidth = 0;


    private boolean isCompleted = false;

    private String level =  "#####\n" +
                            "###   #\n" +
                            "# $ # ##\n" +
                            "# #  . #\n" +
                            "#    # #\n" +
                            "## #   #\n" +
                            "#@  ###\n" +
                            "#####";

    private static final char[][][] levels = {
            {
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#','E','#',' ',' ',' ','#'},
                    {'#',' ','#','#','#',' ',' ',' ','#'},
                    {'#',' ',' ','R','#',' ',' ',' ','#'},
                    {'#',' ','#','#','#',' ',' ',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'}
            },
            {
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#',' ',' ',' ',' ',' ','#','E','#'},
                    {'#',' ','#',' ',' ',' ','#',' ','#'},
                    {'#',' ','#',' ',' ',' ','#',' ','#'},
                    {'#',' ','#',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#',' ',' ',' ','#',' ','#'},
                    {'#','R','#',' ',' ',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'}
            },
            {
                    {'#','#','#','#','#','#','#'},
                    {'#',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#','E','#',' ','#'},
                    {'#',' ','#','#','#',' ','#'},
                    {'#',' ',' ','R','#',' ','#'},
                    {'#',' ','#','#','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ','#'},
                    {'#','#','#','#','#','#','#'}
            }
    };

    public float getCurHeight() {
        return curHeight;
    }

    public float getCurWidth() {
        return curWidth;
    }

    public int getCurLevel() {
        return curLevel;
    }

    public char getCurElement(int row, int col) {
        return levels[curLevel][row][col];
    }

    public GameLogic() {
        this.curLevel = 0;
        this.curHeight = levels[curLevel].length;
        this.curWidth = levels[curLevel][0].length;

       // addKeyListener(new CanvasPanelListener());
        setFocusable(true);
        initWorld();
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
            h = y;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        buildWorld(g);
    }


    private void buildWorld(Graphics g) {

        int xLeftUpper = getWidth()/4;
        int yLeftUpper = getHeight()/4;

        int widthCell = Math.round(getWidth()/2f/getCurWidth());
        int heightCell = Math.round(getHeight()/2f/getCurHeight());

        for(int r = 0; r < getCurHeight(); ++r) {
            for(int c = 0; c < getCurWidth(); ++c) {
                Color color = getCurElement(r,c) =='#' ? Color.DARK_GRAY : Color.GREEN;
                g.setColor(color);
                g.fillRect(xLeftUpper+ c * widthCell, yLeftUpper+r*heightCell, widthCell, heightCell);

                g.setColor(Color.BLACK);
                g.drawRect(xLeftUpper+ c * widthCell, yLeftUpper+r*heightCell, widthCell, heightCell);
            }
        }


      /*  g.setColor(new Color(28,240,170));
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        ArrayList<Actor> world = new ArrayList<>();

        world.addAll(walls);
       // world.addAll(grounds);
        world.addAll(goals);
        world.addAll(boxes);
        world.add(robot);

        for (Actor item : world) {

            if (item instanceof Robot) {
                g.drawImage(item.getImage(), item.getX() + 12, item.getY() + 4, this);
            } else if(item instanceof Goal) {
                g.drawImage(item.getImage(), item.getX()+16, item.getY()+16, this);
            } else {
                g.drawImage(item.getImage(), item.getX(), item.getY(), this);
            }

            if (isCompleted) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
            }
        }*/
    }

    // Canvas panel listener
////    private class CanvasPanelListener extends KeyAdapter {
////        @Override
////        public void keyPressed(KeyEvent keyEvent) {
////
////            if(isCompleted)
////                return;
////
////            int key = keyEvent.getKeyCode();
////
////            switch(key) {
////                case KeyEvent.VK_LEFT:
////                    if(checkWallCollision(robot, LEFT_COLLISION))
////                        return;
////                    if(checkBoxCollision(LEFT_COLLISION))
////                        return;
////                    robot.move(-SPACE, 0);
////                    break;
////                case KeyEvent.VK_RIGHT:
////                    if(checkWallCollision(robot, RIGHT_COLLISION))
////                        return;
////                    if(checkBoxCollision(RIGHT_COLLISION))
////                        return;
////                    robot.move(SPACE, 0);
////                    break;
////                case KeyEvent.VK_UP:
////                    if(checkWallCollision(robot, TOP_COLLISION))
////                        return;
////                    if(checkBoxCollision(TOP_COLLISION))
////                        return;
////                    robot.move(0, -SPACE);
////                    break;
////                case KeyEvent.VK_DOWN:
////                    if(checkWallCollision(robot, BOTTOM_COLLISION))
////                        return;
////                    if(checkBoxCollision(BOTTOM_COLLISION))
////                        return;
////                    robot.move(0, SPACE);
////                    break;
////                case KeyEvent.VK_R:
////                    restartLevel();
////                    break;
////                default:
////                    break;
////            }
////
////            repaint();
////        }
////    }
//
//    private boolean checkWallCollision(Actor actor, int type) {
//        switch (type) {
//            case LEFT_COLLISION:
//                for (Wall wall : walls) {
//                    if (actor.isLeftCollision(wall))
//                        return true;
//                }
//                return false;
//            case RIGHT_COLLISION:
//                for (Wall wall : walls) {
//                    if (actor.isRightCollision(wall))
//                        return true;
//                }
//                return false;
//            case TOP_COLLISION:
//                for (Wall wall : walls) {
//                    if (actor.isTopCollision(wall))
//                        return true;
//                }
//                return false;
//            case BOTTOM_COLLISION:
//                for (Wall wall : walls) {
//                    if (actor.isBottomCollision(wall))
//                        return true;
//                }
//                return false;
//            default:
//                break;
//        }
//        return false;
//    }
//
//    private boolean checkBoxCollision(int type) {
//        switch (type) {
//            case LEFT_COLLISION:
//                for (BlueBox box : boxes) {
//                    if (robot.isLeftCollision(box)) {
//                        for (BlueBox item : boxes) {
//                            if (!box.equals(item)) {
//                                if (box.isLeftCollision(item)) {
//                                    return true;
//                                }
//                            }
//                            if (checkWallCollision(box, LEFT_COLLISION)) {
//                                return true;
//                            }
//                        }
//                        box.move(-SPACE, 0);
//                        isCompleted();
//                    }
//                }
//                return false;
//            case RIGHT_COLLISION:
//                for (BlueBox box : boxes) {
//                    if (robot.isRightCollision(box)) {
//                        for (BlueBox item : boxes) {
//                            if (!box.equals(item)) {
//                                if (box.isRightCollision(item)) {
//                                    return true;
//                                }
//                            }
//                            if (checkWallCollision(box, RIGHT_COLLISION)) {
//                                return true;
//                            }
//                        }
//                        box.move(SPACE, 0);
//                        isCompleted();
//                    }
//                }
//                return false;
//            case TOP_COLLISION:
//                for (BlueBox box : boxes) {
//                    if (robot.isTopCollision(box)) {
//                        for (BlueBox item : boxes) {
//                            if (!box.equals(item)) {
//                                if (box.isTopCollision(item)) {
//                                    return true;
//                                }
//                            }
//                            if (checkWallCollision(box, TOP_COLLISION)) {
//                                return true;
//                            }
//                        }
//                        box.move(0, -SPACE);
//                        isCompleted();
//                    }
//                }
//                return false;
//            case BOTTOM_COLLISION:
//                for (BlueBox box : boxes) {
//                    if (robot.isBottomCollision(box)) {
//                        for (BlueBox item : boxes) {
//                            if (!box.equals(item)) {
//                                if (box.isBottomCollision(item)) {
//                                    return true;
//                                }
//                            }
//                            if (checkWallCollision(box, BOTTOM_COLLISION)) {
//                                return true;
//                            }
//                        }
//                        box.move(0, SPACE);
//                        isCompleted();
//                    }
//                }
//                return false;
//            default:
//                break;
//        }
//        return false;
//    }
//
//
//    public void isCompleted() {
//        int numberOfBoxes = boxes.size();
//        int finishedBoxes = 0;
//
//        for (BlueBox box : boxes) {
//            for (Goal goal : goals)
//                if (goal.getX() == box.getX() && goal.getY() == box.getY())
//                    ++finishedBoxes;
//        }
//
//        if(finishedBoxes==numberOfBoxes) {
//            isCompleted = true;
//            repaint();
//        }
//    }

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
