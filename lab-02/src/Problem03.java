import processing.core.PApplet;

public class Problem03 extends PApplet {
    Star[] stars = new Star[100];

    public void settings() {
        fullScreen();
    }

    public void setup() {
        frameRate(60);

        for(int i=0; i<stars.length; ++i) {
            stars[i] = new Star(this,
                    random(width), random(height), random(10, 30),
                    random(-10, 10), random(-10, 10),
                    random(-(float)Math.PI/100, (float)Math.PI/100));
        }
    }

    public void draw() {
        background(0, 0, 0);

        for (Star star : stars) {
            star.draw();
            star.move();
        }

    }

    public static void main(String[] args) {
        PApplet.main("Problem03");
    }

}
