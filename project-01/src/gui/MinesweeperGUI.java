package gui;

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
        frameRate(60);

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

        this.mode = Game.BEGINNER;
        game = new Game(this.mode);
    }

    // Draw
    public void draw() {
        background(0, 0, 0);

        // Draw the field
        updateField();

        // Adapt widgets
        calculatePosition();

        // Mode switch buttons
        this.addButtons();

        // Draw a smile
        drawSmile(smileX, smileY, isSad);

        // Draw texts
        drawTexts();

        // Check game state
        checkGameState();
    }

    // Draw field
    public void updateField() {
        float x,y;
        char cell;
        Button cellBtn;
        for(int i=0; i<game.getWidth(); ++i) {
            for(int j=0; j<game.getHeight(); ++j) {
                x = i*cellSide+width/2f-cellSide*game.getWidth()/2f;
                y = j*cellSide+height/2f-cellSide*game.getHeight()/2f;

                cell = game.getCharBoard()[j][i];
                cellBtn = new Button(this, x,y,cellSide,cellSide, null);

                if(cell=='.') {
                    int finalI = i, finalJ = j;
                    if(!isGameOver) {
                        cellBtn.setOnLeftClickListener(() -> {
                            isGameOver = game.left(finalJ, finalI);
                        });
                        cellBtn.setOnRightClickListener(() -> {
                            game.right(finalJ, finalI);
                        });
                    }
                } else if(cell>='1' && cell<='9') {
                    cellBtn.drawPressed();
                    drawDigit(x, y, cell - '0');
                } else if(cell=='*'){
                    drawMine(x,y);
                } else if(cell=='F'){
                    drawFlag(x,y);
                } else if(cell=='#'){
                    cellBtn.drawPressed();
                }
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

    public void addButtons() {
        Button resetButton = new Button(this, startButtonX,startButtonY,startButtonW,startButtonH, null);
        resetButton.setOnClickListener(() -> {
            System.out.println("Game reset");
            game = new Game(this.mode);
            isSad = isGameOver = false;
        });

        Button beginnerMode = new Button(this, modeButtonX,modeButtonY,modeButtonW,modeButtonH, Game.BEGINNER);
        beginnerMode.setOnClickListener(() -> {
            this.mode = Game.BEGINNER;
            isSad = isGameOver = false;
            game = new Game(this.mode);
        });

        Button intermediateMode = new Button(this, modeButtonX,modeButtonY+dif,modeButtonW,modeButtonH, Game.INTERMEDIATE);
        intermediateMode.setOnClickListener(() -> {
            this.mode = Game.INTERMEDIATE;
            isSad = isGameOver = false;
            game = new Game(this.mode);
        });

        Button expertMode = new Button(this, modeButtonX,modeButtonY+2*dif,modeButtonW,modeButtonH, Game.EXPERT);
        expertMode.setOnClickListener(() -> {
            this.mode = Game.EXPERT;
            isSad = isGameOver = false;
            game = new Game(this.mode);
        });
    }

    public void drawTexts() {
        // Mines and timer
        textSize(60);
        fill(255, 0, 0);
        text(String.format("%03d",(game.getMaxMines())-game.getFlags()),minesTextX, smileY+15f); // Mines' number
        //  if (time > 0)
        time = duration + (millis() + begin)/1000;
        text(String.format("%03d", time),timerTextX, smileY+15f); // Timer is seconds
    }

    public void drawDigit(float x, float y, int dig) {
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
        float r = 10f;
        fill(130,130,130);
        strokeWeight(0f);
        rect(x, y, cellSide, cellSide);

        pushMatrix();
        translate(x+18f,y+18f);
        pushStyle();
        stroke(0);
        strokeWeight(3f);

        for(int i=0; i<5; ++i) {
            rotate((float) (Math.PI/5));
            line(-r,0,r,0);
        }
        popStyle();
        popMatrix();
    }

    public void drawFlag(float x, float y) {
        fill(130,130,130);
        strokeWeight(0f);
        rect(x, y, cellSide, cellSide);
    }

    // Draw sad or happy smile
    public void drawSmile(float x, float y, boolean sad) {
        //-----------SMILE----------------------------------------------------
        // Yellow color
        fill(255, 255, 0);
        //draw the head
        circle(x, y, 50);
        pushStyle();
        strokeWeight(3f);
        //white
        fill(0);
        //draw the eyes
        circle(x-10f, y-10f, 3);
        circle(x+10f, y-10f, 3);
        //black
        // draw the pupils
        // circle(x-10f, y-10f, 10);
        // circle(x+10f, y-10f, 10);
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
        popStyle();
        //-------------------------------------------------------------------
    }

    public static void main(String[] args) {
        PApplet.main("gui.MinesweeperGUI");
    }
}
