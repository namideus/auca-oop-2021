public class Problem02 {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Turtle turtle = new Turtle(canvas,0,0,false,Turtle.EAST);

        turtle.penDown();
        turtle.move(10);
        turtle.turnRight();
        turtle.move(10);
        turtle.turnRight();
        turtle.move(10);
        turtle.turnRight();

        canvas.show();
    }
}
