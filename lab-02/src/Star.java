import processing.core.PApplet;

public class Star
{
    private  static final int N = 4;
    private float x,y,dx,dy,r,rc,gc,bc,angle,dAngle;
    private final PApplet canvas;

    public Star(PApplet canvas, float x, float y, float r, float dx, float dy, float dAngle)
    {
        if(r<=0) {
            throw new RuntimeException("Star: negative radius");
        }
        this.angle = 0;
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.r = r;
        this.rc = canvas.random(0, 255);
        this.gc = canvas.random(0, 255);
        this.bc = canvas.random(0, 255);
        this.dAngle = dAngle;
    }

    public void draw() {
        canvas.background(0);

        canvas.pushMatrix();
        canvas.translate(x,y);
        canvas.rotate(angle);
        canvas.stroke(255);
        for(int i=0; i<N; ++i) {
            canvas.rotate((float) (Math.PI/N));
            canvas.line(-r,0,r,0);
        }
        canvas.popMatrix();

        //canvas.fill(rc,gc,bc);
        //canvas.circle(x,y,r);
    }

    public void move() {
        x+=dx;
        y+=dx;
        angle+=dAngle;

        if(canvas.keyPressed)
        {
            dAngle = -dAngle;
        }
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
            dy = -dy;
        }
        if(y<0)
        {
            y=0;
            dy = -dy;
        }
    }
}
