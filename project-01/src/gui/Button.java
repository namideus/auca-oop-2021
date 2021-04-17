package gui;

import processing.core.PApplet;

public class Button //extends java.awt.Button
{
    private  static final int N = 4;
    private float x,y,width,height;
    private int textColorR,textColorG, textColorB;
    private final PApplet canvas;
    private boolean isPressed;

    public Button(PApplet canvas, float x, float y, float width, float height, String text) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.strokeWeight(0);
        canvas.translate(this.x, this.y);
        canvas.fill(200,200,200);
        canvas.quad(0, 0, 0, height, 4f, height-4f, 4f, 4f);
        canvas.quad(0, 0, width, 0, width-4f, 4f, 4f, 4f);
        canvas.fill(120,120,120);
        canvas.quad(0, height, width, height, width-4f, height-4f, 4f, height-4f);
        canvas.quad(width, height, width, 0, width-4f, 4f, width-4f, height-4f);
        canvas.fill(150,150,150);
        canvas.rect(4f, 4f, width-8, height-8);
        canvas.popStyle();
        canvas.popMatrix();
    }

}

interface OnClickListener {
    void onClick();
}

