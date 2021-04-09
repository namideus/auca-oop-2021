import java.util.Scanner;

// User command
class UserCommand {
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String SHOW = "show";
    public static final String HELP = "help";
    public static final String QUIT = "quit";

    private final String command;
    private int row, col;

    public UserCommand(String line) {
        line = line.trim();
        switch (line) {
            case SHOW:
            case HELP:
            case QUIT:
                command = line;
                return;
        }

        Scanner inpLine = new Scanner(line);
        if (!inpLine.hasNext()) {
            throw new RuntimeException("Wrong command: '" + line + "'");
        }

        String userCommand = inpLine.next();
        if (!userCommand.equals(LEFT) && !userCommand.equals(RIGHT)) {
            throw new RuntimeException("Unknown command: '" + line + "'");
        }

        if (!inpLine.hasNextInt()) {
            throw new RuntimeException("No integer in command " + userCommand + ": '" + line + "'");
        }

        int row = inpLine.nextInt();
        if (row < 0) {
            throw new RuntimeException("Negative row in command " + userCommand + ": '" + line + "'");
        }

        if (!inpLine.hasNext()) {
            throw new RuntimeException("Not enough parameters in command " + userCommand + ": '" + line + "'");
        }

        int col = inpLine.nextInt();
        if (col < 0) {
            throw new RuntimeException("Negative col in command " + userCommand + ": '" + line + "'");
        }

        if (inpLine.hasNext()) {
            throw new RuntimeException("Too many parameters in command " + userCommand + ": '" + line + "'");
        }

        command = userCommand;
        this.row = row;
        this.col = col;
    }

    // Getter
    public String getCommand() {
        return command;
    }

    public int getRow() {
        if (!command.equals(LEFT) && !command.equals(RIGHT)) {
            throw new RuntimeException("Undefined row or col: current command is not " + LEFT + " or " + RIGHT);
        }
        return this.row;
    }

    public int getCol() {
        if (!command.equals(LEFT) && !command.equals(RIGHT)) {
            throw new RuntimeException("Undefined row or col: current command is not " + LEFT + " or " + RIGHT);
        }
        return this.col;
    }
}
