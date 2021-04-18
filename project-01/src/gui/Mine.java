package gui;

import processing.core.PApplet;

public class Mine
{
    private  static final int N = 5;
    private float x,y,width,height,radius;
    private final PApplet canvas;

    public Mine(PApplet canvas, float x, float y, float width, float height, float radius) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = radius;

        draw();
    }

    private void draw() {
        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.strokeWeight(0f);
        canvas.translate(this.x, this.y);

        canvas.fill(170,170,170);
        canvas.quad(0, 0, 0, height, 4f, height-4f, 4f, 4f);
        canvas.quad(0, 0, width, 0, width-4f, 4f, 4f, 4f);

        canvas.fill(170,170,170);
        canvas.quad(0, height, width, height, width-4f, height-4f, 4f, height-4f);
        canvas.quad(width, height, width, 0, width-4f, 4f, width-4f, height-4f);

        canvas.fill(100,100,100);
        canvas.rect(4f, 4f, width-8, height-8);

        canvas.popStyle();
        canvas.popMatrix();

        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.stroke(0);
        canvas.strokeWeight(3f);
        canvas.translate(this.x+17f, this.y+17f);

        for(int i=0; i<N; ++i) {
            canvas.rotate((float) (Math.PI/N));
            canvas.line(-radius,0,radius,0);
        }

        canvas.popStyle();
        canvas.popMatrix();
    }


}
