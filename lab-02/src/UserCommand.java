import java.util.Scanner;

public class UserCommand {
    public static final String PEN_UP = "PenUp";
    public static final String PEN_DOWN = "PenDown";
    public static final String TURN_LEFT = "TurnLeft";
    public static final String TURN_RIGHT = "TurnRight";
    public static final String MOVE = "Move";
    public static final String PRINT = "Print";
    public static final String EXIT = "Exit";

    private String command;
    private int steps;

    public UserCommand(String line) {
        line = line.trim();
        switch (line) {
            case PEN_UP:
            case PEN_DOWN:
            case PRINT:
            case TURN_LEFT:
            case TURN_RIGHT:
            case EXIT:
                command = line;
                steps = 0;
                return;
        }

        Scanner inpLine = new Scanner(line);
        if(!inpLine.hasNext()) {
            throw new RuntimeException("Wrong command: '"+line+"'");
        }

        String userCommand = inpLine.next();
        if(!userCommand.equals(MOVE)) {
            throw new RuntimeException("Unknown command: '"+line+"'");
        }

        if(!inpLine.hasNextInt()) {
            throw new RuntimeException("No integer in command "+MOVE+": '"+line+"'");
        }

        int numberOfSteps = inpLine.nextInt();
        if(numberOfSteps<0)
        {
            throw new RuntimeException("Negative integer in command "+MOVE+": '"+line+"'");
        }

        if (inpLine.hasNext()) {
            throw new RuntimeException("Too many parameters in command "+MOVE+": '"+line+"'");
        }

        command = userCommand;
        steps = numberOfSteps;
    }

    // getter
    public String getCommand() {
        return command;
    }

    public int getSteps() {
        if(!command.equals("Move")) {
            throw new RuntimeException("Undefined number of steps: current command is not "+MOVE);
        }
        return steps;
    }
}
