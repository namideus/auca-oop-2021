package gui;

import processing.core.PApplet;

public class Flag
{
    private float x,y,width,height;
    private final PApplet canvas;

    public Flag(PApplet canvas, float x, float y, float width, float height) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.strokeWeight(0f);
        canvas.translate(this.x, this.y);

        canvas.fill(0);
        canvas.rect(width/2f-1f, 6f, 2f, height-14f);
        canvas.rect(7f, height-10f, 21f, 4f);
        canvas.triangle(6f,13f,width/2f-1f, 6f,width/2f-1f, 18f);
        canvas.fill(255,0,0);
        canvas.triangle(8f,13f,width/2f-2f, 8f,width/2f-2f, 16f);

        canvas.popStyle();
        canvas.popMatrix();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
