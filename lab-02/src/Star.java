import processing.core.PApplet;

public class Star
{
    private float x,y,dx,dy,r,rc,gc,bc;
    private PApplet canvas;

    public Star(PApplet canvas, float x, float y, float r, float dx, float dy)
    {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.r = r;
        this.rc = canvas.random(0, 255);
        this.gc = canvas.random(0, 255);
        this.bc = canvas.random(0, 255);
    }

    public Star draw() {
        canvas.fill(rc,gc,bc);
        canvas.circle(x,y,r);
        return this;
    }

    public Star move() {
        x+=dx;
        y+=dx;

        if(x>=canvas.width)
        {
            x=canvas.width-1;
            dx = -dx;
        }
        if(x<0)
        {
            x=0;
            dx = -dx;
        }
        if(y>=canvas.height)
        {
            y=canvas.height-1;
            dx = -dx;
        }
        if(y<0)
        {
            y=0;
            dx = -dx;
        }
        return this;
    }
}
