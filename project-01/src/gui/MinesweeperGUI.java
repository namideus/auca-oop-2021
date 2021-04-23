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
    private GameLogic game;
    private String mode;
    private Timer timer;
    private final float cellSide = 35f;
    private float modeButtonX;
    private float modeButtonY;
    private float modeButtonW;
    private float modeButtonH;
    private float smileY;
    private float minesTextX;
    private float timerTextX;
    private float startButtonX;
    private float startButtonY;
    private float startButtonW;
    private float startButtonH;

    private boolean isGameOver = false;

    private SmileButton resetButton;

    // Settings
    public void settings() {
        fullScreen();
    }

    // Setup
    public void setup() {
        frameRate(60);

        timer = new Timer(this, 3000);

        smileY = 150f;
        startButtonX = width/2f-35f;
        startButtonY = 115f;
        startButtonW = 70f;
        startButtonH = 70f;
        modeButtonX = 0f;
        modeButtonY = height/2f-70f;
        modeButtonW = 190f;
        modeButtonH = 40f;

        this.mode = GameLogic.BEGINNER;
        game = new GameLogic(this.mode);
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
        drawText();
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
            cellBtn.drawPressed();
            (new Digit(this, x,y,cellSide,cellSide, 25, cell - '0')).draw();
        } else if(cell=='*') {
            cellBtn.drawPressed();
            (new Mine(this, x, y, cellSide, cellSide, 10f)).draw(false);
        } else if(cell=='F') {
            (new Flag(this, x, y, cellSide, cellSide)).draw();
        } else if(cell=='#') {
            cellBtn.drawPressed();
        }
    }

    // Calculation coordinates of all widgets on screen
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
            timer.reset();
            resetButton.setVictorious(true);
        }
        // Game is lost
        if(isGameOver) {
            timer.reset();
            resetButton.setIsSad(true);
        }
    }

    // Create buttons and set listeners
    public void addButtons() {
        resetButton = new SmileButton(this, startButtonX, startButtonY, startButtonW,startButtonH);
        resetButton.setOnClickListener(() -> {
            timer.reset();
            setGame(this.mode);
        });
        Button beginnerMode = new Button(this, modeButtonX, modeButtonY, modeButtonW, modeButtonH, GameLogic.BEGINNER);
        beginnerMode.setOnClickListener(() -> setGame(GameLogic.BEGINNER));
        Button intermediateMode = new Button(this, modeButtonX, modeButtonY + 70f, modeButtonW, modeButtonH, GameLogic.INTERMEDIATE);
        intermediateMode.setOnClickListener(() -> setGame(GameLogic.INTERMEDIATE));
        Button expertMode = new Button(this, modeButtonX, modeButtonY + 140f, modeButtonW, modeButtonH, GameLogic.EXPERT);
        expertMode.setOnClickListener(() -> setGame(GameLogic.EXPERT));
    }

    // Set game mode, timer and states
    public void setGame(String mode) {
        timer.reset();
        this.mode = mode;
        isGameOver = false;
        game = new GameLogic(this.mode);
    }

    // Draw some text
    public void drawText() {
        // Mines and timer
        textSize(60);
        fill(255, 0, 0);
        text(String.format("%03d",(game.getMaxMines())-game.getFlags()),minesTextX, smileY+15f); // Mines' number
        text(String.format("%03d", timer.getEllapsedTime()), timerTextX, smileY+15f); // Timer is seconds
        // Credits
        pushStyle();
        textSize(16);
        fill(231,84,128);
        textAlign(CENTER);
        text("Clone of Minesweeper (with Processing Library)\nby Altynbek uulu Yiman for OOP 2021",width/2f, height-height/6f);
        popStyle();
    }

    // Program driver
    public static void main(String[] args) {
        PApplet.main("gui.MinesweeperGUI");
    }
}
