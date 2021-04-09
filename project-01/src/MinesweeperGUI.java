import processing.core.*;

public class MinesweeperGUI extends PApplet {

    // Globals
    private Game game;
    private String mode;
    //
    private float x;
    private float y;
    private float w;
    private float h;
    private float dif;

    // Settings
    public void settings() {
        fullScreen();
    }

    // Setup
    public void setup() {
        x = width/2f+200f;
        y = 250f;
        w = 190f;
        h = 40f;
        dif = 70f;
    }

    // Drawing
    public void draw() {
        background(0, 0, 0);

        //-----------SMILE-------------------------
        drawSmile(false);
        //-----------------------------------------

        textSize(40);
        fill(255, 0, 0);
        text("008",width/2f-130f, 165f);
        text("006",width/2f+50f, 165f);

        fill(169,169,169);
        rect(x,y,w,h);
        onClick(x,y,w,h,0, Game.BEGINNER);

        fill(169,169,169);
        rect(x,y+dif,w,h);
        onClick(x,y,w,h,dif, Game.INTERMEDIATE);

        fill(169,169,169);
        rect(x,y+2*dif,w,h);
        onClick(x,y,w,h,2*dif, Game.EXPERT);

        textSize(20);
        fill(0, 255, 0);
        text(Game.BEGINNER,x+50f, y+27f);
        text(Game.INTERMEDIATE,x+30f, y+dif+27f);
        text(Game.EXPERT,x+60f, y+2*dif+27f);
    }

    public void drawButtons() {

    }

    // Draw sad or happy smile
    public void drawSmile(boolean sad) {
        //-----------SMILE----------------------------------------------------
        //yellow
        fill(255, 255, 0);
        //draw the head
        circle(width/2f, 150f, 50);
        //white
        fill(0);
        //draw the eyes
        circle(width/2f-10f, 140f, 3);
        circle(width/2f+10f, 140f, 3);
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
            arc(width/2f, 157, 25, 18, 0, PI);
        else
            arc(width/2f, 163, 25, 18, -PI, 0);
        //-------------------------------------------------------------------
    }

    public void onClick(float x, float y, float w, float h, float dif, String level) {
        if(mousePressed) {
            if (mouseX > x && mouseX < x + w && mouseY > y + dif && mouseY < y + dif + h) {
                this.mode = level;
                fill(GRAY);
                rect(x,y+dif,w,h);
                // drawSmile(true);
                //do stuff
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("MinesweeperGUI");
    }

}