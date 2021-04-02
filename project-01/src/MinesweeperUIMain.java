import processing.core.*;

public class MinesweeperUIMain extends PApplet {

    final int WIDTH = 500;
    final int HEIGHT = 500;
    final int BLOCKX = WIDTH / 8;
    final int BLOCKY = HEIGHT / 8;

    public void settings() {
        fullScreen();
    }

    public void setup() {

    }

    public void draw() {
        background(0, 0, 0);
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

        float x = width/2f+200f;
        float y = 250f;
        float w = 190f;
        float h = 40f;
        float dif = 70f;

        fill(255,255,255);
        rect(x,y,w,h);
        onClick(x,y,w,h,0, "beginner");

        fill(255,255,255);
        rect(x,y+dif,w,h);
        onClick(x,y,w,h,dif, "intermediate");

        fill(255,255,255);
        rect(x,y+2*dif,w,h);
        onClick(x,y,w,h,2*dif, "expert");
    }

    public void onClick(float x, float y, float w, float h, float dif, String level) {
        if(mousePressed) {
            if (mouseX > x && mouseX < x + w && mouseY > y + dif && mouseY < y + dif + h) {
                println("The mouse is pressed and over the button");
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