import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class Problem02 {
    private static int nLine = 0;

    public static void main(String[] args) {

        try {
            run();
        } catch(RuntimeException e) {
            System.out.println("Your program has a problem in line: "+nLine+":");
            System.out.println("\t"+e.getMessage());
        }

        UserCommand cmd = new UserCommand("TurnLeft");

        if(cmd.equals(UserCommand.EXIT)) {

        }

        System.out.println(cmd.getCommand());
        System.out.println(cmd.getSteps());

    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        Canvas canvas = new Canvas();
        Turtle turtle = new Turtle(canvas,0,0,false,Turtle.EAST); // 1000 ? Exercies

        ++nLine;
        UserCommand cmd = new UserCommand(scanner.nextLine());

        while(!cmd.getCommand().equals(UserCommand.EXIT))
        {
            switch (cmd.getCommand()) {
                case UserCommand.PEN_UP:
                    turtle.penUp();
                    break;
                case UserCommand.PEN_DOWN:
                    turtle.penDown();
                    break;
                case UserCommand.TURN_RIGHT:
                    turtle.turnRight();
                    break;
                case UserCommand.TURN_LEFT:
                    turtle.turnLeft();
                    break;
                case UserCommand.MOVE:
                    turtle.move(cmd.getSteps());
                    break;
                case UserCommand.PRINT:
                    canvas.show();
                    break;
            }
            ++nLine;
            cmd = new UserCommand(scanner.nextLine());
        }
    }
}
