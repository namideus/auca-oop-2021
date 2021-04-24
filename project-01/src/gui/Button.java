package gui;

import processing.core.PApplet;

public class Button
{
    private static final int N = 4;
    private float x,y,width,height;
    private int textColorR,textColorG, textColorB;
    private final PApplet canvas;
    private String text;
    private boolean isPressed;
    private OnClickListener listener;

    public Button(PApplet canvas, float x, float y, float width, float height, String text) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.listener = null;

        drawUnpressed();
    }

    public void drawUnpressed() {
        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.strokeWeight(0f);
        canvas.translate(this.x, this.y);

        canvas.fill(200,200,200);
        canvas.quad(0, 0, 0, height, 4f, height-4f, 4f, 4f);
        canvas.quad(0, 0, width, 0, width-4f, 4f, 4f, 4f);

        canvas.fill(120,120,120);
        canvas.quad(0, height, width, height, width-4f, height-4f, 4f, height-4f);
        canvas.quad(width, height, width, 0, width-4f, 4f, width-4f, height-4f);

        canvas.fill(150,150,150);
        canvas.rect(4f, 4f, width-8, height-8);

        if(text!=null) {
            canvas.textAlign(canvas.CENTER);
            canvas.textSize(20);
            canvas.fill(0, 255, 0);
            canvas.text(text, 95f, height/2f+5f);
        }

        canvas.popStyle();
        canvas.popMatrix();
    }

    public void drawPressed() {
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

        if(text!=null) {
            canvas.textAlign(canvas.CENTER);
            canvas.textSize(20);
            canvas.fill(0, 100, 0);
            canvas.text(text, 97f, height/2f+7f);
        }

        canvas.popStyle();
        canvas.popMatrix();
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
        if(canvas.mousePressed) {
            if (canvas.mouseX > x && canvas.mouseX < x + width && canvas.mouseY > y && canvas.mouseY < y + height) {
                if(this.listener!=null) {
                    this.listener.onClick();
                    drawPressed();
                }
            }
        }
    }

    public void setOnLeftClickListener(OnClickListener listener) {
        this.listener = listener;
        if(canvas.mousePressed) {
            if(canvas.mouseButton==canvas.LEFT) {
                if (canvas.mouseX > x && canvas.mouseX < x + width && canvas.mouseY > y && canvas.mouseY < y + height) {
                    if (this.listener != null) {
                        this.listener.onClick();
                        drawPressed();
                    }
                }
            }
        }
    }

    public void setOnRightClickListener(OnClickListener listener) {
        this.listener = listener;
        if(canvas.mousePressed) {
            if(canvas.mouseButton==canvas.RIGHT) {
                if (canvas.mouseX > x && canvas.mouseX < x + width && canvas.mouseY > y && canvas.mouseY < y + height) {
                    if (this.listener != null) {
                        this.listener.onClick();
                        drawPressed();
                    }
                }
            }
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    interface OnClickListener {
        void onClick();
    }
}


