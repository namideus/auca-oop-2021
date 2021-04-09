import processing.core.*;

public class MinesweeperUIMain extends PApplet {

    private String mode;

    public void settings() {
        fullScreen();
    }

    public void setup() {

    }

    public void draw() {
        background(0, 0, 0);

        float x = width/2f+200f;
        float y = 250f;
        float w = 190f;
        float h = 40f;
        float dif = 70f;

        //-----------SMILE-------------------------
        drawSmile(false);
        //----------------------------------------------
        textSize(40);
        fill(255, 0, 0);
        text("008",width/2f-130f, 165f);
        text("006",width/2f+50f, 165f);

        fill(169,169,169);
        rect(x,y,w,h);
        onClick(x,y,w,h,0, MinesweeperGame.BEGINNER);

        fill(169,169,169);
        rect(x,y+dif,w,h);
        onClick(x,y,w,h,dif, MinesweeperGame.INTERMEDIATE);

        fill(169,169,169);
        rect(x,y+2*dif,w,h);
        onClick(x,y,w,h,2*dif, MinesweeperGame.EXPERT);

        textSize(20);
        fill(0, 255, 0);
        text(MinesweeperGame.BEGINNER,x+50f, y+27f);
        text(MinesweeperGame.INTERMEDIATE,x+30f, y+dif+27f);
        text(MinesweeperGame.EXPERT,x+60f, y+2*dif+27f);
    }

    public void drawSmile(boolean sad) {
        //-----------SMILE-------------------------
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
        arc(width/2f, 157, 25, 18, 0, PI);
        //arc(width/2f, 115, 25, 18, -PI, 0);
        //----------------------------------------------
    }

    public void onClick(float x, float y, float w, float h, float dif, String level) {
        if(mousePressed) {
            if (mouseX > x && mouseX < x + w && mouseY > y + dif && mouseY < y + dif + h) {
                this.mode = level;
                fill(GRAY);
                rect(x,y+dif,w,h);
                //do stuff
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("MinesweeperUIMain");
    }

}