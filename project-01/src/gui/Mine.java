package gui;

import processing.core.PApplet;

public class Mine
{
    private static final int N = 5;
    private static int explodedRow = -1, explodedCol = -1;
    private int row, col;
    private float x,y,width,height,radius;
    private final PApplet canvas;

    public Mine(PApplet canvas, float x, float y, int row, int col, float width, float height, float radius) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    void draw() {
        canvas.pushMatrix();
        canvas.pushStyle();
        canvas.strokeWeight(0f);
        canvas.translate(this.x, this.y);

        if(row==explodedRow && col==explodedCol)
            canvas.fill(255,0,0);
        else
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

    public static void setExplodedRowCol(int explodedRow, int explodedCol) {
        Mine.explodedCol = explodedCol;
        Mine.explodedRow = explodedRow;
    }
}
