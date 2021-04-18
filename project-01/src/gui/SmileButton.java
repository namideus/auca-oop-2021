package gui;

import processing.core.PApplet;

public class SmileButton //extends java.awt.Button
{
    private float x, y, width, height;
    private final PApplet canvas;
    private boolean isSad;
    private boolean isVictorious;
    private OnClickListener listener;

    public SmileButton(PApplet canvas, float x, float y, float width, float height) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.listener = null;
        this.isSad = false;

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


        canvas.popStyle();
        canvas.popMatrix();

        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.translate(this.x, this.y);
        canvas.fill(255, 255, 0);
        //draw the head
        canvas.strokeWeight(0f);
        canvas.circle(width/2f, height/2f, 50);
        canvas.strokeWeight(3f);
        //white
        canvas.fill(0);
        //draw the eyes
        canvas.circle(width/2f-10f, height/2f-10f, 3);
        canvas.circle(width/2f+10f, height/2f-10f, 3);
        //black
        // draw the pupils
        // circle(x-10f, y-10f, 10);
        // circle(x+10f, y-10f, 10);
        //red
        //fill(255, 0, 0);
        //draw the mouth
        canvas.fill(255, 255, 0);
        // strokeWeight(2f);
        if(!isSad) {
            canvas.arc(width/2f, height/2f+7f, 25, 18, 0, canvas.PI);
        } else {
            canvas.arc(width/2f, height/2f+13f, 25, 18, -canvas.PI, 0);
        }

        canvas.popStyle();
        canvas.popMatrix();
    }

    public void drawPressed() {
        // 3D button
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

        // Smile
        canvas.pushMatrix();
        canvas.pushStyle();

        canvas.translate(this.x, this.y);
        canvas.fill(255, 255, 0);
        //draw the head
        canvas.strokeWeight(0f);
        canvas.circle(width/2f+2f, height/2f+2f, 50);
        canvas.strokeWeight(3f);
        //white
        canvas.fill(0);
        //draw the eyes
        canvas.circle(width/2f-10f+2f, height/2f-10f+2f, 3);
        canvas.circle(width/2f+10f+2f, height/2f-10f+2f, 3);
        //black
        // draw the pupils
        // circle(x-10f, y-10f, 10);
        // circle(x+10f, y-10f, 10);
        //red
        //fill(255, 0, 0);
        //draw the mouth
        canvas.fill(255, 255, 0);
        // strokeWeight(2f);
        if(!isSad) {
            canvas.arc(width/2f+2f, height/2f+7f+2f, 25, 18, 0, canvas.PI);
        } else {
            canvas.arc(width/2f+2f, height/2f+13f+2f, 25, 18, -canvas.PI, 0);
        }
        if(!isVictorious) {
            canvas.arc(width/2f+2f, height/2f+7f+2f, 25, 18, 0, canvas.PI);
        } else {
            canvas.arc(width/2f+2f, height/2f+13f+2f, 25, 18, -canvas.PI, 0);
        }
        canvas.popStyle();
        canvas.popMatrix();
    }

    public void setIsSad(boolean isSad) {
        this.isSad = isSad;
        drawUnpressed();
    }

    public void setVictorious(boolean isVictorious) {
        this.isVictorious = isVictorious;
        drawUnpressed();
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

    interface OnClickListener {
        void onClick();
    }
}


