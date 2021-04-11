import processing.core.*;

public class MinesweeperGUI extends PApplet {

    // Globals
    private Game game;
    private String mode;

    private final float cellSide = 40f;

    private float x;
    private float y;
    private float w;
    private float h;
    private float dif;

    private float smileX;
    private float smileY;
    private boolean isSad;

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

        x = width/2f+200f;
        y = 250f;
        w = 190f;
        h = 40f;
        dif = 70f;

        game = new Game(Game.BEGINNER);
    }

    // Draw
    public void draw() {
        background(0, 0, 0);


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
        rect(x,y,w,h);
        onClick(x,y,w,h,0, Game.BEGINNER);

        fill(169,169,169);
        rect(x,y+dif,w,h);
        onClick(x,y,w,h,dif, Game.INTERMEDIATE);

        fill(169,169,169);
        rect(x,y+2*dif,w,h);
        onClick(x,y,w,h,2*dif, Game.EXPERT);
        // Texts on mode buttons
        textSize(20);
        fill(0, 255, 0);
        text(Game.BEGINNER,x+50f, y+27f);
        text(Game.INTERMEDIATE,x+30f, y+dif+27f);
        text(Game.EXPERT,x+60f, y+2*dif+27f);
    }

    public void drawField() {
        for(int i=0; i<game.getHeight(); ++i) {
            for(int j=0; j<game.getWidth(); ++j) {

            }
        }
    }

    public void drawButtons() {

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
        strokeWeight(2f);

        if(!sad)
            arc(x, y+7f, 25, 18, 0, PI);
        else
            arc(x, y+13f, 25, 18, -PI, 0);
        //-------------------------------------------------------------------
    }

    public void onClick(float x, float y, float w, float h, float dif, String mode) {
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
                //game = new Game(mode);
                fill(255,255,255);
                rect(x,y,w,h);
                // drawSmile(true);
                //do stuff
            }
        }
    }

    @Override
    public void mousePressed() {
        super.mousePressed();

        if (mouseButton == LEFT) {
            isSad = true;
        } else if (mouseButton == RIGHT) {
            isSad = false;
        } else {
            fill(126);
        }
    }

    public static void main(String[] args) {
        PApplet.main("MinesweeperGUI");
    }

}