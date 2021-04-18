package gui;

import com.sun.tools.javac.Main;
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

    private SmileButton resetButton;
    private Button beginnerMode, intermediateMode, expertMode;

    // Settings
    public void settings() {
        fullScreen();
    }

    // Setup
    public void setup() {
        frameRate(60);

        begin = millis();

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
        addButtons();
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

                drawElement(cell,x,y,i,j,cellBtn);
            }
        }
    }

    // Draw digits
    public void drawElement(char cell, float x, float y, int col, int row, Button cellBtn) {
        if(cell=='.') {
            if(!isGameOver) {
                cellBtn.setOnLeftClickListener(() -> isGameOver = game.left(row, col));
                cellBtn.setOnRightClickListener(() -> game.right(row, col));
            }
        } else if(Character.isDigit(cell)) {
            new Digit(this, x,y,cellSide,cellSide, 25, cell - '0');
        } else if(cell=='*')
            new Mine(this, x,y,cellSide,cellSide, 10f);
        else if(cell=='F')
            drawFlag(x,y);
        else if(cell=='#')
            cellBtn.drawPressed();
    }

    public void calculatePosition() {
        modeButtonX = width/2f+cellSide*game.getWidth()/2f+30f;
        smileY = height/2f-cellSide*game.getHeight()/2f-40f;
        startButtonY = smileY-35f;
        minesTextX = width/2f-cellSide*game.getWidth()/2f;
        timerTextX = width/2f+cellSide*game.getWidth()/2f-110f;
    }

    // Update game state all the time to identify loss or win
    public void checkGameState() {
        if(!isGameOver && game.getMovesLeft()==0) {
            resetButton.setVictorious(true);
        }
        // Game is lost
        if(isGameOver) {
            resetButton.setIsSad(true);
        }
    }

    public void addButtons() {
        resetButton = new SmileButton(this, startButtonX, startButtonY, startButtonW,startButtonH);
        resetButton.setOnClickListener(() -> {
            game = new Game(this.mode);
            isSad = isGameOver = false;
        });

        beginnerMode = new Button(this, modeButtonX,modeButtonY,modeButtonW,modeButtonH, Game.BEGINNER);
        beginnerMode.setOnClickListener(() -> {
            this.mode = Game.BEGINNER;
            isSad = isGameOver = false;
            game = new Game(this.mode);
        });

        intermediateMode = new Button(this, modeButtonX,modeButtonY+dif,modeButtonW,modeButtonH, Game.INTERMEDIATE);
        intermediateMode.setOnClickListener(() -> {
            this.mode = Game.INTERMEDIATE;
            isSad = isGameOver = false;
            game = new Game(this.mode);
        });

        expertMode = new Button(this, modeButtonX,modeButtonY+2*dif,modeButtonW,modeButtonH, Game.EXPERT);
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

        pushStyle();
        textSize(16);
        fill(231,84,128);
        textAlign(CENTER);
        text("Clone of Minesweeper (with Processing Library)\nby Altynbek uulu Yiman for OOP 2021",width/2f, height-height/6f);
        popStyle();
    }

    public void drawFlag(float x, float y) {
        fill(130,130,130);
        strokeWeight(0f);
        rect(x, y, cellSide, cellSide);
    }

    public static void main(String[] args) {
        PApplet.main("gui.MinesweeperGUI");
    }
}
