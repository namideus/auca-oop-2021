import processing.core.*;

/**
 * @author Iman Augustine
 *
 * GUI for Minesweeper Game, OOP Shostak, 2021.
 *
 * Library: Processing3.0
 *
 * */

public class MinesweeperGUI extends PApplet {

    // Globals
    private Game game;
    private String mode;

    private final float cellSide = 35f;

    private float modeButtonX;
    private float modeButtonY;
    private float modeButtonW;
    private float modeButtonH;
    private float dif;

    private float smileX;
    private float smileY;
    private boolean isSad;

    private float minesTextX;
    private float timerTextX;

    private float startButtonX;
    private float startButtonY;
    private float startButtonW;
    private float startButtonH;

    private int[][] Xcoord;
    private int[] Ycoord;

    private int begin;
    private int duration = 0;
    private int time = 0;

    private boolean isGameOver = false;

    // Settings
    public void settings() {
        fullScreen();
    }

    // Setup
    public void setup() {
        frameRate(30);

        begin = millis();

        smileX = width/2f;
        smileY = 150f;
        isSad = false;

        startButtonX = width/2f-35f;
        startButtonY = 115f;
        startButtonW = 70f;
        startButtonH = 70f;

        dif = 70f;
        modeButtonX = 0f;
        modeButtonY = height/2f-dif;
        modeButtonW = 190f;
        modeButtonH = 40f;

        game = new Game(Game.BEGINNER);
    }

    // Draw
    public void draw() {
        background(0, 0, 0);

        // Draw the field
        drawField();

        // Adapt widgets
        calculatePosition();

        // Mode switch buttons
        drawModeButtons();

        // Draw a smile
        drawSmile(smileX, smileY, isSad);

        // Draw texts
        drawTexts();

        // Check game state
        checkGameState();
    }

    // Draw field
    public void drawField() {
        float x,y;
        char cell;
        for(int i=0; i<game.getWidth(); ++i) {
            for(int j=0; j<game.getHeight(); ++j) {
                x = i*cellSide+width/2f-cellSide*game.getWidth()/2f;
                y = j*cellSide+height/2f-cellSide*game.getHeight()/2f;
                cell = game.getCharBoard()[j][i];

                if(cell=='.') {
                    fill(169, 169, 169);
                    rect(x, y, cellSide, cellSide);
                } else if(cell>='1' && cell<='9') {
                    drawDigit(x, y, cell - '0');
                } else if(cell=='*'){
                    drawMine(x,y);
                } else if(cell=='F'){
                    drawFlag(x,y);
                } else if(cell=='#'){
                    fill(130,130,130);
                    rect(x, y, cellSide, cellSide);
                }
                onCellClick(j, i, x, y, cellSide, cellSide);
            }
        }
    }

    public void calculatePosition() {
        modeButtonX = width/2f+cellSide*game.getWidth()/2f+30f;
        smileY = height/2f-cellSide*game.getHeight()/2f-40f;
        startButtonY = smileY-35f;
        minesTextX = width/2f-cellSide*game.getWidth()/2f;
        timerTextX = width/2f+cellSide*game.getWidth()/2f-110f;
    }

    public void checkGameState() {
        if(!isGameOver && game.getMovesLeft()==0) {
            System.out.println("\nCongratulations!\nBye\n");
        }

        // Game is lost
        if(isGameOver) {
            isSad = true;
            System.out.println("\nNext time you will be better\nBye\n");
        }
    }

    public void drawModeButtons() {
        // Restart button
        fill(169,169,169);
        rect(startButtonX,startButtonY,startButtonW,startButtonH);
        onRestartClick(startButtonX, startButtonY, startButtonW, startButtonH);
        // Mode buttons
        fill(169,169,169);
        rect(modeButtonX,modeButtonY,modeButtonW,modeButtonH);
        switchMode(modeButtonX,modeButtonY,modeButtonW,modeButtonH,0, Game.BEGINNER);

        fill(169,169,169);
        rect(modeButtonX,modeButtonY+dif,modeButtonW,modeButtonH);
        switchMode(modeButtonX,modeButtonY,modeButtonW,modeButtonH,dif, Game.INTERMEDIATE);

        fill(169,169,169);
        rect(modeButtonX,modeButtonY+2*dif,modeButtonW,modeButtonH);
        switchMode(modeButtonX,modeButtonY,modeButtonW,modeButtonH,2*dif, Game.EXPERT);
    }

    public void drawTexts() {
        // Mines and timer
        textSize(60);
        fill(255, 0, 0);
        text(String.format("%03d",(game.getMaxMines())-game.getFlags()),minesTextX, smileY+15f); // Mines' number
        //  if (time > 0)
        time = duration + (millis() + begin)/1000;
        text(String.format("%03d", time),timerTextX, smileY+15f); // Timer is seconds
        // Texts on mode buttons
        textSize(20);
        fill(0, 255, 0);
        text(Game.BEGINNER,modeButtonX+50f, modeButtonY+27f);
        text(Game.INTERMEDIATE,modeButtonX+30f, modeButtonY+dif+27f);
        text(Game.EXPERT,modeButtonX+60f, modeButtonY+2*dif+27f);
    }

    public void drawDigit(float x, float y, int dig) {
        fill(130,130,130);
        rect(x, y, cellSide, cellSide);

        textSize(25);
        switch (dig) {
            case 1:
                fill(0, 0, 255);
                break;
            case 2:
                fill(255, 0, 0);
                break;
            case 3:
                fill(0, 128, 0);
                break;
            case 4:
                fill(255, 192, 203);
                break;
            case 5:
                fill(128,0,128);
                break;
            case 6:
                fill(255,255,0);
                break;
            case 7:
                fill(255,165,0);
                break;
            case 8:
                fill(244,0,161);
                break;
        }
        text(dig,x+11f, y+27f); // Adjacent numbers
    }

    public void drawMine(float x, float y) {
        fill(130,130,130);
        rect(x, y, cellSide, cellSide);
    }

    public void drawFlag(float x, float y) {
        fill(130,130,130);
        rect(x, y, cellSide, cellSide);
    }

    // Draw sad or happy smile
    public void drawSmile(float x, float y, boolean sad) {
        //-----------SMILE----------------------------------------------------
        // Yellow color
        fill(255, 255, 0);
        //draw the head
        circle(x, y, 50);
        //white
        fill(0);
        //draw the eyes
        circle(x-10f, y-10f, 3);
        circle(x+10f, y-10f, 3);
        //black
        // draw the pupils
//        circle(x-10f, y-10f, 10);
//        circle(x+10f, y-10f, 10);
        //red
        //fill(255, 0, 0);
        //draw the mouth
        fill(255, 255, 0);
       // strokeWeight(2f);

        if(!sad) {
            arc(x, y + 7f, 25, 18, 0, PI);
        } else {
            arc(x, y + 13f, 25, 18, -PI, 0);
        }
        //-------------------------------------------------------------------
    }

    public void switchMode(float x, float y, float w, float h, float dif, String mode) {
        if(mousePressed) {
            if (mouseX > x && mouseX < x + w && mouseY > y + dif && mouseY < y + dif + h) {
                this.mode = mode;
                game = new Game(mode);
                fill(255,255,255);
                rect(x,y+dif,w,h);

                // drawSmile(true);
                //do stuff
            }
        }
    }

    public void onRestartClick(float x, float y, float w, float h) {
        if(mousePressed) {
            if (mouseX > x && mouseX < x + w && mouseY > y  && mouseY < y + h) {
                fill(255,255,255);
                rect(x,y,w,h);
                // drawSmile(true);
                //do stuff
            }
        }
    }

    // On possibly mine click
    public void onCellClick(int row, int col, float x, float y, float w, float h) {
        if(mousePressed) {
            if(mouseButton==LEFT) {
                if (mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h) {
                    fill(255, 255, 255);
                    rect(x, y, w, h);
                    isGameOver = game.left(row, col);
                    System.out.print(game);
                }
            } else if(mouseButton==RIGHT) {
                if (mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h) {
                    fill(255, 255, 255);
                    rect(x, y, w, h);
                    drawSmile(smileX, smileY, true);
                    game.right(row, col);
                    System.out.print(game);
                }
            }
        }
    }

    public void resetGame() {

    }

    // Mouse pressed
    @Override
    public void mousePressed() {
        super.mousePressed();

        if (mouseButton == LEFT) {

        } else if (mouseButton == RIGHT) {

        }
    }

    public static void main(String[] args) {
        PApplet.main("MinesweeperGUI");
    }
}