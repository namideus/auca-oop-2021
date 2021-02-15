import processing.core.PApplet;

public class Problem03 extends PApplet {
    int x, y;
    int dx;
    Star[] stars = new Star[100];

    public void settings() {
        fullScreen();
    }

    public void setup() {
        x = width/2;
        y = height/2;
        dx = 10;

        for(int i=0; i<100; ++i)
            stars[i] = new Star(
                    this,
                    random(width),
                    random(height),
                    random(10,30),
                    random(1,10),
                    random(1,10));

        frameRate(60);
    }

    public void draw() {
        background(0, 0, 0);

        for(int i=0; i<100; ++i) {
            stars[i].draw().move();
        }

    }

    public static void main(String[] args) {
        PApplet.main("Problem03");
    }

}
