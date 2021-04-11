import processing.core.*;

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
    private float minesTextY;
    private float timerTextX;
    private float timerTextY;

    private float startButtonX;
    private float startButtonY;
    private float startButtonW;
    private float startButtonH;

    // Settings
    public void settings() {
        fullScreen();
    }

    // Setup
    public void setup() {
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

        drawField();

        //-----------SMILE-------------------------
        fill(169,169,169);
        rect(startButtonX,startButtonY,startButtonW,startButtonH);
        onRestartClick(startButtonX, startButtonY, startButtonW, startButtonH);
        drawSmile(smileX, smileY,isSad);
        //onClick(x,y,w,h,0, Game.BEGINNER);
        //-----------------------------------------
        // Mines and timer
        textSize(40);
        fill(255, 0, 0);
        text(String.format("%03d",(game.getMaxMines())-game.getFlags()),smileX-130f, smileY+15f); // Mines' number
        text(String.format("%03d",game.getFlags()),smileX+50f, smileY+15f); // Timer is seconds

        // Mode buttons
        fill(169,169,169);
        rect(modeButtonX,modeButtonY,modeButtonW,modeButtonH);
        onModeClick(modeButtonX,modeButtonY,modeButtonW,modeButtonH,0, Game.BEGINNER);

        fill(169,169,169);
        rect(modeButtonX,modeButtonY+dif,modeButtonW,modeButtonH);
        onModeClick(modeButtonX,modeButtonY,modeButtonW,modeButtonH,dif, Game.INTERMEDIATE);

        fill(169,169,169);
        rect(modeButtonX,modeButtonY+2*dif,modeButtonW,modeButtonH);
        onModeClick(modeButtonX,modeButtonY,modeButtonW,modeButtonH,2*dif, Game.EXPERT);

        // Texts on mode buttons
        textSize(20);
        fill(0, 255, 0);
        text(Game.BEGINNER,modeButtonX+50f, modeButtonY+27f);
        text(Game.INTERMEDIATE,modeButtonX+30f, modeButtonY+dif+27f);
        text(Game.EXPERT,modeButtonX+60f, modeButtonY+2*dif+27f);
    }

    // Draw field
    public void drawField() {
        for(int i=0; i<game.getWidth(); ++i) {
            for(int j=0; j<game.getHeight(); ++j) {
                fill(169,169,169);
                rect(i*cellSide+width/2f-cellSide*game.getWidth()/2f, j*cellSide+height/2f-cellSide*game.getHeight()/2f, cellSide, cellSide);
                modeButtonX = width/2f+cellSide*game.getWidth()/2f+30f;

                //y = height/2f-cellSide*game.getHeight()/2f+cellSide*game.getHeight()/2f-50f;
                //onModeClick(i*cellSide,j*cellSide, cellSide, cellSide,cellSide,Game.BEGINNER);
            }
        }
    }

    public void calculatePosition() {

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
        // ellipse(75, 85, 10, 10);
        // ellipse(125, 85, 10, 10);
        //red
        //fill(255, 0, 0);
        //draw the mouth
        fill(255, 255, 0);
       // strokeWeight(2f);

        if(!sad)
            arc(x, y+7f, 25, 18, 0, PI);
        else
            arc(x, y+13f, 25, 18, -PI, 0);
        //-------------------------------------------------------------------
    }

    public void onModeClick(float x, float y, float w, float h, float dif, String mode) {
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

    // Mouse pressed
    @Override
    public void mousePressed() {
        super.mousePressed();

        if (mouseButton == LEFT) {

//            if (mouseX > x && mouseX < x + w && mouseY > y  && mouseY < y + h) {
//                //game = new Game(mode);
//                fill(255,255,255);
//                rect(x,y,w,h);
//                // drawSmile(true);
//                //do stuff
//            }
        } else if (mouseButton == RIGHT) {

        }
    }

    public static void main(String[] args) {
        PApplet.main("MinesweeperGUI");
    }

}