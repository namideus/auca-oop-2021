import java.util.Scanner;

/**
 * @author Iman Augustine
 *
 * Minesweeper game main driver program.
 *
 * */

public class MinesweeperTerminalMain {
    private static String strMode;
    private static Game game;

    public static void main(String[] args) {
        try {
            if(args.length>0) {
                strMode = args[0];
                game = new Game(strMode);
            } else {
                game = new Game(Game.BEGINNER);
            }
            run();
        } catch(RuntimeException e) {
            // System.out.println("Your program has a problem in line: "+nLine+":");
            System.out.println("\t"+e.getMessage());
        }
    }

    // Run program until quit command
    private static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("cmd: ");
        UserCommand cmd = new UserCommand(scanner.nextLine());

        while(!cmd.getCommand().equals(UserCommand.QUIT)) {
            switch (cmd.getCommand()) {
                case UserCommand.LEFT:
                    game.left(cmd.getRow(), cmd.getCol());
                    break;
                case UserCommand.RIGHT:
                    game.right(cmd.getRow(), cmd.getCol());
                    break;
                case UserCommand.SHOW:
                    game.print();
                    break;
            }
            System.out.print("cmd: ");
            cmd = new UserCommand(scanner.nextLine());
        }

        // System.out.println("the field will be mined after first left click\n");

    }
}
