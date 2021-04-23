package gui;

import processing.core.PApplet;

public class Digit
{
    private  static final int N = 5;
    private int size, digit;
    private float x,y,width,height,radius;
    private final PApplet canvas;

    public Digit(PApplet canvas, float x, float y, float width, float height, int size, int digit) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.size = size;
        this.digit = digit;
    }

    void draw() {
//        canvas.pushMatrix();
//        canvas.pushStyle();
//        canvas.strokeWeight(0f);
//        canvas.translate(this.x, this.y);
//
//        canvas.fill(170,170,170);
//        canvas.quad(0, 0, 0, height, 4f, height-4f, 4f, 4f);
//        canvas.quad(0, 0, width, 0, width-4f, 4f, 4f, 4f);
//
//        canvas.fill(170,170,170);
//        canvas.quad(0, height, width, height, width-4f, height-4f, 4f, height-4f);
//        canvas.quad(width, height, width, 0, width-4f, 4f, width-4f, height-4f);
//
//        canvas.fill(100,100,100);
//        canvas.rect(4f, 4f, width-8, height-8);
//
//        canvas.popStyle();
//        canvas.popMatrix();

        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.translate(this.x, this.y);
        canvas.textAlign(canvas.CENTER);
        canvas.textSize(this.size);

        switch (this.digit) {
            case 1:
                canvas.fill(0, 0, 255);
                break;
            case 2:
                canvas.fill(255, 0, 0);
                break;
            case 3:
                canvas.fill(0, 128, 0);
                break;
            case 4:
                canvas.fill(255, 192, 203);
                break;
            case 5:
                canvas.fill(128,0,128);
                break;
            case 6:
                canvas.fill(255,255,0);
                break;
            case 7:
                canvas.fill(255,165,0);
                break;
            case 8:
                canvas.fill(244,0,161);
                break;
        }
        canvas.text(digit,width/2f, height-height/4f); // Adjacent numbers

        canvas.popStyle();
        canvas.popMatrix();
    }


}
