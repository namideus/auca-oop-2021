package gui;

import processing.core.PApplet;

public class Digit
{
    private  static final int N = 4;
    private float x,y,width,height;
    private int textColorR,textColorG, textColorB;
    private boolean bounceX,bounceY;
    private final PApplet canvas;

    public Digit(PApplet canvas, float x, float y, float width, float height, String text) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        canvas.pushMatrix();

        canvas.popMatrix();
    }


}
