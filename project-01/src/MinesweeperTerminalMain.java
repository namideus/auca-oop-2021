import java.util.Scanner;

/**
 * @author Iman Augustine
 *
 * Minesweeper game main driver program.
 *
 * */

public class MinesweeperTerminalMain {
    private static Game game;

    public static void main(String[] args) {
        try {

            if(args.length==0) {
                game = new Game(Game.BEGINNER);
            } else if(args.length==1) {
                game = new Game(args[0]);
            } else if(args.length==3) {
                game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[1]));
            }

            game.help();
            game.print();

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
                    game.print();
                    break;
                case UserCommand.RIGHT:
                    game.right(cmd.getRow(), cmd.getCol());
                    game.print();
                    break;
                case UserCommand.SHOW:
                    game.print();
                    break;
                case UserCommand.HELP:
                    game.help();
                    break;
            }
            System.out.print("cmd: ");
            cmd = new UserCommand(scanner.nextLine());
        }
    }
}
